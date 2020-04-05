package be.pvgroup.tpetool.model.proposal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StartDates {

	private Date accidents;
	private Date liability;
	private Date property;

	public String getAccidentsAsString() {
		return getDateFormatter().format(accidents);
	}

	public void setAccidents(Date accidents) {
		this.accidents = accidents;
	}

	public String getLiabilityAsString() {
		return getDateFormatter().format(liability);
	}

	public void setLiability(Date liability) {
		this.liability = liability;
	}

	public String getPropertyAsString() {
		return getDateFormatter().format(property);
	}

	public void setProperty(Date property) {
		this.property = property;
	}

	@Override
	public String toString() {
		return "StartDates{" + "accidents=" + accidents + ", liability=" + liability + ", property=" + property + '}';
	}

	private DateFormat getDateFormatter() {
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		return dateFormat;
	}

	public static final class StartDatesBuilder {
		private Date accidents;
		private Date liability;
		private Date property;

		private StartDatesBuilder() {
		}

		public static StartDatesBuilder aStartDates() {
			return new StartDatesBuilder();
		}

		public StartDatesBuilder withAccidents(Date accidents) {
			this.accidents = accidents;
			return this;
		}

		public StartDatesBuilder withLiability(Date liability) {
			this.liability = liability;
			return this;
		}

		public StartDatesBuilder withProperty(Date property) {
			this.property = property;
			return this;
		}

		public StartDates build() {
			StartDates startDates = new StartDates();
			startDates.setAccidents(accidents);
			startDates.setLiability(liability);
			startDates.setProperty(property);
			return startDates;
		}
	}
}
