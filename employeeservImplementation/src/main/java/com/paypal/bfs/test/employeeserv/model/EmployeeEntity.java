/**
 * 
 */
package com.paypal.bfs.test.employeeserv.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Lakshmipriya
 *
 */
@Entity
@Data
@Table(name = "EMPLOYEE")
public class EmployeeEntity {
	
	@Id
	@GeneratedValue
	private int id;
    private String first_name;
    private String last_name;
    private String date_of_birth;
    
    @OneToOne(mappedBy = "employeeEntity",cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private AddressEntity address;
    
	

}
