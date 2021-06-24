package io.kodlama.hrms.business.checks;

import java.rmi.RemoteException;

import io.kodlama.hrms.core.utilities.results.ErrorResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.core.utilities.results.SuccessResult;
import io.kodlama.hrms.entities.concretes.Seeker;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class KPSPublicAdapter implements SeekerCheckService {

	@Override
	public Result check(String nationalityId, String name, String surname, String dateOfBirth) {

		KPSPublicSoapProxy kpsPublicSoapProxy = new KPSPublicSoapProxy();

		String message = "";

		try {

			boolean result = kpsPublicSoapProxy.TCKimlikNoDogrula(Long.parseLong(nationalityId), name, surname,
					Integer.parseInt(dateOfBirth));

			if (result) {
				return new SuccessResult();
			}

		} catch (RemoteException e) {
			message = e.getMessage();
		}

		return new ErrorResult(message);
	}

}
