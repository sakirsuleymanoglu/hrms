package io.kodlama.hrms.business.abstracts;

import java.util.List;
import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.entities.concretes.Position;

public interface PositionService {
	DataResult<List<Position>> getAll();
}