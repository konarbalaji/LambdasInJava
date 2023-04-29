package chp06;

import chp06.employee.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmployeeService {

    public List<Employee> getEmployeesFilteredBy(Predicate<Employee> employeePredicate) {
        List<Employee> employees = EmployeeUtil.initialize();

        List<Employee> filteredEmployee = new ArrayList<>();

        for(Employee emp : employees){
            if(employeePredicate.test(emp))
                filteredEmployee.add(emp);
        }

        return filteredEmployee;
    }


    //Retrieve a list of employees that are sorted alphabetically by name
    public List<Employee> sortByName() {
        List<Employee> employees = EmployeeUtil.initialize();
        Collections.sort(employees, EmployeeSorterUsual.byNameAlphabetically);
        return employees;
    }

    public List<Employee> sortByInreasingExpAndThenName() {
        List<Employee> employees = EmployeeUtil.initialize();
        Collections.sort(employees,EmployeeSorterUsual.BY_ASC_EXP_THEN_NAME);
        return employees;
    }

    public List<Employee> sortByDecreasingExpAndThenName() {
        List<Employee> employees = EmployeeUtil.initialize();
        Collections.sort(employees, EmployeeSorterUsual.BY_DESC_EXP_THEN_NAME);
        return employees;
    }
}
