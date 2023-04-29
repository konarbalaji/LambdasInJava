package chp06;

import chp06.employee.Employee;

import java.util.Comparator;

public class EmployeeSorterFinal {

    //keyextractor - field that is used to sort objects.
    //comparing - pass me the field that i can use to compare objects.
    public static final Comparator<Employee> BY_NAME_ALPHA =
            Comparator.comparing((Employee e) -> e.getName());

    public static final Comparator<Employee> BY_ASC_EXP_THEN_NAME =
            Comparator.comparing((Employee e) -> e.getExperience()).
                    thenComparing(BY_NAME_ALPHA);

    public static final Comparator<Employee> BY_DESC_EXP_THEN_NAME =
            Comparator.comparing((Employee e) -> e.getExperience()).reversed()
                    .thenComparing(BY_NAME_ALPHA);
}