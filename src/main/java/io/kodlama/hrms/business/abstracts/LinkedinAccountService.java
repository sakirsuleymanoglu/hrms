package io.kodlama.hrms.business.abstracts;

import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.entities.concretes.LinkedinAccount;

public interface LinkedinAccountService {
	Result add(LinkedinAccount linkedinAccount);
}
