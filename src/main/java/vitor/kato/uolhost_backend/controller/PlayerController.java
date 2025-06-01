package vitor.kato.uolhost_backend.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vitor.kato.uolhost_backend.model.Player;
import vitor.kato.uolhost_backend.model.dtos.PlayerDto;
import vitor.kato.uolhost_backend.service.PlayerService;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService service;

    @PostMapping
    public ResponseEntity<Player> createPlayer(@RequestBody @Valid PlayerDto playerDto) {
        Player newPlayer = service.createPlayer(playerDto);
        return new ResponseEntity<>(newPlayer, HttpStatus.CREATED);
    }

}
