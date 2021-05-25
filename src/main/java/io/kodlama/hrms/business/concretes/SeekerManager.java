package io.kodlama.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.kodlama.hrms.business.abstracts.SeekerService;
import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.SuccessDataResult;
import io.kodlama.hrms.dataAccess.abstracts.SeekerDao;
import io.kodlama.hrms.entities.concretes.Seeker;

@Service
public class SeekerManager implements SeekerService {

	private SeekerDao seekerDao;
	
	@Autowired
	public SeekerManager(SeekerDao seekerDao) {
		this.seekerDao = seekerDao;
	}
	
	@Override
	public DataResult<List<Seeker>> getAll() {
		return new SuccessDataResult<List<Seeker>>(this.seekerDao.findAll());
	}

}