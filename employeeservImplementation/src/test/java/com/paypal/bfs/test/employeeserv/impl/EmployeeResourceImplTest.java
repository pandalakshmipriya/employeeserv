/**
 * 
 */
package com.paypal.bfs.test.employeeserv.impl;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.model.EmployeeEntity;
import com.paypal.bfs.test.employeeserv.repo.EmployeeRepository;
import com.paypal.bfs.test.employeeserv.util.EmpMapper;

/**
 * @author Lakshmipriya
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class EmployeeResourceImplTest {

	@InjectMocks
	private EmployeeResourceImpl employeeResourceImpl;

	@Mock
	private EmployeeRepository repository;

	@Mock
	private Employee employee;

	private Optional<EmployeeEntity> empEntity;

	@Before
	public void setUp() {
		empEntity=Optional.ofNullable(new EmployeeEntity());
	}

	@Test(expected = NullPointerException.class)
	public void testEmployeeGetById() {
		Mockito.when(repository.findById(Mockito.anyInt())).thenReturn(null);
		Mockito.when(employeeResourceImpl.employeeGetById("1234")).thenReturn(new ResponseEntity<Employee>(HttpStatus.OK));
	}
	
	@Test(expected = Exception.class)
	public void testCreateEmployee() {
		Mockito.when(EmpMapper.getEmpEntity(employee)).thenReturn(new EmployeeEntity());
		Mockito.when(repository.save(Mockito.any())).thenReturn(new EmployeeEntity());
		Mockito.when(employeeResourceImpl.createEmployee(employee)).thenReturn(new ResponseEntity<String>(HttpStatus.CREATED));
	}

}
