package com.paypal.bfs.test.employeeserv.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.model.EmployeeEntity;
import com.paypal.bfs.test.employeeserv.repo.EmployeeRepository;
import com.paypal.bfs.test.employeeserv.util.EmpMapper;

/**
 * Implementation class for employee resource.
 */
@RestController
public class EmployeeResourceImpl implements EmployeeResource {

	@Autowired
	EmployeeRepository employeeRepository;


	/**
	 * 
	 */
	@Override
	public ResponseEntity<Employee> employeeGetById(String id) {
		Optional<EmployeeEntity> empEntity = employeeRepository.findById(Integer.valueOf(id));

		if (empEntity.isPresent()) {
			Employee employee = EmpMapper.getEmployeeObj(empEntity.get());
			return new ResponseEntity<>(employee, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * 
	 */
	@Override
	public ResponseEntity<String> createEmployee(Employee employee) {
		try {
			EmployeeEntity entity=  employeeRepository.save(EmpMapper.getEmpEntity(employee));
			return new ResponseEntity<>("Employee Created Successfully with id:"+entity.getId(),HttpStatus.CREATED);
		}catch(Exception ex) {
			return new ResponseEntity<>("Error while creating Employee", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
