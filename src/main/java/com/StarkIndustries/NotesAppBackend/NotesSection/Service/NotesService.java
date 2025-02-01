package com.StarkIndustries.NotesAppBackend.NotesSection.Service;

import com.StarkIndustries.NotesAppBackend.NotesSection.Model.Notes;
import com.StarkIndustries.NotesAppBackend.NotesSection.Repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotesService {

    @Autowired
    public NotesRepository notesRepository;

    public Notes insertNote(Notes notes){
        if(notes!=null){
            notesRepository.save(notes);
            return notes;
        }
            return notes;
    }

    public List<Notes> getNotesByUsername(String username){
       return notesRepository.findByUsername(username);
    }

    public List<Notes> getAllNotes(){
        return notesRepository.findAll();
    }

    public Notes updateNote(int noteId,String username,Notes notes){
        Notes notes1 = notesRepository.findByNoteIdAndUsername(noteId,username);
        if(notes1!=null){
            notes1.setTitle(notes.getTitle());
            notes1.setContent(notes.getContent());
            notes1.setTimeStamp(notes.getTimeStamp());
            notesRepository.save(notes1);
            return notes1;
        }
        return null;
    }

    public boolean deleteNote(int noteId){
        if(notesRepository.existsById(noteId)){
            notesRepository.deleteById(noteId);
            return true;
        }
        return false;
    }
}
