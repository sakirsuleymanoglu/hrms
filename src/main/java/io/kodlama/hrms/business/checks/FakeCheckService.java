package io.kodlama.hrms.business.checks;

import io.kodlama.hrms.core.utilities.results.ErrorResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.core.utilities.results.SuccessResult;
import io.kodlama.hrms.entities.concretes.Seeker;

public class FakeCheckService implements SeekerCheckService {

	@Override
	public Result check(Seeker seeker) {
		if (seeker.getNationalityId().equals("11066761064") && seeker.getName().equals("Şakir")
				&& seeker.getSurname().equals("Süleymanoğlu") && seeker.getDateOfBirth().equals("1999")) {
			return new SuccessResult();
		}
		return new ErrorResult("Girilen bilgiler sistemdeki bilgiler ile uyuşmuyor");
	}

}
