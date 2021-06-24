package io.kodlama.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.kodlama.hrms.business.abstracts.SeekerService;
import io.kodlama.hrms.business.checks.FakeCheckService;
import io.kodlama.hrms.business.checks.SeekerCheckTool;
import io.kodlama.hrms.core.business.BusinessRules;
import io.kodlama.hrms.core.dataAccess.UserDao;
import io.kodlama.hrms.core.entities.User;
import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.ErrorResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.core.utilities.results.SuccessDataResult;
import io.kodlama.hrms.core.utilities.results.SuccessResult;
import io.kodlama.hrms.dataAccess.abstracts.SeekerDao;
import io.kodlama.hrms.entities.concretes.Seeker;
import io.kodlama.hrms.entities.dtos.SeekerRegisterDto;

@Service
public class SeekerManager implements SeekerService {

	private SeekerDao seekerDao;
	private UserDao userDao;

	@Autowired
	public SeekerManager(SeekerDao seekerDao, UserDao userDao) {
		this.seekerDao = seekerDao;
		this.userDao = userDao;
	}

	@Override
	public Result add(SeekerRegisterDto seekerRegisterDto) {

		Result checkServiceResult = SeekerCheckTool.check(new FakeCheckService(),
				new Seeker(seekerRegisterDto.getNationalityId(), seekerRegisterDto.getName(),
						seekerRegisterDto.getSurname(), seekerRegisterDto.getDateOfBirth()));

		Result result = BusinessRules.run(checkServiceResult,
				checkIfPasswordAndConfirmPasswordIsEqual(seekerRegisterDto.getPassword(),
						seekerRegisterDto.getConfirmPassword()),
				checkIfAlreadyExistsEmail(seekerRegisterDto.getEmail()),
				checkIfAlreadyExistsNationalityId(seekerRegisterDto.getNationalityId()));

		if (result != null) {
			return result;
		}

		this.userDao.save(new User(seekerRegisterDto.getEmail(), seekerRegisterDto.getPassword()));

		User user = this.userDao.findByEmail(seekerRegisterDto.getEmail());

		if (user != null) {

			Seeker seeker = new Seeker(user, seekerRegisterDto.getNationalityId(), seekerRegisterDto.getName(),
					seekerRegisterDto.getSurname(), seekerRegisterDto.getDateOfBirth());

			this.seekerDao.save(seeker);

			return new SuccessResult("Kayıt başarıyla gerçekleşti");

		} else {

			return new ErrorResult("Kayıt gerçekleşemedi");
		}

	}

	private Result checkIfAlreadyExistsNationalityId(String nationalityId) {
		Seeker seeker = this.seekerDao.getByNationalityId(nationalityId);

		if (seeker != null) {
			return new ErrorResult("Kullanıcı zaten mevcut");
		}

		return new SuccessResult();
	}

	private Result checkIfAlreadyExistsEmail(String email) {
		User user = this.userDao.findByEmail(email);

		if (user != null) {
			return new ErrorResult("Kullanıcı zaten mevcut");
		}

		return new SuccessResult();
	}

	private Result checkIfPasswordAndConfirmPasswordIsEqual(String password, String confirmPassword) {
		if (!password.equals(confirmPassword)) {
			return new ErrorResult("Parola uyuşmazlığı");
		}
		return new SuccessResult();
	}

	@Override
	public DataResult<List<Seeker>> getAll() {
		return new SuccessDataResult<List<Seeker>>(this.seekerDao.findAll(), "İş arayanlar listelendi");
	}

}
