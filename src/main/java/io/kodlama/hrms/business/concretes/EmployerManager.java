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

		return null;
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

	private Result checkIfIsTheEmailWithTheSameDomainAsTheWebSite(String email, String webSite) {

		int indexEmail = email.indexOf("@");

		String subEmail = email.substring(indexEmail + 1);

		int indexWebSite = webSite.indexOf(".");

		String subWebSite = webSite.substring(indexWebSite + 1);

		if (!subEmail.equals(subWebSite)) {
			return new ErrorResult("Lütfen web sitesi ile aynı domaine sahip bir e-posta girin");
		}

		return new SuccessResult();
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "İş verenler listelendi");
	}

}
