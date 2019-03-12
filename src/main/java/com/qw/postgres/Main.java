package com.qw.postgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {
  public static void main(String[] args) throws Exception {
  /* Person person = new Person();
   person.name = ("Misha");
   person.age = 19;
   person.id = 3;
    System.out.println(insertUser(person));*/
    Person person2 = new Person();
    person2.name = ("Masha");
    person2.age = 19;
    person2.id = 2    ;
    updateUser(person2);
    System.out.println(selectUser(person2.id));
    deleteUser(person2.id);
    selectUser(person2.id);
  }
  public static int insertUser(Person person) throws Exception{
    Class.forName("org.postgresql.Driver");
    Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/greetgo", "nikita", "1");
    PreparedStatement prepareStatement = connection.prepareStatement("insert into person values(?,?,?) returning id");
    prepareStatement.setInt(1,person.id);
    prepareStatement.setString(2,person.name);
    prepareStatement.setInt(3,person.age);
    ResultSet rs = prepareStatement.executeQuery();
    rs.next();
    return rs.getInt(1);
  }
  public static void updateUser(Person person) throws Exception{
    Class.forName("org.postgresql.Driver");
    Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/greetgo", "nikita", "1");
    PreparedStatement prepareStatement = connection.prepareStatement("update person set name=?, age=? where id = ?");
    prepareStatement.setString(1,person.name);
    prepareStatement.setInt(2,person.age);
    prepareStatement.setInt(3,person.id);
    prepareStatement.executeUpdate();
  }
  public static Person selectUser(int id) throws Exception {
    Class.forName("org.postgresql.Driver");
    Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/greetgo", "nikita", "1");
    PreparedStatement prepareStatement = connection.prepareStatement("select * from person where id = ?");
    prepareStatement.setInt(1, id);
    ResultSet rs = prepareStatement.executeQuery();
    rs.next();
    Person person = new Person();
    person.id = rs.getInt(1);
    person.name = rs.getString(2);
    person.age = rs.getInt(3);
    return person;
  }
  public static void deleteUser(int id) throws Exception{
    Class.forName("org.postgresql.Driver");
    Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/greetgo", "nikita", "1");
    PreparedStatement prepareStatement = connection.prepareStatement("delete from person where id = ?");
    prepareStatement.setInt(1, id);
    prepareStatement.executeUpdate();
  }
}
