package camt.cbsd.lab05.dao;

import camt.cbsd.lab05.entity.Student;

import java.util.List;

public interface StudentDao {
    List<Student> getStudents();
    Student findById(long id);
    Student findByUserUsername(String username);
    Student addStudent(Student student);

    List<Student> getStudents(String searchText);

    Integer size();
}
