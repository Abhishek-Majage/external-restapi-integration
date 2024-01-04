package com.external.restapi.service;

import com.external.restapi.output.PostOfficeResponse;

public interface IPostOffice {

	public PostOfficeResponse fetchPostOfficeDetailsByCity(String city);
}
