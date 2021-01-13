/**
 * 
 */
package com.paypal.bfs.test.employeeserv.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Lakshmipriya
 *
 */
@Data
@Entity
@Table(name = "ADDRESS")
public class AddressEntity {
	
	@Id
	private int emp_id;
	private String line1;
	private String line2;
	private String city;
	private String state;
	private String country;
	private int zip_code;
	
	@OneToOne
    @MapsId
    @JoinColumn(name = "emp_id")
    private EmployeeEntity employeeEntity;
}

