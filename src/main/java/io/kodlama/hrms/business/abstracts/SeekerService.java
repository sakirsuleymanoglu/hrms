package io.kodlama.hrms.business.abstracts;

import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.entities.dtos.SeekerRegisterDto;

public interface SeekerService {
	Result add(SeekerRegisterDto seekerRegisterDo);
}
