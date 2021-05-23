package com.kodlama.io.hrms.core.utilities;

import com.kodlama.io.hrms.core.utilities.results.Result;

public interface IdentityValidationService {
   Result validate(String tckn, String firstName, String lastName, int yearOfDate);
}
