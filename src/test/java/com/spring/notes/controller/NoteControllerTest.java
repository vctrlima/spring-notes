package com.spring.notes.controller;

import com.spring.notes.model.Note;
import com.spring.notes.service.NoteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class NoteControllerTest {
    @InjectMocks
    NoteController noteController;

    @Mock
    NoteService noteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void save() {
        Note note = mock(Note.class);
        when(noteService.save(note)).thenReturn(note);

        var response = noteController.save(note);

        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
        assertEquals(response.getBody(), note);
    }

    @Test
    void findAll() {
        Note note = mock(Note.class);
        var findAllResult = new ArrayList<Note>();
        findAllResult.add(note);
        when(noteService.findAll()).thenReturn(findAllResult);

        var response = noteController.findAll();

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody(), findAllResult);
    }

    @Test
    void findById() {
        Note note = mock(Note.class);
        when(noteService.findById(any())).thenReturn(Optional.ofNullable(note));

        var response = noteController.findById(UUID.randomUUID());

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody(), Optional.ofNullable(note));
    }

    @Test
    void update() {
        Note note = mock(Note.class);
        when(noteService.update(note)).thenReturn(note);

        var response = noteController.update(note);

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody(), note);
    }

    @Test
    void deleteById() {
        var response = noteController.deleteById(UUID.randomUUID());

        assertEquals(response.getStatusCode(), HttpStatus.NO_CONTENT);
    }
}