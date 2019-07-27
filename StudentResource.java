package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class StudentResource {
	
	@Autowired
	StudentRepository repo;
	
@GetMapping("students")
public List<Student> getStudents(){
	
	List<Student> students=(List<Student>) repo.findAll();
				return students;

}


@GetMapping("students/{id}")
public Optional<Student> getStudent(@PathVariable int id){
	
	Optional<Student> student=repo.findById(id);
	
				return student;
}

@PostMapping("students")
public Student setStudents(@RequestBody Student st){
	
	Student students=repo.save(st);
	System.out.println(students);
				return students;
	
}

@PutMapping("students/{id}")
public Optional<Student> updateStudent(@RequestBody Student stud, @PathVariable int id){
	
	return repo.findById(id)
			.map(student->{
				student.setName(stud.getName());
				return repo.save(student);
			});
			
	
}

@DeleteMapping("students/{id}")
public void deleteStudent(@PathVariable int id){
	
	repo.deleteById(id);
	
				
	
}
}
