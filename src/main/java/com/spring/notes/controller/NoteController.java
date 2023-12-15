package com.spring.notes.controller;

import com.spring.notes.model.Note;
import com.spring.notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/notes")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @PostMapping
    public ResponseEntity<Note> save(@RequestBody Note note) {
        return ResponseEntity.status(HttpStatus.CREATED).body((noteService.save(note)));
    }

    @GetMapping
    public ResponseEntity<List<Note>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(noteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Note>> findById(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(noteService.findById(id));
    }

    @PutMapping()
    public ResponseEntity<Note> update(@RequestBody Note note) {
        return ResponseEntity.status(HttpStatus.OK).body(noteService.update(note));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable UUID id) {
        noteService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
