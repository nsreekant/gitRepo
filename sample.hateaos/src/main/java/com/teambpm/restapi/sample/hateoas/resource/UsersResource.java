package com.teambpm.restapi.sample.hateoas.resource;

import org.springframework.web.bind.annotation.RestController;
import com.teambpm.restapi.sample.hateoas.model.Users;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/rest/users")

public class UsersResource {
	@GetMapping("/all")
	
	public List<Users> getAll()
	{
		Users users1 = new Users("Sam",1000L);
		Users users2 = new Users("Mak",2000L);
		return Arrays.asList(users1,users2);
	}
	
	@GetMapping(value = "/hateoas/all", produces=MediaTypes.HAL_JSON_VALUE)
	
	public List<Users> getHateoasAll()
	{
		Users user3 = new Users("Mohan",3000L);
		Link link = ControllerLinkBuilder.linkTo(UsersResource.class).slash(user3.getName()).withSelfRel();
		user3.add(link);
		
		Users user4 = new Users("Ramesh",3000L);
		Link link1 = ControllerLinkBuilder.linkTo(UsersResource.class).slash(user4.getName()).withSelfRel();
		user4.add(link1);
		
		return Arrays.asList(user3,user4);
	}
}