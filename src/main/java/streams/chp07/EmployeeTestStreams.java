package streams.chp07;

import lambdas.employee.Skill;

import java.util.List;
import java.util.function.Predicate;

public class EmployeeTestStreams {

    public final static EmployeeService employeeService = new EmployeeService();

    public static void main(String[] args) {

        //Employee with experience > 10 years
        System.out.println("============> Simple usage of stream, filter, collect");
        seniorEmployeeUsingStreams();
        System.out.println(seniorEmployeeUsingStreams());

        //map example - get employee name with AngularJS skills.
        System.out.println("============> Example of map function");
        System.out.println(employeenamesWithAngularJsSkills(Skill.ANGULARJS));

        //Employee names with multiple skills - sorted by old exp - old way
        System.out.println("============> Sorting using imperative style");
        namesWithMultipleSkillsSortedOldWay();

        //Employee names with multiple skills - sorted by exp - streams
        System.out.println("Sorting using declarative style");
        namesWithMultipleSkillsSortedStreams();
    }

    private static void namesWithMultipleSkillsSortedStreams() {
        List<String> namesWithSkillsStreams = employeeService.getEmployeeNamesWithMultipleSkillsStreams();
        System.out.println(namesWithSkillsStreams);
    }

    private static void namesWithMultipleSkillsSortedOldWay() {
        List<String> namesWithSkills = employeeService.getEmployeesWithMultipleSkillsImperative();
        System.out.println(namesWithSkills);
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
