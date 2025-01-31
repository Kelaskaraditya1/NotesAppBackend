package com.StarkIndustries.NotesAppBackend.Authentication.Service;

import com.StarkIndustries.NotesAppBackend.Authentication.Models.Profile;
import com.StarkIndustries.NotesAppBackend.Authentication.Repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {

    @Autowired
    public ProfileRepository profileRepository;

    @Autowired
    public AuthenticationManager authenticationManager;

    public boolean login(Profile profile){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(profile.getUsername(),profile.getPassword())
        );
        if(authentication.isAuthenticated())
            return true;
        return false;
    }

    public Profile signUp(Profile profile){

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

        if(profileRepository.findByUsername(profile.getUsername())==null){
            profile.setPassword(bCryptPasswordEncoder.encode(profile.getPassword()));
            profileRepository.save(profile);
            return profile;
        }
        return null;
    }

    public List<Profile> getUsers(){
        return profileRepository.findAll();
    }
}
