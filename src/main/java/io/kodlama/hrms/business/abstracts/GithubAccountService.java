package io.kodlama.hrms.business.abstracts;

import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.entities.concretes.GithubAccount;

public interface GithubAccountService {
	Result add(GithubAccount githubAccount);
}
