package lambdas.chp06;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;

import java.util.Comparator;

import lambdas.employee.Employee;

public class EmployeeSorterFinal {

    //keyextractor - field that is used to sort objects.
    //comparing - pass me the field that i can use to compare objects.
    public static final Comparator<Employee> BY_NAME_ALPHA =
            comparing((Employee e) -> e.getName());

    //Comparator for sorting employee by experience
    public static final Comparator<Employee> BY_EXPERIENCE =
            comparingInt((Employee e) -> e.getExperience());

    public static final Comparator<Employee> BY_ASC_EXP_THEN_NAME =
            BY_EXPERIENCE.thenComparing(BY_NAME_ALPHA);

    public static final Comparator<Employee> BY_DESC_EXP_THEN_NAME =
            BY_EXPERIENCE.reversed().thenComparing(BY_NAME_ALPHA);

    //Using Method Reference

    public static final Comparator<Employee> BY_NAME_ALPHA_MR =
            comparing(Employee::getName);

    //Comparator for sorting employee by experience
    public static final Comparator<Employee> BY_EXPERIENCE_MR =
            comparingInt(Employee::getExperience);

    public static final Comparator<Employee> BY_ASC_EXP_THEN_NAME_MR =
            BY_EXPERIENCE_MR.thenComparing(BY_NAME_ALPHA_MR);

    public static final Comparator<Employee> BY_DESC_EXP_THEN_NAME_MR =
            BY_EXPERIENCE_MR.reversed().thenComparing(BY_NAME_ALPHA_MR);
}