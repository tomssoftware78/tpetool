package be.pvgroup.tpetool.model.accidents;

import java.math.BigDecimal;

public class Payroll {
    private BigDecimal employeeWage = BigDecimal.ZERO;
    private BigDecimal employeeWageStudent = BigDecimal.ZERO;
    private BigDecimal workerWage = BigDecimal.ZERO;
    private BigDecimal workerWageStudent = BigDecimal.ZERO;

    public BigDecimal getEmployeeWage() {
        return employeeWage;
    }

    public void setEmployeeWage(BigDecimal employeeWage) {
        this.employeeWage = employeeWage;
    }

    public BigDecimal getEmployeeWageStudent() {
        return employeeWageStudent;
    }

    public void setEmployeeWageStudent(BigDecimal employeeWageStudent) {
        this.employeeWageStudent = employeeWageStudent;
    }

    public BigDecimal getWorkerWage() {
        return workerWage;
    }

    public void setWorkerWage(BigDecimal workerWage) {
        this.workerWage = workerWage;
    }

    public BigDecimal getWorkerWageStudent() {
        return workerWageStudent;
    }

    public void setWorkerWageStudent(BigDecimal workerWageStudent) {
        this.workerWageStudent = workerWageStudent;
    }

    @Override
    public String toString() {
        return "Payroll{" +
                "employeeWage=" + employeeWage +
                ", employeeWageStudent=" + employeeWageStudent +
                ", workerWage=" + workerWage +
                ", workerWageStudent=" + workerWageStudent +
                '}';
    }

    public static final class PayrollBuilder {
        private BigDecimal employeeWage = BigDecimal.ZERO;
        private BigDecimal employeeWageStudent = BigDecimal.ZERO;
        private BigDecimal workerWage = BigDecimal.ZERO;
        private BigDecimal workerWageStudent = BigDecimal.ZERO;

        private PayrollBuilder() {
        }

        public static PayrollBuilder aPayroll() {
            return new PayrollBuilder();
        }

        public PayrollBuilder withEmployeeWage(BigDecimal employeeWage) {
            this.employeeWage = employeeWage;
            return this;
        }

        public PayrollBuilder withEmployeeWageStudent(BigDecimal employeeWageStudent) {
            this.employeeWageStudent = employeeWageStudent;
            return this;
        }

        public PayrollBuilder withWorkerWage(BigDecimal workerWage) {
            this.workerWage = workerWage;
            return this;
        }

        public PayrollBuilder withWorkerWageStudent(BigDecimal workerWageStudent) {
            this.workerWageStudent = workerWageStudent;
            return this;
        }

        public Payroll build() {
            Payroll payroll = new Payroll();
            payroll.setEmployeeWage(employeeWage);
            payroll.setEmployeeWageStudent(employeeWageStudent);
            payroll.setWorkerWage(workerWage);
            payroll.setWorkerWageStudent(workerWageStudent);
            return payroll;
        }
    }
}
