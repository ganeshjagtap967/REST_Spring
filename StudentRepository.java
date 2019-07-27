package com.example;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer>{

	List<Student> findAll(Sort sortByIdAsc);

}
