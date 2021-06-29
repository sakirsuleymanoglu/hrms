package io.kodlama.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.kodlama.hrms.business.abstracts.ExperienceService;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.core.utilities.results.SuccessResult;
import io.kodlama.hrms.dataAccess.abstracts.ExperienceDao;
import io.kodlama.hrms.entities.concretes.Experience;

@Service
public class ExperienceManager implements ExperienceService {
	
	private ExperienceDao experienceDao;
	
	@Autowired
	public ExperienceManager(ExperienceDao experienceDao) {
		this.experienceDao = experienceDao;
	}

	@Override
	public Result add(Experience experience) {
		
		this.experienceDao.save(experience);
		
		return new SuccessResult("İş deneyimi eklendi");
	}
	
}
