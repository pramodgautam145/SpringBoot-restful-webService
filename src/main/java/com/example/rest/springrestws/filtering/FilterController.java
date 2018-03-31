package com.example.rest.springrestws.filtering
;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilterController {

	@GetMapping(path ="/filtering")
	public MappingJacksonValue retrieveSomeBean()
	{
		SomeBean somebean = new SomeBean("value1", "value2", "value3");
		//here logic for Dynamic filter
		SimpleBeanPropertyFilter filter =SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		FilterProvider filterProvider=new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
	    MappingJacksonValue jacksonValue = new MappingJacksonValue(somebean);
		jacksonValue.setFilters(filterProvider);
		return jacksonValue;
	}
	
	/*@GetMapping(path ="/filtering-list")
	public List<SomeBean> retrieveSomeBeanList()
	{
		return Arrays.asList(new SomeBean("value1", "value2", "value3"), new SomeBean("value12", "value22", "value32"));
	}*/
}


