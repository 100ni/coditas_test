package com.coditas.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.coditas.data.dto.User;
import com.coditas.data.entity.UserEntity;
import com.coditas.repository.UserJpaRepository;
import com.coditas.service.NoteService;
import com.coditas.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Resource
	NoteService noteService;
	
	@Resource
	UserJpaRepository userRepository;
	
	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserEntity> findAll() {
		List<UserEntity> users = userRepository.findAll();
		List list = new ArrayList<UserEntity>();
		users.forEach(item -> {
			list.add(item);
		});
		return list;
	}

	@Override
	public User save(User entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User update(User entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User create(User entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
