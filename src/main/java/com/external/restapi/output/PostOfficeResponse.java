package com.external.restapi.output;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostOfficeResponse {

	@JsonProperty("Message")
	private String message;

	@JsonProperty("Status")
	private String status;
	
	@JsonProperty("PostOffice")
	private List<PostOfficeDetails> postOffice;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<PostOfficeDetails> getPostOffice() {
		return postOffice;
	}

	public void setPostOffice(List<PostOfficeDetails> postOffice) {
		this.postOffice = postOffice;
	}

}

//Here is the exact type of data to be called using our api from external api
//[
// {
//     "Message": "Number of Post office(s) found:22",
//     "Status": "Success",
//     "PostOffice": [
//         {
//             "Name": "Airport (Mumbai)",
//             "Description": null,
//             "BranchType": "Sub Post Office",
//             "DeliveryStatus": "Non-Delivery",
//             "Circle": "Maharashtra",
//             "District": "Mumbai",
//             "Division": "Mumbai  North",
//             "Region": "Mumbai",
//             "State": "Maharashtra",
//             "Country": "India",
//             "Pincode": "400099"
//         },
