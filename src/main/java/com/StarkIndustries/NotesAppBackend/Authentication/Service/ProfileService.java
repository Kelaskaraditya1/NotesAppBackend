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

    @Autowired
    public JwtService jwtService;

    public String login(Profile profile){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(profile.getUsername(),profile.getPassword())
        );
        if(authentication.isAuthenticated())
            return jwtService.getJwtToken(profile.getUsername());
        return "false";
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

    public Profile addProfilePicUrl(String username,String profilePicUrl){
        Profile profile = profileRepository.findByUsername(username);
        if(profile!=null){
            profile.setProfilePicUrl(profilePicUrl);
            profileRepository.save(profile);
            return profile;
        }
        return null;
    }

    public boolean deleteUser(int userId){
        if(profileRepository.existsById(userId)){
            profileRepository.deleteById(userId);
            return true;
        }
        return false;
    }
}
