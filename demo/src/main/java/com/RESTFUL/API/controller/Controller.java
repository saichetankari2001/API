package com.RESTFUL.API.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RESTFUL.RestUser;

@RestController
@RequestMapping("/users")
class Controller {
	
	Map<String, RestUser> allUsers = new HashMap<>();
	
	@GetMapping
	public Collection<RestUser> getmethod() {
		return allUsers.values();
	}
	
	@PostMapping
	public String postmethod(@RequestBody RestUser userDetails) {
		RestUser addValue = new RestUser();
		addValue.setId(userDetails.getId());
		addValue.setName(userDetails.getName());
		addValue.setEmail(userDetails.getEmail());
		addValue.setAge(userDetails.getAge());
		allUsers.put(userDetails.getId(), addValue);
		return "User Added";
	}
	
	@PutMapping(path="/{userid}")
	public String putmethod(@PathVariable String  userid, @RequestBody RestUser userDetails) {
		if(allUsers.containsKey(userid)) {
			RestUser addValue = new RestUser();
			addValue.setId(userDetails.getId());
			addValue.setName(userDetails.getName());
			addValue.setEmail(userDetails.getEmail());
			addValue.setAge(userDetails.getAge());
			allUsers.put(userDetails.getId(), addValue);
			return"edit is done";
		}
		else {
			return "edit is not done";
		}
	}
	
	@DeleteMapping(path="/{userid}")
	public String deletemethod(@PathVariable String  userid) {
		if(allUsers.containsKey(userid)) {
			allUsers.remove(userid);
			return"Deleted sucessfully";
		}
		else {
			return "userid not found";
		}
	}

}
