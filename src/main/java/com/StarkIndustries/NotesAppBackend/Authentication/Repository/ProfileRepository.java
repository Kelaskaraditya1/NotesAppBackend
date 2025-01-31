package com.StarkIndustries.NotesAppBackend.Authentication.Repository;

import com.StarkIndustries.NotesAppBackend.Authentication.Models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile,Integer> {
    public Profile findByUsername(String username);
}
