package io.kodlama.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.kodlama.hrms.business.abstracts.EmployerService;
import io.kodlama.hrms.core.business.BusinessRules;
import io.kodlama.hrms.core.dataAccess.UserDao;
import io.kodlama.hrms.core.entities.User;
import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.ErrorResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.core.utilities.results.SuccessDataResult;
import io.kodlama.hrms.core.utilities.results.SuccessResult;
import io.kodlama.hrms.dataAccess.abstracts.EmployerDao;
import io.kodlama.hrms.entities.concretes.Employer;
import io.kodlama.hrms.entities.concretes.Seeker;
import io.kodlama.hrms.entities.dtos.EmployerRegisterDto;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private UserDao userDao;

	@Autowired
	public EmployerManager(EmployerDao employerDao, UserDao userDao) {
		this.employerDao = employerDao;
		this.userDao = userDao;
	}

	@Override
	public Result add(EmployerRegisterDto employerRegisterDto) {

		Result result = BusinessRules.run(
				checkIfIsTheEmailWithTheSameDomainAsTheWebSite(employerRegisterDto.getEmail(),
						employerRegisterDto.getWebSite()),
				checkIfAlreadyExistsEmail(employerRegisterDto.getEmail()), checkIfPasswordAndConfirmPasswordIsEqual(
						employerRegisterDto.getPassword(), employerRegisterDto.getConfirmPassword()));

		if (result != null) {
			return result;
		}

		this.userDao.save(new User(employerRegisterDto.getEmail(), employerRegisterDto.getPassword()));

		User user = this.userDao.findByEmail(employerRegisterDto.getEmail());

		if (user != null) {

			Employer employer = new Employer(user, employerRegisterDto.getCompanyName(), employerRegisterDto.getWebSite(), employerRegisterDto.getTelephoneNumber(), false);

			this.employerDao.save(employer);
		

			return new SuccessResult("Kay??t ba??ar??yla ger??ekle??ti");

		} else {

			return new ErrorResult("Kay??t ger??ekle??emedi");
		}
	}

	private Result checkIfAlreadyExistsEmail(String email) {
		User user = this.userDao.findByEmail(email);

		if (user != null) {
			return new ErrorResult("Kullan??c?? zaten mevcut");
		}

		return new SuccessResult();
	}

	private Result checkIfPasswordAndConfirmPasswordIsEqual(String password, String confirmPassword) {
		if (!password.equals(confirmPassword)) {
			return new ErrorResult("Parola uyu??mazl??????");
		}
		return new SuccessResult();
	}

	private Result checkIfIsTheEmailWithTheSameDomainAsTheWebSite(String email, String webSite) {

		int indexEmail = email.indexOf("@");

		String subEmail = email.substring(indexEmail + 1);

		int indexWebSite = webSite.indexOf(".");

		String subWebSite = webSite.substring(indexWebSite + 1);

		if (!subEmail.equals(subWebSite)) {
			return new ErrorResult("L??tfen web sitesi ile ayn?? domaine sahip bir e-posta girin");
		}

		return new SuccessResult();
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "???? verenler listelendi");
	}

	@Override
	public Result makeStatusPassive(Employer employer) {
		employer.setStatus(false);
		this.employerDao.save(employer);
		return new SuccessResult("???? veren hesab?? pasif hale getirildi");
	}

	@Override
	public Result makeStatusActive(Employer employer) {
		employer.setStatus(true);
		this.employerDao.save(employer);
		return new SuccessResult("???? veren hesab?? onayland?? ve aktif hale getirildi");
	}

}
