package lambdas.chp06;

import lambdas.employee.Designation;
import lambdas.employee.Employee;
import lambdas.employee.Skill;
import lambdas.employee.Unit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class MethodReferenceTest {

    public static void main(String[] args) {

        //1.Method reference to static method
        //Classname::static method
        methodRefrenceStaticMethod();

        //2. Method reference to instance method of arbitrary type
        //Classname::instance method
        methodReferenceInstanceMethodViaClass();

        //3. Method reference to instance method of existing object
        //obj::instancemethod
        methodReferenceInstanceMethodViaObject();

    }

    private static void methodRefrenceStaticMethod() {

        //1.Method reference to a static method
        //Classname::static method

        //1.
        ToIntBiFunction<Integer, Integer> maximumLambda = (a,b) -> Integer.max(a,b);
        ToIntBiFunction<Integer, Integer> maximumMR = Integer::max;

        System.out.println(" Lambda " + maximumLambda.applyAsInt(10,20));
        System.out.println(" MethodReference : " + maximumMR.applyAsInt(10,20));
    }

    private static void methodReferenceInstanceMethodViaClass() {
        //Method reference to instance method of arbitrary type.
        //Classname :: instance method
        //Key - Method of an object is referred and that object passed on as one of the parameters.

        System.out.println("Method reference to instance method of arbitrary type");
        String input = "Lambdas";

        ToIntFunction<String> lengthLambdas = (String s) -> s.length();
        ToIntFunction<String> lengthMethodReference = String::length;

        System.out.println("Length using lambdas : " + lengthLambdas.applyAsInt(input));
        System.out.println("Length using Method Reference : " + lengthMethodReference.applyAsInt(input));

        //2.Find Substring
        BiFunction<String, Integer, String> subStringLambdas = (text, position) -> text.substring(position);
        BiFunction<String, Integer, String> subStringMethodReference = String::substring;

        System.out.println("subStringLambdas : " + subStringLambdas.apply(input,3));
        System.out.println("subStringMethodReference : " + subStringMethodReference.apply(input,3));

        //3. Get Employee name from EMPloyee object
        Function<Employee, String> employeeToNameLambdas = e -> e.getName();
        Function<Employee, String> employeeToNameMR = Employee::getName;

        Employee emp = new Employee("Balaji",15, Designation.DEVELOPER, Unit.FS, Arrays.asList(Skill.JAVA,Skill.JPA));
        System.out.println("employeeToNameLambdas : " + employeeToNameLambdas.apply(emp));
        System.out.println("employeeToNameMR : " + employeeToNameMR.apply(emp));

        //4.Arrays.sort
        System.out.println("Sorting an array using Lambdas/Method reference");
        String[] names = { "Amit", "James", "Rahul", "John", "Patricia",
                "Peter", "Stanley", "Anaya" };

        Arrays.sort(names,(s1,s2) -> s1.compareToIgnoreCase(s2));
        //Arrays.sort(names, String::compareToIgnoreCase);

        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }

    }

    private static void methodReferenceInstanceMethodViaObject() {

        //Method reference to instance method of existing object
        // obj::instancemethod

        //1.
        Consumer<String> printLambda = (s) -> System.out.println(s);
        Consumer<String> printMR = System.out::println;

        //2.
        List<String> list = Arrays.asList("a","b","c","d","e");
        //list.forEach(printLambda);
        list.forEach(printMR);

        //3.
        List<Employee> filteredEmployee = new ArrayList<>();

        Consumer<Employee> employeeLambdas = (Employee e) -> filteredEmployee.add(e);
        Consumer<Employee> employeeMR = filteredEmployee::add;

        List<Employee> empList = EmployeeUtil.initialize();
        System.out.println("filteredEmployee b4 :  ");
        empList.forEach(employeeMR);
        System.out.println("filteredEmployee After :  ");
        System.out.println(filteredEmployee);

    }
}
