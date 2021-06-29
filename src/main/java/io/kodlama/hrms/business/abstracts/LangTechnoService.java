package io.kodlama.hrms.business.abstracts;

import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.entities.concretes.LangTechno;

public interface LangTechnoService {
	Result add(LangTechno langTechno);
}
