package com.StarkIndustries.NotesAppBackend.Authentication.Service;

import com.StarkIndustries.NotesAppBackend.Authentication.Models.Profile;
import com.StarkIndustries.NotesAppBackend.Authentication.Models.UserPrinciples;
import com.StarkIndustries.NotesAppBackend.Authentication.Repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    public ProfileRepository profileRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Profile profile = profileRepository.findByUsername(username);
        return new UserPrinciples(profile);
    }
}
