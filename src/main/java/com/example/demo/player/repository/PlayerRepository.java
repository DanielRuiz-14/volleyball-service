package com.example.demo.player.repository;

import com.example.demo.player.entity.Player;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {


  List<Player> findByFirstNameAndLastName(String firstName, String lastName);

  Optional<Player> findByDni(String dni);

  void deleteByDni(String dni);
}
