package jpa.graphenee.project.vaadin.components;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.vaadin.spring.annotation.SpringComponent;

import io.graphenee.vaadin.AbstractEntityListPanel;
import io.graphenee.vaadin.TRAbstractForm;
import jpa.graphenee.project.model.Student;
import jpa.graphenee.project.repository.StudentRepository;

@SpringComponent
@Scope("prototype")
public class StudentPanel extends AbstractEntityListPanel<Student>{
	
	@Autowired
	StudentRepository studentRepo;
	
	@Autowired
	StudentForm studentForm;

	public StudentPanel() {
		super(Student.class);
	}

	@Override
	protected boolean onSaveEntity(Student entity) {
		studentRepo.save(entity);
		return true;
	}

	@Override
	protected boolean onDeleteEntity(Student entity) {
		studentRepo.delete(entity.getStudentId());
		return true;
	}

	@Override
	protected String panelCaption() {
		return null;
	}

	@Override
	protected List<Student> fetchEntities() {
		return studentRepo.findAll();
	}

	@Override
	protected String[] visibleProperties() {
		return null;
	}

	@Override
	protected TRAbstractForm<Student> editorForm() {
		return studentForm;
	}

}
