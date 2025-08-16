package com.estefania.forohub.forohub.controller;

import com.estefania.forohub.forohub.dto.JwtResponse;
import com.estefania.forohub.forohub.dto.LoginRequest;
import com.estefania.forohub.forohub.security.JwtService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@Valid @RequestBody LoginRequest req) {

        // 1) Autentica usuario con email + password
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword())
        );

        // 2) Carga el UserDetails (no uses el String directamente)
        UserDetails user = userDetailsService.loadUserByUsername(req.getEmail());

        // 3) Genera el token con UserDetails
        String token = jwtService.generateToken(user);

        // 4) Devuelve el token
        return ResponseEntity.ok(new JwtResponse(token));
    }
}