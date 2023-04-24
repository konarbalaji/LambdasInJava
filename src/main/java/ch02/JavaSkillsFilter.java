package ch02;

public class JavaSkillsFilter implements EmployeeFilter {
    @Override
    public boolean filterEmployee(Employee emp) {
        return emp.getSkills().contains(Skill.JAVA);
    }
}
