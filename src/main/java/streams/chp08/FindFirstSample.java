package streams.chp08;

import streams.chp07.EmployeeUtil;
import streams.chp07.Employee;

import java.util.List;
import java.util.Optional;

public class FindFirstSample {

    public static void main(String[] args) {

        int id = 5;
        System.out.println("Employee with ID : " + id + " is " + findEmployeeNameById(id));
        System.out.println("Employee with ID : " + id + " is " + findEmployeeNameByIdElse(id));

    }

    public static String findEmployeeNameById(int id){
        List<Employee> employees = EmployeeUtil.initialize();

        Optional<Employee> employee = employees.stream()
                                                .filter(e -> e.getId() == id)
                                                .findFirst();

        return employee.isPresent() ? employee.get().getName() : "UNKNOWN";

    }

    public static String findEmployeeNameByIdElse(int id){

        List<Employee> employees = EmployeeUtil.initialize();
        return employees.stream()
                        .filter(e -> e.getId() == id)
                        .findFirst()
                        .map(e -> e.getName())
                        .orElse("UNKNOWN");

    }
}