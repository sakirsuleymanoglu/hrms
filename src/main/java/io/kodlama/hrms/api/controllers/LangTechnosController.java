package io.kodlama.hrms.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kodlama.hrms.business.abstracts.LangTechnoService;

@RestController
@RequestMapping("/api/langtechnos/")
public class LangTechnosController {

	private LangTechnoService langTechnoService;

	public LangTechnosController(LangTechnoService langTechnoService) {
		this.langTechnoService = langTechnoService;
	}

}
