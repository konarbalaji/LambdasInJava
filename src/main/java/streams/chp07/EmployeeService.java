package streams.chp07;

import lambdas.chp06.EmployeeSorterFinal;
import lambdas.employee.Skill;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
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
        //Collections.sort(employees, EmployeeSorterUsual.byNameAlphabetically);
        //Collections.sort(employees, EmployeeSorterLambda.byNameAlphabetically);
        //employees.sort(EmployeeSorterLambda.byNameAlphabetically);
        employees.sort(EmployeeSorter.BY_NAME_ALPHA);
        return employees;
    }

    public List<Employee> sortByInreasingExpAndThenName() {
        List<Employee> employees = EmployeeUtil.initialize();
        //Collections.sort(employees,EmployeeSorterUsual.BY_ASC_EXP_THEN_NAME);
        //Collections.sort(employees,EmployeeSorterLambda.BY_ASC_EXP_THEN_NAME);
        //employees.sort(EmployeeSorterLambda.byIncrExpAndNme);
        employees.sort(EmployeeSorter.BY_ASC_EXP_THEN_NAME);
        return employees;
    }

    public List<Employee> sortByDecreasingExpAndThenName() {
        List<Employee> employees = EmployeeUtil.initialize();
        //Collections.sort(employees, EmployeeSorterUsual.BY_DESC_EXP_THEN_NAME);
        //Collections.sort(employees, EmployeeSorterLambda.BY_DESC_EXP_THEN_NAME);
        //employees.sort(EmployeeSorterLambda.byDescExpAndName);
        employees.sort(EmployeeSorter.BY_DESC_EXP_THEN_NAME);
        return employees;
    }

    //------------------------------------

    public List<Employee> getEmployeesFilteredByImperative(Predicate<Employee> seniorProfFilter) {
        List<Employee> employees = EmployeeUtil.initialize();
        return  employees.stream()
                .filter(seniorProfFilter)
                .collect(Collectors.toList());
    }

    public List<String> getEmployeeNamesWithSkill(Predicate<Employee> filter){
        List<Employee> emp = EmployeeUtil.initialize();

        return emp.stream()
                .filter(filter)
                .map(e->e.getName())
                .collect(Collectors.toList());
    }

    public List<String> getEmployeesWithMultipleSkillsImperative() {
        List<Employee> employees = EmployeeUtil.initialize();

        List<Employee> moreThanOneSkill = new ArrayList<>();
        for(Employee e : employees){
            if(null != e.getSkills() && e.getSkills().size()>1){
                moreThanOneSkill.add(e);
            }
        }

        Collections.sort(moreThanOneSkill,EmployeeSorter.BY_EXPERIENCE);
        List<String> names = new ArrayList<>();
        for(Employee e : moreThanOneSkill){
            names.add(e.getName());
        }

        return names;

    }

    public List<String> getEmployeeNamesWithMultipleSkillsStreams() {
        List<Employee> employees = EmployeeUtil.initialize();

        return employees.stream()
                        //.filter(e -> Objects.nonNull(e.getSkills()))
                        .filter(e -> Objects.nonNull(e.getSkills()) && e.getSkills().size()>1)
                        .sorted(EmployeeSorter.BY_EXPERIENCE)
                        .map(Employee::getName)
                        .collect(Collectors.toList());

    }

    public List<String> getUniqueUnitNamesWithJavaSkill() {
        List<Employee> emp = EmployeeUtil.initialize();

        List<String> distinctUnitNames = emp.stream()
                                            .filter(e -> e.getSkills().contains(Skill.JAVA))
                                            .map(e -> e.getUnit().getUnitName())
                                            .distinct()
                                            .collect(Collectors.toList());

        return distinctUnitNames;

    }
}