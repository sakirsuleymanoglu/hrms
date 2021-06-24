package io.kodlama.hrms.business.abstracts;

import java.util.List;

import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.entities.concretes.Employer;
import io.kodlama.hrms.entities.dtos.EmployerRegisterDto;

public interface EmployerService {
	Result add(EmployerRegisterDto employerRegisterDto);
	DataResult<List<Employer>> getAll();
}
