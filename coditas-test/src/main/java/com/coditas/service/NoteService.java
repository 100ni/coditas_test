package com.coditas.service;

import java.util.List;

import com.coditas.data.dto.Note;

/**
 * Business Service Interface for entity Note.
 */
public interface NoteService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param id
	 * @return entity
	 */
	Note findById( Integer id  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<Note> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	Note save(Note entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	Note update(Note entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	Note create(Note entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param id
	 */
	void delete( Integer id );


}
