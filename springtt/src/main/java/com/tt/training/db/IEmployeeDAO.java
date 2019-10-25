package com.tt.training.db;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tt.training.model.Employee;

public interface IEmployeeDAO extends CrudRepository<Employee, Long> {
	List<Employee> findByName(String name);

	List<Employee> findByNameAndSurname(String name, String surname);

	@Query("select e from Employee e where e.name= :isim")
	List<Employee> customSelect(@Param("isim") String name);

	@Query(value = "select * from calisan where name = :isim",nativeQuery = true)
	List<Employee> customSelectNative(@Param("isim") String name);

}
