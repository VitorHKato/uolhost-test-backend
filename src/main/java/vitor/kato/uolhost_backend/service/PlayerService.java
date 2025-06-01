package vitor.kato.uolhost_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vitor.kato.uolhost_backend.infra.CodinameHandler;
import vitor.kato.uolhost_backend.model.GroupType;
import vitor.kato.uolhost_backend.model.Player;
import vitor.kato.uolhost_backend.model.dtos.PlayerDto;
import vitor.kato.uolhost_backend.repositories.PlayerRepository;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository repository;

    @Autowired
    private CodinameHandler handler;

    public Player createPlayer(PlayerDto playerDto) {
        Player newPlayer = new Player(playerDto);
        String codiname = getCodiname(playerDto.groupType());
        newPlayer.setCodiname(codiname);
        return repository.save(newPlayer);
    }

    private String getCodiname(GroupType groupType) {
        return handler.findCodiname(groupType);
    }

    public List<Player> getAllPlayers() {
        return repository.findAll();
    }
}
