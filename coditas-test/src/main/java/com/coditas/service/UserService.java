package com.coditas.service;

import java.util.List;

import com.coditas.data.dto.User;
import com.coditas.data.entity.UserEntity;

/**
 * Business Service Interface for entity User.
 */
public interface UserService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param id
	 * @return entity
	 */
	UserEntity findById( Integer id  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<UserEntity> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	User save(User entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	User update(User entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	User create(User entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param id
	 */
	void delete( Integer id );


}
