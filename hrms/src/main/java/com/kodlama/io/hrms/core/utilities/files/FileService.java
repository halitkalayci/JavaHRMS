package com.kodlama.io.hrms.core.utilities.files;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
   String upload(MultipartFile file);
}
