package be.pvgroup.tpetool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import be.pvgroup.tpetool.service.coefficients.CoefficientServiceImpl;

@Component
public class AppInitHandler implements ApplicationListener<ApplicationReadyEvent> {

	@Autowired
	private CoefficientServiceImpl coefficientService;

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		coefficientService.loadCoefficients();

	}

}
