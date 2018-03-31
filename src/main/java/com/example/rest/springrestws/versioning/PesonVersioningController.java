package com.example.rest.springrestws.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PesonVersioningController {
   
	//1st Approach for version URI versioning used twitter
	@GetMapping("v1/person")
	public PersonV1 getPersonV1() {
		return new PersonV1("pramod");
	}

	@GetMapping("v2/person")
	public PersonV2 getPersonV2() {

		return new PersonV2(new Name("Kumar", "Gautam"));
	}
	
	//2nd Approach for version requst parameter versioning //used amazon
	//http://localhost:8080/person/param?version=1
	@GetMapping(value ="/person/param" ,params ="version=1")
	public PersonV1 getParamV1() {
		return new PersonV1("pramod");
	}
    //http://localhost:8080/person/param?version=2
	@GetMapping(value ="/person/param" ,params ="version=2")
	public PersonV2 getParamV2() {

		return new PersonV2(new Name("Kumar", "Gautam"));
	}
	
	//3rd Approach for version header versioning
		//http://localhost:8080/person/header
	    //put in header X-API-VERSION = 1
		@GetMapping(value ="/person/header" ,headers ="X-API-VERSION=1")
		public PersonV1 getHeaderV1() {
			return new PersonV1("pramod");
		}
	    //http://localhost:8080/person/header
		//put in header X-API-VERSION = 1
		@GetMapping(value ="/person/header" ,headers ="X-API-VERSION=2")
		public PersonV2 getHeaderV2() {

			return new PersonV2(new Name("Kumar", "Gautam"));
		}
		
		//4th Approach for version header accept versioning 
				//http://localhost:8080/person/produces
			    //put in header Accept =application/vnd.company.app-v2+json
				@GetMapping(value ="/person/produces" , produces ="application/vnd.company.app-v1+json")
				public PersonV1 getProducesV1() {
					return new PersonV1("pramod");
				}
			    //http://localhost:8080/person/produces
				//put in header Accept = application/vnd.company.app-v2+json
				@GetMapping(value ="/person/produces" , produces ="application/vnd.company.app-v2+json")
				public PersonV2 getProducesV2() {

					return new PersonV2(new Name("Kumar", "Gautam"));
				}
}
