package io.kodlama.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import io.kodlama.hrms.business.abstracts.UserService;
import io.kodlama.hrms.core.dataAccess.UserDao;
import io.kodlama.hrms.core.entities.User;
import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.SuccessDataResult;

@Service
public class UserManager implements UserService {

	private UserDao userDao;

	public UserManager(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<User>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<User>>(this.userDao.findAll(), "Kullanıcılar listelendi");
	}

}
