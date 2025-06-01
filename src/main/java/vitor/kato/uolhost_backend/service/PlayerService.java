package vitor.kato.uolhost_backend.service;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vitor.kato.uolhost_backend.model.Player;
import vitor.kato.uolhost_backend.model.dtos.PlayerDto;
import vitor.kato.uolhost_backend.repositories.PlayerRepository;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository repository;

    public Player createPlayer(PlayerDto playerDto) {
        Player newPlayer = new Player(playerDto);
        return repository.save(newPlayer);
    }
}
