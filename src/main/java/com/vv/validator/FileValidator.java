package com.vv.validator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.vv.model.ExpenseFeedForm;

@Component
public class FileValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		 return ExpenseFeedForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ExpenseFeedForm feedForm = (ExpenseFeedForm) target;
		if(feedForm.getProofFile() != null && feedForm.getProofFile().isEmpty()){
			errors.rejectValue("proofFile", "error.proofFile","Please select a file");
		}
		
	}

}
