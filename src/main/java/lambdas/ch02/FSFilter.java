package lambdas.ch02;

import lambdas.employee.Employee;
import lambdas.employee.Unit;

public class FSFilter implements EmployeeFilter {
    @Override
    public boolean filterEmployee(Employee emp) {
        return emp.getUnit().equals(Unit.FS);
    }
}
