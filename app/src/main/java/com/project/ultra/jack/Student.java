package com.project.ultra.jack;

public class Student{
    public int photoid;
    public String name;
    public String phone;

    //public String name;
    public String addr;
    public String tel;

 public Student(int id, String n, String p)
 {
     photoid = id;
     name = n;
     phone = p;

     addr = n;
     tel = p;
 }

    public Student(String n, String a, String p) {

        name = n;
        addr = a;
        tel = p;
    }

//    public void addStudent(Student student) {
//    }
}
