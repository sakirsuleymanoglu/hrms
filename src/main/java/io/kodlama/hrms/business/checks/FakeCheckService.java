package io.kodlama.hrms.business.checks;

import io.kodlama.hrms.core.utilities.results.ErrorResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.core.utilities.results.SuccessResult;

public class FakeCheckService implements SeekerCheckService {

	@Override
	public Result check(String nationalityId, String name, String surname, String dateOfBirth) {
		if (nationalityId == "11066761064" && name == "Şakir" && surname == "Süleymanoğlu" && dateOfBirth == "1999") {
			return new SuccessResult();
		}
		return new ErrorResult("Girilen bilgiler sistemdeki bilgiler ile uyuşmuyor");
	}

}
