package com.kodlama.io.hrms.business.abstracts;

import java.util.List;

import com.kodlama.io.hrms.core.utilities.results.Result;
import com.kodlama.io.hrms.entities.concretes.Resume;
import com.kodlama.io.hrms.entities.dtos.ForeignLanguageForAddDto;

public interface ResumeForeignLanguageService {
     Result addRange(List<ForeignLanguageForAddDto> foreignLanguages , Resume resume);
}
