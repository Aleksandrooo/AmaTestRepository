package main.java;

public class Student extends Man {

    int yearsOfEducation;

    public Student(String manName) {
        super(manName);
    }

    public Student(String manName, int age , int weight, String sex) {
        super(manName, age, weight, sex);

    }

    public int getYearsOfEducation() {
        return yearsOfEducation;
    }

    public void setYearsOfEducation(int yearsOfEducation) {
        this.yearsOfEducation = yearsOfEducation;
    }
}
