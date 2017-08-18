package com.coditas.rest.controller;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.coditas.data.dto.User;
import com.coditas.data.entity.UserEntity;
import com.coditas.service.UserService;

@RestController
public class UserController {
	
	@Resource
	private UserService userService;
	
	
	@RequestMapping( value="/user",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<UserEntity> findAll() {
		return userService.findAll();
	}

	@RequestMapping( value="/user/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public UserEntity findOne(@PathVariable("id") Integer id) {
		return userService.findById(id);
	}
	
	@RequestMapping( value="/user",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public User create(@RequestBody User user) {
		return userService.create(user);
	}

	@RequestMapping( value="/user/{id}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public User update(@PathVariable("id") Integer id, @RequestBody User user) {
		return userService.update(user);
	}

	@RequestMapping( value="/user/{id}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("id") Integer id) {
		userService.delete(id);
	}
}
