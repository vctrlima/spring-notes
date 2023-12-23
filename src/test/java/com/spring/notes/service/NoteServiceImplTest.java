package com.spring.notes.service;

import com.spring.notes.model.Note;
import com.spring.notes.repository.NoteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class NoteServiceImplTest {
    @InjectMocks
    NoteServiceImpl noteService;

    @Mock
    NoteRepository noteRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void save() {
        Note note = mock(Note.class);
        when(noteRepository.save(note)).thenReturn(note);

        var response = noteService.save(note);

        assertEquals(response, note);
    }

    @Test
    void findAll() {
        Note note = mock(Note.class);
        var findAllResult = new ArrayList<Note>();
        findAllResult.add(note);
        when(noteRepository.findAll()).thenReturn(findAllResult);

        var response = noteService.findAll();

        assertEquals(response, findAllResult);
    }

    @Test
    void findById() {
        Note note = mock(Note.class);
        when(noteRepository.findById(any())).thenReturn(Optional.ofNullable(note));

        var response = noteService.findById(UUID.randomUUID());

        assertEquals(response, Optional.ofNullable(note));
    }

    @Test
    void update() {
        Note note = mock(Note.class);
        when(noteRepository.save(note)).thenReturn(note);

        var response = noteService.update(note);

        assertEquals(response, note);
    }
}