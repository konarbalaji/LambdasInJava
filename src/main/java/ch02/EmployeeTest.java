package ch02;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeTest {

    private static List<Employee> employees = new ArrayList();

    public static void main(String[] args) {
        initialize();

        //1.Get me list of all employees in EDC
        System.out.println("---- All in EDC -----");
        List<Employee> allInEdc = getAllEmployeesInEDC();
        System.out.println(allInEdc);

        System.out.println("------ With stream End ");

        //2.Get me list of all employees in FInancial Services
        System.out.println("---- All in FS -----");
        List<Employee> allInFS = getAllEmployeesInFS();
        System.out.println(allInFS);

        //3.Get all employees with java Skills
        System.out.println("---- All Java Developers ----");
        List<Employee> allJavaDevelopers = getAllJavaDevelopers();
        System.out.println(allJavaDevelopers);

        //4.Get all senior employees
        System.out.println(" --- All Employees with greater than 10 years experience ---------- ");
        List<Employee> seniorEmployees = getAllProfessionalsGreaterThan(10);
        System.out.println(seniorEmployees);

    }

    public static List<Employee> getAllEmployeesInEDC(){

        List<Employee> employeesInEDC = new ArrayList<>();
        for(Employee emp : employees){
            if(emp.getUnit() == Unit.EDC){
                employeesInEDC.add(emp);
            }
        }
        return employeesInEDC;

    }

    public static List<Employee> getAllEmployeesInFS(){

        List<Employee> employeesInEDC = new ArrayList<>();
        for(Employee emp : employees){
            if(emp.getUnit() == Unit.FS){
                employeesInEDC.add(emp);
            }
        }
        return employeesInEDC;

    }

    public static List<Employee> getAllJavaDevelopers(){
        List<Employee> javaDeveloeprs = new ArrayList<>();
        for(Employee emp : employees){
            if(emp.getSkills().contains(Skill.JAVA)){
                javaDeveloeprs.add(emp);
            }
        }
        return javaDeveloeprs;
    }

    public static List<Employee> getAllProfessionalsGreaterThan(int experience){
        List<Employee> seniorEmployees = new ArrayList<>();
        for(Employee emp : employees){
            if(emp.getExperience() > 10)
                seniorEmployees.add(emp);
        }
        return seniorEmployees;
    }

    private static void initialize(){
        List<Skill> dev1Skills = new ArrayList<>();
        dev1Skills.add(Skill.JAVA);
        dev1Skills.add(Skill.JPA);

        //Amit is a developer with Java, Jpa
        employees.add(new Employee("Amit",8,Designation.DEVELOPER,Unit.EDC, dev1Skills));

        //Rahul with .Net as a programmer
        List<Skill> dev2Skills = new ArrayList<>();
        dev2Skills.add(Skill.MICROSOFT);
        employees.add(new Employee("Rahul",5,Designation.DEVELOPER,Unit.EDC,dev2Skills));

        //Peter with Python as a programmer in FS
        List<Skill> dev3Skills = new ArrayList<>();
        dev3Skills.add(Skill.PYTHON);
        employees.add(new Employee("Peter",7,Designation.DEVELOPER,Unit.FS,dev3Skills));

        //Stanley with angular/js as a programmer in oil/gas
        List<Skill> dev4Skills = new ArrayList<>();
        dev2Skills.add(Skill.ANGULASJS);
        dev2Skills.add(Skill.JAVASCRIPT);
        employees.add(new Employee("Stanley",3,Designation.DEVELOPER,Unit.OIL_GAS,dev3Skills));

        //Manoj with Java & Angular as a programmer in FS
        List<Skill> dev5Skills = new ArrayList<>();
        dev5Skills.add(Skill.ANGULASJS);
        dev5Skills.add(Skill.JAVA);
        employees.add(new Employee("Manoj",3,Designation.DEVELOPER,Unit.FS,dev5Skills));

        //Jose as a manager
        List<Skill> managerSkills = new ArrayList<>();
        managerSkills.add(Skill.PMP);
        employees.add(new Employee("Jose",15,Designation.MANAGER,Unit.EDC,managerSkills));

        //Pirlo as architetc in EDC
        List<Skill> architechSkills = new ArrayList<>();
        architechSkills.add(Skill.DESIGN);
        employees.add(new Employee("Pirlo",13,Designation.ARCHITECT,Unit.EDC,architechSkills));

    }

}
