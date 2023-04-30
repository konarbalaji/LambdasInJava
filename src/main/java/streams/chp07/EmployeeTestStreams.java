package streams.chp07;

import chp06.EmployeeService;
import chp06.employee.Employee;

import java.util.List;
import java.util.function.Predicate;

public class EmployeeTestStreams {

    public final static EmployeeService employeeService = new EmployeeService();

    public static void main(String[] args) {

        //Employee with experience > 10 years
        System.out.println("Simple usage of stream, filter, collect");
        seniorEmployeeUsingStreams();
        System.out.println(seniorEmployeeUsingStreams());
    }

    private static List<Employee> seniorEmployeeUsingStreams() {
        Predicate<Employee> seniorProfFilter = (emp) -> emp.getExperience()>10;
        return employeeService.getEmployeesFilteredByImperative(seniorProfFilter);
    }


}
