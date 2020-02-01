package com.kh.mvc.validate;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Service
public class FileValidator implements Validator {
	
	//Validator : 유효성검사 

	@Override
	public boolean supports(Class<?> arg0) {
		return false;
	}

	//주어진 객체에 유효성을 검사하고, 유효성검사에 오류가 있는경우 주어진 객체에 이 오류를 등록한다
	//UploadFile uploadFile, BindingResult result)
	@Override
	public void validate(Object uploadFile, Errors errors) {
		UploadFile file = (UploadFile) uploadFile;
		
		if(file.getFile().getSize() == 0) {
			errors.rejectValue("file", "errorCode", 
					"Please select a file");
		}
	}
}
