/**
 * 
 */
package com.paypal.bfs.test.employeeserv.util;

import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.model.AddressEntity;
import com.paypal.bfs.test.employeeserv.model.EmployeeEntity;

/**
 * @author Lakshmipriya
 *
 */
public class EmpMapper {

	/**
	 * 
	 * @param empEntity
	 * @return Employee Object
	 */
	public static Employee getEmployeeObj(EmployeeEntity empEntity) {

		Employee employee = new Employee();

		employee.setId(empEntity.getId());
		employee.setFirstName(empEntity.getFirst_name());
		employee.setLastName(empEntity.getLast_name());
		employee.setDateOfBirth(empEntity.getDate_of_birth());

		Address address = new Address();
		AddressEntity addrEntity = empEntity.getAddress();
		address.setLine1(addrEntity.getLine1());
		address.setLine2(addrEntity.getLine2());
		address.setCity(addrEntity.getCity());
		address.setState(addrEntity.getState());
		address.setCountry(addrEntity.getCountry());
		address.setZipCode(addrEntity.getZip_code());
		employee.setAddress(address);

		return employee;
	}
	/**
	 * 
	 * @param employee
	 * @return EmployeeEntity
	 */
	public static EmployeeEntity getEmpEntity(Employee employee) {
		EmployeeEntity empEntity = new EmployeeEntity();
		empEntity.setFirst_name(employee.getFirstName());
		empEntity.setLast_name(employee.getLastName());
		empEntity.setDate_of_birth(employee.getDateOfBirth());

		AddressEntity addrEntity = new AddressEntity();
		Address address = employee.getAddress();
		addrEntity.setLine1(address.getLine1());
		addrEntity.setLine2(address.getLine2());
		addrEntity.setCity(address.getCity());
		addrEntity.setState(address.getState());
		addrEntity.setCountry(address.getCountry());
		addrEntity.setZip_code((int)address.getZipCode());
		addrEntity.setEmployeeEntity(empEntity);
		empEntity.setAddress(addrEntity);
		return empEntity;
	}

}
