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

import com.coditas.data.dto.Note;
import com.coditas.data.entity.NoteEntity;
import com.coditas.service.NoteService;

@RestController
public class NoteController {
	@Resource
	private NoteService noteService;
	
	@RequestMapping( value="/note",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<NoteEntity> findAll() {
		return noteService.findAll();
	}

	@RequestMapping( value="/note/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Note findOne(@PathVariable("id") Integer id) {
		return noteService.findById(id);
	}
	
	@RequestMapping( value="/note",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Note create(@RequestBody Note note) {
		return noteService.create(note);
	}

	@RequestMapping( value="/note/{id}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Note update(@PathVariable("id") Integer id, @RequestBody Note note) {
		return noteService.update(note);
	}

	@RequestMapping( value="/note/{id}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("id") Integer id) {
		noteService.delete(id);
	}
}
