package be.pvgroup.tpetool.service.accidents;

import be.pvgroup.tpetool.model.AccidentPremium;
import be.pvgroup.tpetool.model.accidents.AccidentsInput;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static be.pvgroup.tpetool.AccidentsTestConstants.accidentsInput;
import static be.pvgroup.tpetool.AccidentsTestConstants.accidentsInputWith2Beneficiaries;

public class AccidentsServiceImplTest {

	private AccidentsInput input1;
	private AccidentsInput input2;

	@Before
	public void init() {
		// input1 = accidentsInput();
		// input2 = accidentsInputWith2Beneficiaries();
	}

	@Test
	public void testArbeidsOngevallen1() {
		// ManualWorkCalculatorImpl manualWorkCalculator = new
		// ManualWorkCalculatorImpl();
		// AccidentsServiceImpl service = new
		// AccidentsServiceImpl(manualWorkCalculator);

		// service.calculate(input1);
	}

	@Test
	public void testArbeidsOngevallen2() {
		// ManualWorkCalculatorImpl manualWorkCalculator = new
		// ManualWorkCalculatorImpl();
		// AccidentsServiceImpl service = new
		// AccidentsServiceImpl(manualWorkCalculator);

		// service.calculate(input2);
	}

	@Test
	public void testArbeidsOngevallen3() {
		// ManualWorkCalculatorImpl manualWorkCalculator = new
		// ManualWorkCalculatorImpl();
		// AccidentsServiceImpl service = new
		// AccidentsServiceImpl(manualWorkCalculator);

		// List<AccidentPremium> accidentPremiums = service.calculate(input2);

		// for (AccidentPremium accidentPremium : accidentPremiums) {
		// System.out.println(accidentPremium.toString());
		// }
	}

}