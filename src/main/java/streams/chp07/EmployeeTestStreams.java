package streams.chp07;


import chp06.employee.Employee;
import chp06.employee.Skill;

import java.util.List;
import java.util.function.Predicate;

public class EmployeeTestStreams {

    public final static EmployeeService employeeService = new EmployeeService();

    public static void main(String[] args) {

        //Employee with experience > 10 years
        System.out.println("Simple usage of stream, filter, collect");
        seniorEmployeeUsingStreams();
        System.out.println(seniorEmployeeUsingStreams());

        //map example - get employee name with AngularJS skills.
        System.out.println("Example of map function");
        System.out.println(employeenamesWithAngularJsSkills(Skill.ANGULARJS));
    }

    private static List<Employee> seniorEmployeeUsingStreams() {
        Predicate<Employee> seniorProfFilter = (emp) -> emp.getExperience()>10;
        return employeeService.getEmployeesFilteredByImperative(seniorProfFilter);
    }

    private static List<String> employeenamesWithAngularJsSkills(Skill skill) {
        Predicate<Employee> empWithAngSkills = e -> e.getSkills().contains(skill);
        return employeeService.getEmployeeNamesWithSkill(empWithAngSkills);
    }


}
