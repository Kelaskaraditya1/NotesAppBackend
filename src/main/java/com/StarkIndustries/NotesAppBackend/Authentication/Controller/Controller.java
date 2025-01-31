package com.StarkIndustries.NotesAppBackend.Authentication.Controller;

import com.StarkIndustries.NotesAppBackend.Authentication.Models.Profile;
import com.StarkIndustries.NotesAppBackend.Authentication.Service.ProfileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class Controller {

    @Autowired
    public ProfileService profileService;

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
        if(profileService.login(profile))
            return ResponseEntity.status(HttpStatus.OK).body("Login Successfully!!");
        else
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Failed to Login!!");
    }

    @GetMapping("/get-users")
    public ResponseEntity<List<Profile>> getUsers(){
        if(!profileService.getUsers().isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(profileService.getUsers());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
