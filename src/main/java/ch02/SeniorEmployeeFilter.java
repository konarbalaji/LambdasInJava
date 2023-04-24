package ch02;

public class SeniorEmployeeFilter implements EmployeeFilter{
    @Override
    public boolean filterEmployee(Employee emp) {
        return emp.getExperience()>10;
    }
}
