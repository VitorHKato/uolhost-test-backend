package vitor.kato.uolhost_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vitor.kato.uolhost_backend.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {



}
