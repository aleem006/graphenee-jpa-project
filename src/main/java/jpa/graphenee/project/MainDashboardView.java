package jpa.graphenee.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import io.graphenee.i18n.api.LocalizerService;
import io.graphenee.vaadin.AbstractDashboardView;
import com.vaadin.spring.annotation.SpringView;

@SpringView(name = MainDashboardView.VIEW_NAME)
@Scope("prototype")
public class MainDashboardView extends AbstractDashboardView {

	@Autowired
	LocalizerService localizer;

	@Override
	protected boolean isSpringView() {
		return super.isSpringView();
	}

	@Override
	protected String dashboardTitle() {
		return localizer.getSingularValue("Dashboard");
	}

	@Override
	protected List<Dashlet> dashlets() {
		return null;
	}

}
