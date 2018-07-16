package jpa.graphenee.project.vaadin.components;

import org.springframework.context.annotation.Scope;
import org.vaadin.viritin.fields.MTextField;
import com.google.common.base.Strings;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.FormLayout;
import io.graphenee.vaadin.TRAbstractForm;
import jpa.graphenee.project.model.Student;


@SpringComponent
@Scope("prototype")
public class StudentForm extends TRAbstractForm<Student>{
	
	MTextField studentId;
	MTextField studentName;
	MTextField firstName;
	MTextField lastName;
	MTextField password;
	
	@Override
	protected void addFieldsToForm(FormLayout form) {
		studentId = new MTextField("Student Id").withRequired(true);
		studentName = new MTextField("Student Name").withRequired(true);
		firstName = new MTextField("First Name").withRequired(true);
		lastName = new MTextField("last Name").withRequired(true);
		password = new MTextField("Password").withRequired(true);
		form.addComponents(studentId,studentName, firstName, lastName, password);
		
	}

	@Override
	protected boolean eagerValidationEnabled() {
		return true;
	}

	@Override
	protected String formTitle() {
		String fTitle = getEntity().getStudentName();
		if(Strings.isNullOrEmpty(fTitle)) {
			fTitle = "Student Form";
		}
		return fTitle;
	}

}
