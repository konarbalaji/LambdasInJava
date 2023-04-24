package ch02;

public class EDCFilter implements EmployeeFilter {
    @Override
    public boolean filterEmployee(Employee emp) {
        return emp.getUnit().equals(Unit.EDC);
    }
}
