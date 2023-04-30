package lambdas.chp03;

import lambdas.ch02.EmployeeFilter;
import lambdas.employee.Designation;
import lambdas.employee.Employee;
import lambdas.employee.Skill;
import lambdas.employee.Unit;

import java.util.ArrayList;
import java.util.List;

public class EmployeeTestAnonymousToRefactor {

    static List<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {

        initialize();

        //1.Get list of all employees in EDC unit
        System.out.println(" -------  1.Get list of all employees in EDC unit -------  ");
        EmployeeFilter edcfiter = emp -> emp.getUnit().equals(Unit.EDC);
        List<Employee> edcEmployees = getAllEmployeesWithFilter((emp) -> emp.getUnit().equals(Unit.EDC));

        System.out.println(edcEmployees);

        //2.Get list of all employees in FS unit
        System.out.println(" ------- 2.Get list of all employees in FS unit ------- ");
        List<Employee> fsEmployees = getAllEmployeesWithFilter((emp) -> emp.getUnit().equals(Unit.FS));
        System.out.println(fsEmployees);

        //3.Get list of all employees with JAVA skills
        System.out.println(" ----------- 3.Get list of all employees with JAVA skills ----------- ");
        List<Employee> empWithJavaSkills = getAllEmployeesWithFilter(emp -> {return emp.getSkills().contains(Skill.JAVA);});
        System.out.println(empWithJavaSkills);

        //4.Get list of senior employees
        System.out.println("---------- 4.Get list of senior employees ----------");
        List<Employee> seniorEmployees = getAllEmployeesWithFilter((emp) -> emp.getExperience()>10);
        System.out.println(seniorEmployees);

    }

    public static List<Employee> getAllEmployeesWithFilter(EmployeeFilter filter){

        List<Employee> filteredEmployees = new ArrayList<>();

        for(Employee emp : employees){
            if(filter.filterEmployee(emp))
                filteredEmployees.add(emp);
        }

        return filteredEmployees;

    }

    private static void initialize(){
        List<Skill> dev1Skills = new ArrayList<>();
        dev1Skills.add(Skill.JAVA);
        dev1Skills.add(Skill.JPA);

        //Amit is a developer with Java, Jpa
        employees.add(new Employee("Amit",8, Designation.DEVELOPER, Unit.EDC, dev1Skills));

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
        dev2Skills.add(Skill.ANGULARJS);
        dev2Skills.add(Skill.JAVASCRIPT);
        employees.add(new Employee("Stanley",3,Designation.DEVELOPER,Unit.OIL_GAS,dev3Skills));

        //Manoj with Java & Angular as a programmer in FS
        List<Skill> dev5Skills = new ArrayList<>();
        dev5Skills.add(Skill.ANGULARJS);
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