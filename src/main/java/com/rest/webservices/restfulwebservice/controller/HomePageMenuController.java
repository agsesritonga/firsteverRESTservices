package com.rest.webservices.restfulwebservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.webservices.restfulwebservice.HomePageMenubyUserID;
import com.rest.webservices.restfulwebservice.model.HomePageMenu;
import com.rest.webservices.restfulwebservice.repositories.HomePageMenuRepository;

@RestController
public class HomePageMenuController {
	
	@Autowired
	private HomePageMenuRepository homePageMenuRepository;
	
	//url to get all data
	@GetMapping("/getAll")
	public List<HomePageMenu> retrieveAll(){
		return homePageMenuRepository.findAll();
	}
	
	//url to get menu by UserID
	@RequestMapping(method = RequestMethod.GET, value = "/getMenu")
	@ResponseBody
	public List<HomePageMenu> userID(@RequestParam(value = "userID") String userID){
		
		Specification<HomePageMenu> spec = Specification.where(new HomePageMenubyUserID(userID));		
		return homePageMenuRepository.findAll(spec);
	}
	
	//url to update order ID
	@PutMapping("/updateOrder/{id}")
	public ResponseEntity<Object> updateOrder(@RequestBody HomePageMenu menu, @PathVariable long id) {

		Optional<HomePageMenu> menuOptional = homePageMenuRepository.findById(id);
		if (!menuOptional.isPresent())
			return ResponseEntity.notFound().build();
		menu.setId(id);
		homePageMenuRepository.save(menu);

		return ResponseEntity.noContent().build();
	}
	

}

