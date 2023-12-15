package com.spring.notes.service;

import com.spring.notes.model.Note;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface NoteService {
    Note save(Note note);

    List<Note> findAll();

    Optional<Note> findById(UUID id);

    Note update(Note note);

    void deleteById(UUID id);
}
