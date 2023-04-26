package ch02;

import java.util.List;

public class Employee {

    private String name;
    private int experience;
    private Designation designation;
    private Unit unit;
    private List<Skill> skills;
    private String email;

    public Employee(String name, int experience, Designation designation, Unit unit, List<Skill> skills) {
        this.name = name;
        this.experience = experience;
        this.designation = designation;
        this.unit = unit;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Designation getDesignation() {
        return designation;
    }

    public void setDesignation(Designation designation) {
        this.designation = designation;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {

        return this.getName() + " with " + this.getExperience() + " years of experience " +  "in Unit " +  this.unit + " has these skills " + this.getSkills() + " \n";
    }


}