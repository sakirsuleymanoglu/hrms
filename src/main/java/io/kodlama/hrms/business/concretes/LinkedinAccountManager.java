package io.kodlama.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.kodlama.hrms.business.abstracts.LinkedinAccountService;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.core.utilities.results.SuccessResult;
import io.kodlama.hrms.dataAccess.abstracts.LinkedinAccountDao;
import io.kodlama.hrms.entities.concretes.LinkedinAccount;

@Service
public class LinkedinAccountManager implements LinkedinAccountService {

	private LinkedinAccountDao linkedinAccountDao;

	@Autowired
	public LinkedinAccountManager(LinkedinAccountDao linkedinAccountDao) {
		this.linkedinAccountDao = linkedinAccountDao;
	}

	@Override
	public Result add(LinkedinAccount linkedinAccount) {

		this.linkedinAccountDao.save(linkedinAccount);

		return new SuccessResult();

	}

}
