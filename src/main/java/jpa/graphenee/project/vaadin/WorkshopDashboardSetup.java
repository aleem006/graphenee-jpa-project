package jpa.graphenee.project.vaadin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import io.graphenee.core.exception.AuthenticationFailedException;
import io.graphenee.core.vaadin.SystemView;
import io.graphenee.i18n.vaadin.LocalizationView;
import io.graphenee.security.vaadin.SecurityView;
import io.graphenee.vaadin.AbstractDashboardSetup;
import io.graphenee.vaadin.TRMenuItem;
import io.graphenee.vaadin.TRSimpleMenuItem;
import io.graphenee.vaadin.domain.DashboardUser;
import io.graphenee.vaadin.domain.MockUser;
import io.graphenee.vaadin.event.DashboardEvent.UserLoginRequestedEvent;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewProvider;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Image;

@Service
@UIScope
public class WorkshopDashboardSetup extends AbstractDashboardSetup {

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
		return new MockUser();
	}

}
