package com.coditas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coditas.data.entity.NoteEntity;

public interface NoteJpaRepository extends JpaRepository<NoteEntity, Integer> {

}
