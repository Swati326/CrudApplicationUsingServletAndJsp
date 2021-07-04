package org.techhub.repository;

import java.util.List;

import org.techhub.model.Student;

public interface StudentRepository {
public boolean isAddnewStudent(Student student);
public List<Student> getAllStudentRecords();
public boolean isDeletedRecord(int id);
public boolean isUpdateRecord(String name, String email, String contact,int id);
}
