package chp06;

import chp06.employee.Employee;
import chp06.employee.Skill;
import chp06.employee.Unit;

import java.util.List;
import java.util.function.Predicate;

public class EmployeeFilterTest {

    private static EmployeeService employeeService = new EmployeeService();

    public static void main(String[] args) {

        //1.Get a list of all Employees in EDC
        System.out.println("=====> 1.Get a list of all Employees in EDC");
        testEDCFilter();

        //2. Get all Java Developers
        System.out.println("=========> 2. Get all Java Developers");
        testJavaDevelopers();

        //3.Get all Senior Professionals
        System.out.println("=========> 3.Get all Senior Professionals ");
        testSeniorProfessions();

        //4. Java Developer in EDC
        System.out.println("==> 4. Java Developer in EDC");
        javaDevelopersInEdc();

    }

    private static void javaDevelopersInEdc() {
        List<Employee> javaDevsInEdc = employeeService.getEmployeesFilteredBy(edcFilter().and(javaDevs()));
        System.out.println(javaDevsInEdc);
    }

    private static void testSeniorProfessions() {
        List<Employee> seniorProfesisons = employeeService.getEmployeesFilteredBy(seniorProfessions());
        System.out.println(seniorProfesisons);
    }

    private static void testEDCFilter() {
        List<Employee> edcEmployees = employeeService.getEmployeesFilteredBy(edcFilter());
        System.out.println(edcEmployees);
    }

    private static void testJavaDevelopers() {
        List<Employee> javaDevelopers = employeeService.getEmployeesFilteredBy(javaDevs());
        System.out.println(javaDevelopers);
    }

    private static Predicate<Employee> edcFilter(){
        return employee -> employee.getUnit() == Unit.EDC;
    }

    private static Predicate<Employee> javaDevs(){
        return employee -> employee.getSkills().contains(Skill.JAVA);
    }

    private static Predicate<Employee> seniorProfessions() {
        return employee -> employee.getExperience()>10;
    }




}
