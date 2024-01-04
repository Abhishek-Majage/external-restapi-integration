package com.external.restapi.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.external.restapi.output.PostOfficeResponse;
import com.external.restapi.service.IPostOffice;

@RestController
@RequestMapping("/postal")
public class PostDetailsController {

	@Autowired
	IPostOffice postalServiceImpl;
	
	//Here we use Consumes of Type ALL(City=>String Value) and produces the Json Array
	@RequestMapping(value="/byCity" , method=RequestMethod.GET,
			consumes=MediaType.ALL_VALUE, produces=MediaType.APPLICATION_JSON_VALUE  )
	public PostOfficeResponse getPostalByCity(@RequestParam String city) {
		
		PostOfficeResponse postReponse;
		
		postReponse= postalServiceImpl.fetchPostOfficeDetailsByCity(city);
		return postReponse;
		
	}
}
