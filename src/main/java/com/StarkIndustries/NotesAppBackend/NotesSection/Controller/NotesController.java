package com.StarkIndustries.NotesAppBackend.NotesSection.Controller;

import com.StarkIndustries.NotesAppBackend.NotesSection.Model.Notes;
import com.StarkIndustries.NotesAppBackend.NotesSection.Service.NotesService;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NotesController {

    @Autowired
    public NotesService notesService;

    @PostMapping("/insert-note")
    public ResponseEntity<Notes> insertNote(@RequestBody Notes notes){
        Notes notes1 = notesService.insertNote(notes);
        if(notes1!=null)
            return ResponseEntity.status(HttpStatus.CREATED).body(notes1);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @GetMapping("/get-notes/{username}")
    public ResponseEntity<List<Notes>> getNotesByUsername(@PathVariable("username") String username){
        if(!notesService.getNotesByUsername(username).isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(notesService.getNotesByUsername(username));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/get-all-notes")
    public ResponseEntity<List<Notes>>  getAllNotes(){
        if(!notesService.getAllNotes().isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(notesService.getAllNotes());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/update-note/{noteId}/{username}")
    public ResponseEntity<Notes> updateNote(@PathVariable("noteId") int noteId, @PathVariable("username") String username, @RequestBody Notes notes){
        Notes notes1 = notesService.updateNote(noteId,username,notes);
        if(notes1!=null)
            return ResponseEntity.status(HttpStatus.OK).body(notes1);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

    @DeleteMapping("/delete-note/{noteId}")
    public ResponseEntity<String> deleteNote(@PathVariable("noteId") int noteId){
        if(notesService.deleteNote(noteId))
            return ResponseEntity.status(HttpStatus.OK).body("Note deleted Successfully!!");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Note not Found");
    }

}
