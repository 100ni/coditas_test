package com.coditas.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coditas.data.dto.User;
import com.coditas.data.entity.UserEntity;
import com.coditas.repository.UserJpaRepository;
import com.coditas.service.NoteService;
import com.coditas.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Resource
	NoteService noteService;
	
	@Resource
	UserJpaRepository userJpaRepository;
	
	@Override
	public UserEntity findById(Integer id) {
		return userJpaRepository.findOne(id);
	}
	
	@Override
	public User getUserByLoginId(String loginId) {
		UserEntity userEntity = userJpaRepository.findByLoginId(loginId);
		return mapUserEntityToUser(userEntity);
	}
	
	@Override
	public List<UserEntity> findAll() {
		List<UserEntity> users = userJpaRepository.findAll();
		List list = new ArrayList<UserEntity>();
		users.forEach(item -> {
			list.add(item);
		});
		return list;
	}

	@Override
	public User save(User user) {
		return update(user) ;
	}

	@Override
	public User create(User user) {
		UserEntity userEntity = mapUserToUserEntity(user);
		userEntity.setCreateTime(new Date());
		userEntity.setUpdateTime(new Date());
		UserEntity userEntitySaved = userJpaRepository.save(userEntity);
		return mapUserEntityToUser(userEntitySaved);
	}

	@Override
	public User update(User user) {
		UserEntity userEntity = userJpaRepository.findOne(user.getId());
		userEntity = mapUserToUserEntity(user, userEntity);
		userEntity.setUpdateTime(new Date());
		UserEntity userEntitySaved = userJpaRepository.save(userEntity);
		return mapUserEntityToUser(userEntitySaved);
	}

	@Override
	public void delete(Integer id) {
		userJpaRepository.delete(id);
	}

	public UserJpaRepository getUserJpaRepository() {
		return userJpaRepository;
	}

	public void setUserJpaRepository(UserJpaRepository userJpaRepository) {
		this.userJpaRepository = userJpaRepository;
	}

	UserEntity mapUserToUserEntity(User user){
		UserEntity entity = new UserEntity();
		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setPassword(user.getPassword());
		return entity;
	}
	
	UserEntity mapUserToUserEntity(User user,UserEntity entity){
		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setPassword(user.getPassword());
		return entity;
	}
	User mapUserEntityToUser(UserEntity entity) {
		User user = new User();
		user.setId(entity.getId());
		user.setName(entity.getName());
		user.setEmail(entity.getEmail());
		user.setPassword(entity.getPassword());
		user.setCreateTime(entity.getCreateTime());
		user.setUpdateTime(entity.getUpdateTime());
		return user;
	}
}
