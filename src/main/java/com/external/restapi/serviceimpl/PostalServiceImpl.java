package com.external.restapi.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.external.restapi.output.PostOfficeDetails;
import com.external.restapi.output.PostOfficeResponse;
import com.external.restapi.service.IPostOffice;

@Service("postalServiceImpl")
public class PostalServiceImpl implements IPostOffice {

	//Here RestTemplate is injected to use its functionality
	@Autowired
	RestTemplate restTemplate;
	
	
	@SuppressWarnings("deprecation")
	@Override
	public PostOfficeResponse fetchPostOfficeDetailsByCity(String cityValue) {
		
		String url = "https://api.postalpincode.in/postoffice/{city}";
		url = url.replace("{city}", cityValue);
		System.out.println("URL is: "+url);
		
		//Here PostOfficeResponse is taken as array because it is returning Json String array
		ResponseEntity<PostOfficeResponse[]> postalReponseEntity=
		restTemplate.getForEntity(url, PostOfficeResponse[].class);
		System.out.println("Response Status Code: "+postalReponseEntity.getStatusCodeValue());
		
		PostOfficeResponse[] responseBeanArray =postalReponseEntity.getBody();
		
		for(PostOfficeResponse responseBean:responseBeanArray) {
			List<PostOfficeDetails> postOfficeListBean = responseBean.getPostOffice();
			for(PostOfficeDetails pod: postOfficeListBean ) {
				System.out.println(pod.getName()+"***"+pod.getCountry()+"***"+pod.getPincode());
			}
		}
		
		return responseBeanArray[0];
	}

}
