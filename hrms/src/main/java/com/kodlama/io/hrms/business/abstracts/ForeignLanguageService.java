package com.kodlama.io.hrms.business.abstracts;

import java.util.List;

import com.kodlama.io.hrms.core.utilities.results.DataResult;
import com.kodlama.io.hrms.entities.dtos.ForeignLanguageDetailsDto;

public interface ForeignLanguageService {
       DataResult< List<ForeignLanguageDetailsDto> > findByResume_Id(int id);
}
