package com.vv.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.vv.model.IdeaValidator;
@Component
public class IdeaFileValidator implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		 return IdeaValidator.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		IdeaValidator ideaForm = (IdeaValidator) target;
		String st[] = ideaForm.getDocFile().getOriginalFilename().split("\\.");
		String extn = st[st.length-1];
		System.out.println(extn+" "+(ideaForm.getDocFile() != null && ideaForm.getDocFile().isEmpty())+"  "+(!extn.equals("doc") && !extn.equals("docx")));
		if((ideaForm.getDocFile() != null && ideaForm.getDocFile().isEmpty()) || (!extn.equals("doc") && !extn.equals("docx"))){
			errors.rejectValue("docFile", "error.docFile","Please select a Document file in doc or docx format only");
		}
	}
}