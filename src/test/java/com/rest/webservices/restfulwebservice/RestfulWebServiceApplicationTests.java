package com.rest.webservices.restfulwebservice;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.rest.webservices.restfulwebservice.controller.HomePageMenuController;
import com.rest.webservices.restfulwebservice.model.HomePageMenu;

@SpringBootTest
@AutoConfigureMockMvc
class RestfulWebServiceApplicationTests {

	
	
	@Autowired(required = true)
	private MockMvc mockMvc;
	
	HomePageMenu tes = new HomePageMenu((long) 1, "userTest", "moduleTest", 1);
	private List<HomePageMenu> mockMenu = new ArrayList<HomePageMenu>();	
	
	@MockBean
	private HomePageMenuController repository;
	
	@Test
	void test() throws Exception {
		
		mockMenu.add(tes);
		
		Mockito.when(repository.retrieveAll()).thenReturn((List<HomePageMenu>) mockMenu);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getAll").accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		String expected = "[{\"id\":1,\"userID\":\"userTest\",\"module_name\":\"moduleTest\",\"module_order\":1}]";
		
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
		
	}

}
