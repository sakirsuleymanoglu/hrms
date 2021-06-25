package io.kodlama.hrms.dataAccess.abstracts;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.kodlama.hrms.entities.concretes.Advertisement;

public interface AdvertisementDao extends JpaRepository<Advertisement, Integer> {
	List<Advertisement> getByStatus(boolean status);

	List<Advertisement> getByReleaseDate(Date releaseDate);

	List<Advertisement> getByEmployer(int employerId);
}
