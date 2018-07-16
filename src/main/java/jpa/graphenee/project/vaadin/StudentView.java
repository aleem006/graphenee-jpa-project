package jpa.graphenee.project.vaadin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;

import io.graphenee.core.vaadin.SystemView;
import io.graphenee.vaadin.AbstractDashboardPanel;
import io.graphenee.vaadin.TRView;
import jpa.graphenee.project.vaadin.components.StudentPanel;

@SpringView(name = StudentView.VIEW_NAME)
@Scope("prototype")
public class StudentView extends AbstractDashboardPanel implements TRView{

	public static final String VIEW_NAME = "student";
	
	@Autowired
	StudentPanel studentPanel;
	
	@Override
	public void enter(ViewChangeEvent event) {
		if(studentPanel.isVisible()) {
			studentPanel.refresh();
		}
	}

	@Override
	protected String panelTitle() {
		return "Students";
	}

	@Override
	protected void postInitialize() {
		addComponent(studentPanel.build().withVisible(true));
	}

	@Override
	protected boolean shouldShowHeader() {
		return true;
	}
}
