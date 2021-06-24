package io.kodlama.hrms.business.checks;

import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.entities.concretes.Seeker;

public class SeekerCheckTool {
	public static Result check(SeekerCheckService seekerCheckService, Seeker seeker) {
		return seekerCheckService.check(seeker);
	}
}
