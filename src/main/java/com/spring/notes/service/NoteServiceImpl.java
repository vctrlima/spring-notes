package com.spring.notes.service;

import com.spring.notes.model.Note;
import com.spring.notes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepository noteRepository;

    @Override
    public Note save(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public List<Note> findAll() {
        return noteRepository.findAll();
    }

    @Override
    public Optional<Note> findById(UUID id) {
        return noteRepository.findById(id);
    }

    @Override
    public Note update(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public void deleteById(UUID id) {
        noteRepository.deleteById(id);
    }
}
