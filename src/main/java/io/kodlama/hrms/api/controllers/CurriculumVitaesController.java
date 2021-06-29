package io.kodlama.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kodlama.hrms.business.abstracts.CurriculumVitaeService;

@RestController
@RequestMapping("/api/curriculumvitaes/")
public class CurriculumVitaesController {

	private CurriculumVitaeService curriculumVitaeService;
	
	@Autowired
	public CurriculumVitaesController(CurriculumVitaeService curriculumVitaeService) {
		this.curriculumVitaeService = curriculumVitaeService;
	}
	
}
