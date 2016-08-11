package com.project.ultra.jack;

import java.util.List;

/**
 * Created by ultra-jack on 2016/8/4.
 */
public interface StudentDAO {

    public void addStudent(Student s);
    public void delStudent(Student s);
    public void updateStudent(Student s);
    public List getAllStudent();

}
