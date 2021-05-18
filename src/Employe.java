package edu;

public class Employe{

  public String name;
  public String lastName;
  public int id;
  public int age;

  //constructor
  public Employe(String name, String lastName, int id, int age){
    this.name     = name;
    this.lastName = lastName;
    this.id       = id;
    this.age      = age;
  }

  //convert to string
  public String toString(){
    return "Employe{" +
    "name:"     + this.name +
    ", lastName:" + this.lastName +
    ", id:"       + String.valueOf(this.id) +
    ", age:"      + String.valueOf(age) +
    "}";
  }

}
