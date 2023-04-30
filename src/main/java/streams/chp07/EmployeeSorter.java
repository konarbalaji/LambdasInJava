package streams.chp07;

import chp06.employee.Employee;

import java.util.Comparator;

public class EmployeeSorter {


    public static final Comparator<? super Employee> BY_EXPERIENCE = new Comparator<Employee>() {
        @Override
        public int compare(Employee e1, Employee e2) {
            return e1.getExperience()>e2.getExperience() ? 1 : -1;
        }
    };
}
