package io.kodlama.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.kodlama.hrms.business.abstracts.UserService;
import io.kodlama.hrms.core.entities.User;
import io.kodlama.hrms.core.utilities.results.DataResult;

@RestController
@RequestMapping("/api/users/")
public class UsersController {
	private UserService userService;

	public UsersController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("getall")
	public DataResult<List<User>> getAll() {
		return this.userService.getAll();
	}
}
