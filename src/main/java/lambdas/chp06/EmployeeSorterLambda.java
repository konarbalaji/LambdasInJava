package lambdas.chp06;

import lambdas.employee.Employee;

import java.util.Comparator;

public class EmployeeSorterLambda {

    public static final Comparator<Employee> byNameAlphabetically = (e1, e2) -> {
            return e1.getName().compareTo(e2.getName());
    };

    public static final Comparator<? super Employee> byIncrExpAndNme = (e1, e2) -> {
            if(e1.getExperience() == e2.getExperience()){
                return e1.getName().compareTo(e2.getName());
            }
            return (e1.getExperience() < e2.getExperience()) ? -1 : 1;
    };

    public static final Comparator<? super Employee> byDescExpAndName = (e1, e2) -> {
            if(e1.getExperience() == e2.getExperience()){
                return e1.getName().compareTo(e2.getName());
            }
            return (e1.getExperience() < e2.getExperience()) ? 1 : -1;
    };
}