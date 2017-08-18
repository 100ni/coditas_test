package com.coditas.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coditas.data.dto.Note;
import com.coditas.data.dto.User;
import com.coditas.data.entity.NoteEntity;
import com.coditas.data.entity.UserEntity;
import com.coditas.repository.NoteJpaRepository;
import com.coditas.service.NoteService;
import com.coditas.service.UserService;

@Service
@Transactional
public class NoteServiceImpl implements NoteService {

	@Resource
	UserService userService;
	
	@Resource
	NoteJpaRepository noteJpaRepository;
	
	@Override
	public NoteEntity findById(Integer id) {
		return noteJpaRepository.findOne(id);
	}

	@Override
	public List<NoteEntity> findAll() {
		Iterable entities = noteJpaRepository.findAll();
		List list = new ArrayList<NoteEntity>();
		entities.forEach(item -> {
			list.add(item);
		});
		return list;
	}

	@Override
	public Note save(Note note) {
		return update(note) ;
	}

	@Override
	public Note create(Note note) {

		NoteEntity noteEntity =  mapNoteToNoteEntity(note);
		NoteEntity noteEntitySaved = noteJpaRepository.save(noteEntity);
		return mapNoteEntityToNote(noteEntitySaved);
	}

	@Override
	public Note update(Note note) {
		NoteEntity noteEntity = noteJpaRepository.findOne(note.getId());
		noteEntity = mapNoteToNoteEntity(note, noteEntity);
		NoteEntity noteEntitySaved = noteJpaRepository.save(noteEntity);
		return mapNoteEntityToNote(noteEntitySaved);
	}

	@Override
	public void delete(Integer id) {
		noteJpaRepository.delete(id);
	}

	public NoteJpaRepository getNoteJpaRepository() {
		return noteJpaRepository;
	}

	public void setNoteJpaRepository(NoteJpaRepository noteJpaRepository) {
		this.noteJpaRepository = noteJpaRepository;
	}

	NoteEntity mapNoteToNoteEntity(Note note){
		NoteEntity entity = new NoteEntity();
		entity.setNote(note.getNote());
		entity.setTitle(note.getTitle());
		entity.setCreateTime(note.getCreateTime());
		entity.setUpdateTime(note.getUpdateTime());
		entity.setUser(userService.findById(note.getUserId()));
		return entity;
	}
	
	NoteEntity mapNoteToNoteEntity(Note note,NoteEntity entity){
		entity.setNote(note.getNote());
		entity.setTitle(note.getTitle());
		entity.setCreateTime(note.getCreateTime());
		entity.setUpdateTime(note.getUpdateTime());
		entity.setUser(userService.findById(note.getUserId()));
		return entity;
	}
	
	Note mapNoteEntityToNote(NoteEntity entity) {
		Note note = new Note();
		note.setId(entity.getId());
		note.setNote(entity.getNote());
		note.setTitle(entity.getTitle());
		note.setCreateTime(entity.getCreateTime());
		note.setUpdateTime(entity.getUpdateTime());
		note.setUserId(entity.getUser().getId());
		return note;
	}
	


}
