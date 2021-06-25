package io.kodlama.hrms.business.concretes;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.kodlama.hrms.business.abstracts.AdvertisementService;
import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.core.utilities.results.SuccessDataResult;
import io.kodlama.hrms.core.utilities.results.SuccessResult;
import io.kodlama.hrms.dataAccess.abstracts.AdvertisementDao;
import io.kodlama.hrms.entities.concretes.Advertisement;

@Service
public class AdvertisementManager implements AdvertisementService {

	private AdvertisementDao advertisementDao;

	@Autowired
	public AdvertisementManager(AdvertisementDao advertisementDao) {
		this.advertisementDao = advertisementDao;
	}

	@Override
	public DataResult<List<Advertisement>> getAll() {
		return new SuccessDataResult<List<Advertisement>>(this.advertisementDao.getByStatus(true),
				"iş ilanları listelendi");
	}

	@Override
	public DataResult<List<Advertisement>> getAllByReleaseDate(Date releaseDate) {
		return new SuccessDataResult<List<Advertisement>>(this.advertisementDao.getByReleaseDate(releaseDate),
				"İş ilanları listelendi");
	}

	@Override
	public DataResult<List<Advertisement>> getAllByEmployer(int employerId) {
		return new SuccessDataResult<List<Advertisement>>(this.advertisementDao.getByEmployer(employerId),
				"İş ilanları listelendi");
	}

	@Override
	public Result makeStatusPassive(Advertisement advertisement) {
		advertisement.setStatus(false);
		this.advertisementDao.save(advertisement);
		return new SuccessResult("İş ilanı pasif hale getirildi");
	}

	@Override
	public Result makeStatusActive(Advertisement advertisement) {
		advertisement.setStatus(true);
		this.advertisementDao.save(advertisement);
		return new SuccessResult("İş ilanı aktif hale getirildi");
	}

}
