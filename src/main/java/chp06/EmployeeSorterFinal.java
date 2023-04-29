package chp06;

import chp06.employee.Employee;

import java.util.Comparator;

public class EmployeeSorterFinal {

    public static final Comparator<Employee> byNameAlphabetically = (e1, e2) -> {
            return e1.getName().compareTo(e2.getName());
    };

    public static final Comparator<? super Employee> BY_ASC_EXP_THEN_NAME = (e1, e2) -> {
            if(e1.getExperience() == e2.getExperience()){
                return e1.getName().compareTo(e2.getName());
            }
            return (e1.getExperience() < e2.getExperience()) ? -1 : 1;
    };

    public static final Comparator<? super Employee> BY_DESC_EXP_THEN_NAME = (e1, e2) -> {
            if(e1.getExperience() == e2.getExperience()){
                return e1.getName().compareTo(e2.getName());
            }
            return (e1.getExperience() < e2.getExperience()) ? 1 : -1;
    };
}