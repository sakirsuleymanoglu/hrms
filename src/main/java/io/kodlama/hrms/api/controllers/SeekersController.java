package io.kodlama.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kodlama.hrms.business.abstracts.SeekerService;
import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.entities.concretes.Seeker;
import io.kodlama.hrms.entities.dtos.SeekerRegisterDto;

@RestController
@RequestMapping("/api/seekers/")
public class SeekersController {

	private SeekerService seekerService;

	@Autowired
	public SeekersController(SeekerService seekerService) {
		this.seekerService = seekerService;
	}

	@PostMapping("add")
	public Result add(@RequestBody SeekerRegisterDto seekerRegisterDto) {
		return this.seekerService.add(seekerRegisterDto);
	}

	@GetMapping("getall")
	public DataResult<List<Seeker>> getAll() {
		return this.seekerService.getAll();
	}

}
