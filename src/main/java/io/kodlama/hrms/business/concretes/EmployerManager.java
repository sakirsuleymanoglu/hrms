package io.kodlama.hrms.business.concretes;

import org.springframework.stereotype.Service;

import io.kodlama.hrms.business.abstracts.EmployerService;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.dataAccess.abstracts.EmployerDao;
import io.kodlama.hrms.entities.dtos.EmployerRegisterDto;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;

	public EmployerManager(EmployerDao employerDao) {
		this.employerDao = employerDao;
	}

	@Override
	public Result add(EmployerRegisterDto employerRegisterDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
