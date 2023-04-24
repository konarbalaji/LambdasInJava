package ch02;

public class FSFilter implements EmployeeFilter {
    @Override
    public boolean filterEmployee(Employee emp) {
        return emp.getUnit().equals(Unit.FS);
    }
}
