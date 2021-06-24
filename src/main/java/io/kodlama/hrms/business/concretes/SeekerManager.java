package io.kodlama.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.kodlama.hrms.business.abstracts.SeekerService;
import io.kodlama.hrms.business.checks.FakeCheckService;
import io.kodlama.hrms.business.checks.KPSPublicAdapter;
import io.kodlama.hrms.business.checks.SeekerCheckTool;
import io.kodlama.hrms.core.business.BusinessRules;
import io.kodlama.hrms.core.dataAccess.UserDao;
import io.kodlama.hrms.core.entities.User;
import io.kodlama.hrms.core.utilities.results.ErrorResult;
import io.kodlama.hrms.core.utilities.results.Result;
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

		Result checkServiceResult = SeekerCheckTool.check(new FakeCheckService(), seekerRegisterDto.getNationalityId(),
				seekerRegisterDto.getName(), seekerRegisterDto.getSurname(), seekerRegisterDto.getDateOfBirth());

		Result result = BusinessRules.run(checkServiceResult);

		if (result != null) {
			return result;
		}

		if (seekerRegisterDto.getPassword() == seekerRegisterDto.getConfirmPassword()) {

			User user = new User(seekerRegisterDto.getEmail(), seekerRegisterDto.getPassword());

			this.userDao.save(user);

		} else {
			return new ErrorResult("Parola uyuşmazlığı");
		}

		User user = this.userDao.findByEmail(seekerRegisterDto.getEmail());

		if (user != null) {

			Seeker seeker = new Seeker();
			seeker.setUser(user);
			seeker.setNationalityId(seekerRegisterDto.getNationalityId());
			seeker.setName(seekerRegisterDto.getName());
			seeker.setSurname(seekerRegisterDto.getSurname());
			seeker.setDateOfBirth(seekerRegisterDto.getDateOfBirth());

			return new SuccessResult("Kayıt başarıyla gerçekleşti");

		} else {

			return new ErrorResult("Kayıt gerçekleşemedi");
		}

	}

}
