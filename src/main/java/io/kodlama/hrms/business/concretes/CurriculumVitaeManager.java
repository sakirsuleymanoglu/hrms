package io.kodlama.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.kodlama.hrms.business.abstracts.CurriculumVitaeService;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.core.utilities.results.SuccessResult;
import io.kodlama.hrms.dataAccess.abstracts.CurriculumVitaeDao;
import io.kodlama.hrms.entities.concretes.CurriculumVitae;

@Service
public class CurriculumVitaeManager implements CurriculumVitaeService {

	private CurriculumVitaeDao curriculumVitaeDao;
	
	@Autowired
	public CurriculumVitaeManager(CurriculumVitaeDao curriculumVitaeDao) {
		this.curriculumVitaeDao = curriculumVitaeDao;
	}
	
	@Override
	public Result add(CurriculumVitae curriculumVitae) {
		
		this.curriculumVitaeDao.save(curriculumVitae);
		
		return new SuccessResult("Özgeçmiş eklendi");
	}

}
