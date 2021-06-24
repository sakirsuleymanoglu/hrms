package io.kodlama.hrms.business.abstracts;

import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.entities.dtos.EmployerRegisterDto;

public interface EmployerService {
	Result add(EmployerRegisterDto employerRegisterDto);
}
