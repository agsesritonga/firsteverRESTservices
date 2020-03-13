package com.rest.webservices.restfulwebservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class HomePageMenu {
	
	@Id
	@GeneratedValue
	private Long id;
	private String userID;
	private String module_name;
	private Integer module_order;
	
	protected HomePageMenu() {
		
	}
	
	public HomePageMenu(Long id, String userID, String module_name, Integer module_order) {
		super();
		this.id = id;
		this.userID = userID;
		this.module_name = module_name;
		this.module_order = module_order;
	}



	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	@Override
	public String toString() {
		return String.format("HomePageMenu [id=%s, userID=%s, module_name=%s, module_order=%s]", id, userID,
				module_name, module_order);
	}



	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getModule_name() {
		return module_name;
	}

	public void setModule_name(String module_name) {
		this.module_name = module_name;
	}

	public Integer getModule_order() {
		return module_order;
	}

	public void setModule_order(Integer module_order) {
		this.module_order = module_order;
	}

	
	



	
}
