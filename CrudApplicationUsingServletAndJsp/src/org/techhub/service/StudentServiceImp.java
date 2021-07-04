package org.techhub.service;

import java.util.List;

import org.techhub.model.Student;
import org.techhub.repository.StudentRepositoryImpl;

public class StudentServiceImp implements StudentService {
	StudentRepositoryImpl studRepo=new StudentRepositoryImpl();

	@Override
	public boolean isAddnewStudent(Student student) {
		// TODO Auto-generated method stub
		return studRepo.isAddnewStudent(student);
	}

	@Override
	public List<Student> getAllStudentRecords() {
		// TODO Auto-generated method stub
		return studRepo.getAllStudentRecords();
	}

	@Override
	public boolean isDeletedRecord(int id) {
		// TODO Auto-generated method stub
		return studRepo.isDeletedRecord(id);
	
	}

	@Override
	public boolean isUpdateRecord(String name, String email, String contact,int id) {
		// TODO Auto-generated method stub
		return studRepo.isUpdateRecord(name,email,contact,id);
	}

}
