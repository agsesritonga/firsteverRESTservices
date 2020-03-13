package com.rest.webservices.restfulwebservice.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.rest.webservices.restfulwebservice.model.HomePageMenu;

@Repository
public interface HomePageMenuRepository extends JpaRepository<HomePageMenu, Long>, JpaSpecificationExecutor<HomePageMenu>{
	

}
