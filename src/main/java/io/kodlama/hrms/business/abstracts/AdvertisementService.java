package io.kodlama.hrms.business.abstracts;

import java.util.Date;
import java.util.List;

import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.entities.concretes.Advertisement;

public interface AdvertisementService {
	DataResult<List<Advertisement>> getAll();

	DataResult<List<Advertisement>> getAllByReleaseDate(Date releaseDate);

	DataResult<List<Advertisement>> getAllByEmployer(int employerId);

	Result makeStatusPassive(Advertisement advertisement);
	
	Result makeStatusActive(Advertisement advertisement);
}
