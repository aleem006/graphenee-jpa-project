package jpa.graphenee.project.vaadin.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.vaadin.viritin.fields.MTextField;

import com.google.common.base.Strings;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.AbstractSelect.ItemCaptionMode;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;

import io.graphenee.core.model.api.GxDataService;
import io.graphenee.core.model.bean.GxGenderBean;
import io.graphenee.vaadin.BeanFaultContainer;
import io.graphenee.vaadin.TRAbstractForm;
import io.graphenee.vaadin.component.BeanFaultComboBox;
import jpa.graphenee.project.model.Student;


@SpringComponent
@Scope("prototype")
public class StudentForm extends TRAbstractForm<Student>{
	
	@Autowired
	GxDataService gxDataService;
	
	MTextField studentId;
	MTextField studentName;
	MTextField firstName;
	MTextField lastName;
	MTextField password;
//	BeanFaultComboBox gender;
//	ComboBox gender;
	
	@Override
	protected void addFieldsToForm(FormLayout form) {
		studentId = new MTextField("Student Id").withRequired(true);
		studentName = new MTextField("Student Name").withRequired(true);
		firstName = new MTextField("First Name").withRequired(true);
		lastName = new MTextField("last Name").withRequired(true);
		password = new MTextField("Password").withRequired(true);
		
//		gender = new BeanFaultComboBox("Gender");
//		gender = new ComboBox("Gender");
//		gender.setRequired(true);
//		BeanFaultContainer<String, GxGenderBean> genderContainern = new BeanFaultContainer<>("genderCode");
//		genderContainern.setBeans(gxDataService.findGender());
//		gender.setContainerDataSource(genderContainern);
//		gender.setItemCaptionMode(ItemCaptionMode.PROPERTY);
//		gender.setItemCaptionPropertyId("genderName");
		
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
