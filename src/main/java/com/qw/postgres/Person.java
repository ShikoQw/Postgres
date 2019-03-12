package com.qw.postgres;

public class Person {
  String name;
  int age;
  int id;

  @Override
  public String toString() {
    return "Person{" +
      "name='" + name + '\'' +
      ", age=" + age +
      ", id=" + id +
      '}';
  }
}
