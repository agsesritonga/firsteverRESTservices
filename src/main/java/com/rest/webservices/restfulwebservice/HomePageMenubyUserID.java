package com.rest.webservices.restfulwebservice;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.rest.webservices.restfulwebservice.model.HomePageMenu;

public class HomePageMenubyUserID implements Specification<HomePageMenu> {

	private String userID;
	
	public HomePageMenubyUserID(String userID) {
		super();
		this.userID = userID;
	}

	@Override
	public Predicate toPredicate(Root<HomePageMenu> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		// TODO Auto-generated method stub
		return criteriaBuilder.equal(root.get("userID"), this.userID);
	}

}
