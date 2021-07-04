package org.techhub.service;

import java.util.List;

import org.techhub.model.Student;

public interface StudentService {
 public boolean isAddnewStudent(Student student);
 public List<Student> getAllStudentRecords();
 public boolean isDeletedRecord(int id);
public boolean isUpdateRecord(String name, String email, String contact,int id);
}
