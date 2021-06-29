package io.kodlama.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kodlama.hrms.business.abstracts.GithubAccountService;

@RestController
@RequestMapping("/api/githubaccounts/")
public class GithubAccountsController {

	private GithubAccountService githubAccountService;
	
	@Autowired
	public GithubAccountsController(GithubAccountService githubAccountService) {
		this.githubAccountService = githubAccountService;
	}
	
}
