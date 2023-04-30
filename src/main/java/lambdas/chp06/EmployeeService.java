package lambdas.chp06;

import lambdas.employee.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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
        //Collections.sort(employees, EmployeeSorterUsual.byNameAlphabetically);
        //Collections.sort(employees, EmployeeSorterLambda.byNameAlphabetically);
        //employees.sort(EmployeeSorterLambda.byNameAlphabetically);
        employees.sort(EmployeeSorterFinal.BY_NAME_ALPHA);
        return employees;
    }

    public List<Employee> sortByInreasingExpAndThenName() {
        List<Employee> employees = EmployeeUtil.initialize();
        //Collections.sort(employees,EmployeeSorterUsual.BY_ASC_EXP_THEN_NAME);
        //Collections.sort(employees,EmployeeSorterLambda.BY_ASC_EXP_THEN_NAME);
        //employees.sort(EmployeeSorterLambda.byIncrExpAndNme);
        employees.sort(EmployeeSorterFinal.BY_ASC_EXP_THEN_NAME);
        return employees;
    }

    public List<Employee> sortByDecreasingExpAndThenName() {
        List<Employee> employees = EmployeeUtil.initialize();
        //Collections.sort(employees, EmployeeSorterUsual.BY_DESC_EXP_THEN_NAME);
        //Collections.sort(employees, EmployeeSorterLambda.BY_DESC_EXP_THEN_NAME);
        //employees.sort(EmployeeSorterLambda.byDescExpAndName);
        employees.sort(EmployeeSorterFinal.BY_DESC_EXP_THEN_NAME);
        return employees;
    }
}