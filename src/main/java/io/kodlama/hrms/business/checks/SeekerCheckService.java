package io.kodlama.hrms.business.checks;

import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.entities.concretes.Seeker;

public interface SeekerCheckService {
	Result check(String nationalityId, String name, String surname, String dateOfBirth);
}
