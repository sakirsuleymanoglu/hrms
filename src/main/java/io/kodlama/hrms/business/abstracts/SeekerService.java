package io.kodlama.hrms.business.abstracts;

import java.util.List;

import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.entities.concretes.Seeker;
import io.kodlama.hrms.entities.dtos.SeekerRegisterDto;

public interface SeekerService {
	Result add(SeekerRegisterDto seekerRegisterDo);

	DataResult<List<Seeker>> getAll();
}
