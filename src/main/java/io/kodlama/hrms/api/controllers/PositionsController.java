package io.kodlama.hrms.api.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.kodlama.hrms.business.abstracts.PositionService;
import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.entities.concretes.Position;

@RestController
@RequestMapping("/api/positions/")
public class PositionsController {
	
	private PositionService positionService;

	public PositionsController(PositionService positionService) {
		this.positionService = positionService;
	}

	@GetMapping("getall")
	public DataResult<List<Position>> getAll() {
		return this.positionService.getAll();
	}

	@PostMapping("add")
	public Result add(@RequestBody Position position) {
		return this.positionService.add(position);
	}

}
