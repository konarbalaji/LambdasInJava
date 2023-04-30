package lambdas.ch02;

import lambdas.employee.Employee;

public class SeniorEmployeeFilter implements EmployeeFilter{
    @Override
    public boolean filterEmployee(Employee emp) {
        return emp.getExperience()>10;
    }
}
