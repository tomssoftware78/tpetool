package be.pvgroup.tpetool.model.accidents;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.pvgroup.tpetool.controllers.AccidentsController;

public class Beneficiary {
	static Logger logger = LoggerFactory.getLogger(Beneficiary.class);

	private String name;
	private String firstName;
	private Date dateOfBirth;
	private BigDecimal salary = BigDecimal.ZERO;
	private String manualWork;

	public String getFullName() {
		StringBuffer result = new StringBuffer("");

		if (getFirstName() != null) {
			result.append(getFirstName()).append(" ");
		}

		if (getName() != null) {
			result.append(getName());
		}
		;

		return result.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getDateOfBirth() {
		if (dateOfBirth == null) {
			return "";
		}
		return getDateFormatter().format(dateOfBirth);
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public String getManualWork() {
		return manualWork;
	}

	public void setManualWork(String manualWork) {
		this.manualWork = manualWork;
	}

	@Override
	public String toString() {
		return "Beneficiary{" + "name='" + name + '\'' + ", firstName='" + firstName + '\'' + ", dateOfBirth='"
				+ dateOfBirth + '\'' + ", salary=" + salary + ", manualWork='" + manualWork + '\'' + '}';
	}

	private DateFormat getDateFormatter() {
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		return dateFormat;
	}

	public static final class BeneficiaryBuilder {
		private String name;
		private String firstName;
		private String dateOfBirth;
		private BigDecimal salary = BigDecimal.ZERO;
		private String manualWork;

		private BeneficiaryBuilder() {
		}

		public static BeneficiaryBuilder aBeneficiary() {
			return new BeneficiaryBuilder();
		}

		public BeneficiaryBuilder withName(String name) {
			this.name = name;
			return this;
		}

		public BeneficiaryBuilder withFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public BeneficiaryBuilder withDateOfBirth(String dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
			return this;
		}

		public BeneficiaryBuilder withSalary(BigDecimal salary) {
			this.salary = salary;
			return this;
		}

		public BeneficiaryBuilder withManualWork(String manualWork) {
			this.manualWork = manualWork;
			return this;
		}

		public Beneficiary build() {
			Beneficiary beneficiary = new Beneficiary();
			beneficiary.setName(name);
			beneficiary.setFirstName(firstName);
			String pattern = "yyyy-MM-dd";
			SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
			try {
				beneficiary.setDateOfBirth(dateFormat.parse(dateOfBirth));
			} catch (ParseException e) {
				logger.error(e.getMessage(), e);
				throw new RuntimeException(e.getMessage(), e);
			}
			beneficiary.setSalary(salary);
			beneficiary.setManualWork(manualWork);
			return beneficiary;
		}
	}
}
