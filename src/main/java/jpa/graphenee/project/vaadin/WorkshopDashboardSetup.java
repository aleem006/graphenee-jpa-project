package jpa.graphenee.project.vaadin;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewProvider;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinService;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Image;

import io.graphenee.core.exception.AuthenticationFailedException;
import io.graphenee.vaadin.AbstractDashboardSetup;
import io.graphenee.vaadin.TRMenuItem;
import io.graphenee.vaadin.TRSimpleMenuItem;
import io.graphenee.vaadin.domain.DashboardUser;
import io.graphenee.vaadin.domain.MockUser;
import io.graphenee.vaadin.event.DashboardEvent.UserLoginRequestedEvent;
import jpa.graphenee.project.model.Student;
import jpa.graphenee.project.repository.StudentRepository;

@Service
@UIScope
public class WorkshopDashboardSetup extends AbstractDashboardSetup {
	
	@Autowired
	StudentRepository studentRepo;
	
	@Autowired
	EntityManager entityManager;
	
	private Student findStudentByStudentNameAndPassword(String userName, String password){
		
		TypedQuery<Student> typedQuery = entityManager.createNamedQuery("Student.authenticate", Student.class);
		typedQuery.setParameter("studentName", userName);
		typedQuery.setParameter("password", password);
		return typedQuery.getSingleResult();
		
	}
	
	private ViewProvider viewProvider;

	public WorkshopDashboardSetup(ViewProvider viewProvider) {
		this.viewProvider = viewProvider;
	}

	@Override
	public String applicationTitle() {
		return "Graphenee Project";
	}

	@Override
	public Image applicationLogo() {
		return null;
	}
	
	@Override
	protected List<TRMenuItem> menuItems() {
		List<TRMenuItem> menus = new ArrayList<>();
		menus.add(TRSimpleMenuItem.createMenuItemForView(MetroStyleDashboardView.VIEW_NAME, "Home", FontAwesome.HOME));
		menus.add(TRSimpleMenuItem.createMenuItemForView(StudentView.VIEW_NAME, "Student", FontAwesome.BANK));
		return menus;
	}

	@Override
	protected List<TRMenuItem> profileMenuItems() {
		return null;
	}

	@Override
	public String dashboardViewName() {
		return MetroStyleDashboardView.VIEW_NAME;
	}

	@Override
	public void registerViewProviders(Navigator navigator) {
		navigator.addProvider(viewProvider);
	}

	@Override
	public DashboardUser authenticate(UserLoginRequestedEvent event) throws AuthenticationFailedException {
		String userName = event.getUserName();
		String password = event.getPassword();
		
		HttpServletRequest request = (HttpServletRequest) VaadinService.getCurrentRequest();
		if(request == null) {
			throw new AuthenticationFailedException("Cannot autneticate due to invalid http request.");
		}
		
		try {
			Student authenticateStudent = findStudentByStudentNameAndPassword(userName, password);
			if(authenticateStudent != null) {
				
				Student student = new Student();
				student.setFirstName(authenticateStudent.getFirstName());
				student.setLastName(authenticateStudent.getLastName());
				student.setUsername(authenticateStudent.getStudentName());
				student.setPassword(authenticateStudent.getPassword());
//				student.setGender(authenticateStudent.getGender());
				
				return student;
			
			} else 
				throw new AuthenticationFailedException("Cannot autneticate due to invalid http request.");
		} catch(Exception e) {
			throw new AuthenticationFailedException("Cannot autneticate due to invalid http request.");
		}
	}

}
