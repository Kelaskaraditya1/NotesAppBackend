package com.StarkIndustries.NotesAppBackend.NotesSection.Repository;

import com.StarkIndustries.NotesAppBackend.NotesSection.Model.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotesRepository extends JpaRepository<Notes,Integer> {

    public List<Notes> findByUsername(String username);

    public Notes findByNoteIdAndUsername(int noteId,String username);
}
