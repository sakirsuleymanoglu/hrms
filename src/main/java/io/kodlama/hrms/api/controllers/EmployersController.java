package io.kodlama.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kodlama.hrms.business.abstracts.EmployerService;
import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.entities.concretes.Employer;
import io.kodlama.hrms.entities.dtos.EmployerRegisterDto;

@RestController
@RequestMapping("/api/employers/")
public class EmployersController {

	private EmployerService employerService;

	@Autowired
	public EmployersController(EmployerService employerService) {
		this.employerService = employerService;
	}

	@PostMapping("add")
	public Result add(@RequestBody EmployerRegisterDto employerRegisterDto) {
		return this.employerService.add(employerRegisterDto);
	}

	@GetMapping("getall")
	public DataResult<List<Employer>> getAll() {
		return this.employerService.getAll();
	}
}
