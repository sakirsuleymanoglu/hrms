package io.kodlama.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.kodlama.hrms.business.abstracts.GithubAccountService;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.core.utilities.results.SuccessResult;
import io.kodlama.hrms.dataAccess.abstracts.GithubAccountDao;
import io.kodlama.hrms.entities.concretes.GithubAccount;

@Service
public class GithubAccountManager implements GithubAccountService {

	private GithubAccountDao githubAccountDao;
	
	@Autowired
	public GithubAccountManager(GithubAccountDao githubAccountDao) {
		this.githubAccountDao = githubAccountDao;
	}
	
	@Override
	public Result add(GithubAccount githubAccount) {
		
		this.githubAccountDao.save(githubAccount);
		
		return new SuccessResult("Github adresi eklendi");
		
	}

	
}
