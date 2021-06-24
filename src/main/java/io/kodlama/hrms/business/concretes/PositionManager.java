package io.kodlama.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.kodlama.hrms.business.abstracts.PositionService;
import io.kodlama.hrms.core.business.BusinessRules;
import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.ErrorResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.core.utilities.results.SuccessDataResult;
import io.kodlama.hrms.core.utilities.results.SuccessResult;
import io.kodlama.hrms.dataAccess.abstracts.PositionDao;
import io.kodlama.hrms.entities.concretes.Position;

@Service
public class PositionManager implements PositionService {

	private PositionDao positionDao;

	@Autowired
	public PositionManager(PositionDao positionDao) {
		this.positionDao = positionDao;
	}

	@Override
	public DataResult<List<Position>> getAll() {
		return new SuccessDataResult<List<Position>>(this.positionDao.findAll());
	}

	@Override
	public Result add(Position position) {
		
		Result result = BusinessRules.run(checkIfAlreadyExistsPosition(position.getName()));
		
		if (result != null) {	
			return result;	
		}

		this.positionDao.save(position);
		
		return new SuccessResult("Pozisyon eklendi");
	}

	private Result checkIfAlreadyExistsPosition(String name) {
		Position position = this.positionDao.getByName(name);
		if (position != null) {
			return new ErrorResult("Pozisyon zaten mevcut");
		}
		return new SuccessResult();
	}

}
