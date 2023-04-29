package chp06;

public class EmployeeComparatorTest {

    private static final EmployeeService employeeService = new EmployeeService();

    public static void main(String[] args) {

        //sort all employees alphabatecally
        testSortByName();

        //Sort with increasing experience and if same experience , then alphabetically
        testSortByIncreasingExperienceAndThenName();

        //Sort with decreasing experience and if same experience, then alphabetically
        testSortByDecreasingExperienceAndThenName();
    }

    private static void testSortByDecreasingExperienceAndThenName() {
        System.out.println("Sort with decreasing experience and if same experience, then alphabetically");
        System.out.println(employeeService.sortByDecreasingExpAndThenName());
    }

    private static void testSortByIncreasingExperienceAndThenName() {
        System.out.println("Sort with increasing experience and if same experience , then alphabetically");
        System.out.println(employeeService.sortByInreasingExpAndThenName());
    }

    private static void testSortByName() {
        System.out.println("Sorting by name alphabetically : ");
        System.out.println(employeeService.sortByName());
    }
}