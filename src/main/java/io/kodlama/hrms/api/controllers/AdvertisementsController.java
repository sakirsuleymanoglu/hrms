package io.kodlama.hrms.api.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.kodlama.hrms.business.abstracts.AdvertisementService;
import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.entities.concretes.Advertisement;

@RestController
@RequestMapping("/api/advertisements/")
public class AdvertisementsController {
	private AdvertisementService advertisementService;

	@Autowired
	public AdvertisementsController(AdvertisementService advertisementService) {
		this.advertisementService = advertisementService;
	}

	@GetMapping("getall")
	public DataResult<List<Advertisement>> getAll() {
		return this.advertisementService.getAll();
	}

	@GetMapping("getallbyreleasedate")
	public DataResult<List<Advertisement>> getAllByReleaseDate(@RequestParam Date releaseDate) {
		return this.advertisementService.getAllByReleaseDate(releaseDate);
	}

	@GetMapping("getallbyemployer")
	public DataResult<List<Advertisement>> getAllByEmployer(@RequestParam int employerId) {
		return this.advertisementService.getAllByEmployer(employerId);
	}

	@PostMapping("makestatuspassive")
	public Result makeStatusPassive(@RequestBody Advertisement advertisement) {
		return this.advertisementService.makeStatusPassive(advertisement);
	}

	@PostMapping("makestatusactive")
	public Result makeStatusActive(@RequestBody Advertisement advertisement) {
		return this.advertisementService.makeStatusActive(advertisement);
	}
}
