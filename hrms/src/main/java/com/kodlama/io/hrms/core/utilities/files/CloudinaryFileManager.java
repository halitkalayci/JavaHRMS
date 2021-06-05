package com.kodlama.io.hrms.core.utilities.files;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.util.Map;

@Service
public class CloudinaryFileManager implements FileService {

	@Value("${cloudinary.cloud_name}")
	private String cloudName;

	@Value("${cloudinary.api_key}")
	private String apiKey;

	@Value("${cloudinary.api_secret}")
	private String apiSecret;

	
	@Override
	public String upload(MultipartFile file) {

		Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name",cloudName,
				"api_key",apiKey,
				"api_secret",apiSecret));
		
		 try {
	            File uploadedFile = convertMultiPartToFile(file);
	            Map uploadResult = cloudinary.uploader().upload(uploadedFile, ObjectUtils.emptyMap());
	            return  uploadResult.get("url").toString();
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	}
	

    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }

}
