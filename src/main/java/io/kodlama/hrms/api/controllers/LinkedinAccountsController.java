package io.kodlama.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kodlama.hrms.business.abstracts.LinkedinAccountService;

@RestController
@RequestMapping("/api/linkedinaccounts/")
public class LinkedinAccountsController {

	private LinkedinAccountService linkedinAccountService;
	
	@Autowired
	public LinkedinAccountsController(LinkedinAccountService linkedinAccountService) {
		this.linkedinAccountService = linkedinAccountService;
	}
	
}
