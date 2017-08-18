package com.coditas.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.coditas.data.dto.Note;
import com.coditas.data.entity.NoteEntity;
import com.coditas.repository.NoteJpaRepository;
import com.coditas.service.NoteService;
import com.coditas.service.UserService;

@Service
public class NoteServiceImpl implements NoteService {

	@Resource
	UserService userService;
	
	@Resource
	NoteJpaRepository noteRepository;
	
	@Override
	public Note findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NoteEntity> findAll() {
		Iterable entities = noteRepository.findAll();
		List list = new ArrayList<NoteEntity>();
		entities.forEach(item -> {
			list.add(item);
		});
		return list;
	}

	@Override
	public Note save(Note entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Note update(Note entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Note create(Note entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
