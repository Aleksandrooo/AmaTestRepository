package main.java;

public class Man {
    String name;
    int age;
    int weight;
    String sex;

    public Man(String manName){
        this.name=manName;
    }
    public Man(String manName, int age, int weight, String sex){
        this.name=manName;
        this.age=age;
        this.weight=weight;
        this.sex=sex;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public String getSex() {
        return sex;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
