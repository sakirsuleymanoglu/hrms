package io.kodlama.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.kodlama.hrms.business.abstracts.LangTechnoService;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.core.utilities.results.SuccessResult;
import io.kodlama.hrms.dataAccess.abstracts.LangTechnoDao;
import io.kodlama.hrms.entities.concretes.LangTechno;

@Service
public class LangTechoManager implements LangTechnoService {

	private LangTechnoDao langTechnoDao;

	@Autowired
	public LangTechoManager(LangTechnoDao langTechnoDao) {
		this.langTechnoDao = langTechnoDao;
	}

	@Override
	public Result add(LangTechno langTechno) {

		this.langTechnoDao.save(langTechno);

		return new SuccessResult("Programlama Dili/Teknoloji eklendi");
	}

}
