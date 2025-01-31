package com.StarkIndustries.NotesAppBackend.Authentication.Controller;

import com.StarkIndustries.NotesAppBackend.Authentication.Models.Profile;
import com.StarkIndustries.NotesAppBackend.Authentication.Repository.ProfileRepository;
import com.StarkIndustries.NotesAppBackend.Authentication.Service.JwtService;
import com.StarkIndustries.NotesAppBackend.Authentication.Service.MyUserDetailsService;
import com.StarkIndustries.NotesAppBackend.Authentication.Service.ProfileService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
@Slf4j
public class Controller {

    private static final Logger log = LoggerFactory.getLogger(Controller.class);
    @Autowired
    public ProfileService profileService;

    @Autowired
    public JwtService jwtService;

    @Autowired
    public MyUserDetailsService userDetailsService;

    @Autowired
    public ProfileRepository profileRepository;

    @GetMapping("/greetings")
    public ResponseEntity<String> greetings(){
        return ResponseEntity.status(HttpStatus.OK).body("Greetings\nI am Ironman");
    }

    @PostMapping("/signup")
    public ResponseEntity<Profile> signup(@Valid @RequestBody Profile profile){
        Profile profile1 = profileService.signUp(profile);
        if(profile1!=null)
            return ResponseEntity.status(HttpStatus.CREATED).body(profile1);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestBody Profile profile){
        if(profileService.login(profile)!="false")
            return ResponseEntity.status(HttpStatus.OK).body(profileService.login(profile));
        else
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Failed to Login!!");
    }

    @GetMapping("/get-users")
    public ResponseEntity<List<Profile>> getUsers(){
        if(!profileService.getUsers().isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(profileService.getUsers());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/validate-token")
    public ResponseEntity<Boolean> validateToken(@RequestHeader("Authorization") String authHeader){
        if(authHeader!=null && authHeader.startsWith("Bearer ")){
            String token = authHeader.substring(7);
            String username = jwtService.extractUserName(token);
            if(profileRepository.findByUsername(username)!=null)
                return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

}
