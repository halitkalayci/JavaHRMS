package com.kodlama.io.hrms.business.abstracts;

import org.springframework.web.multipart.MultipartFile;

import com.kodlama.io.hrms.core.utilities.results.Result;
import com.kodlama.io.hrms.entities.dtos.EmployerUpdateRequestForAddDto;

public interface EmployerUpdateRequestService {
         Result canSubmitNewUpdateRequest(int id);
         Result addNew(EmployerUpdateRequestForAddDto employerUpdateRequestForAddDto,MultipartFile avatar);
}
