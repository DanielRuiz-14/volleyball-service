package com.example.demo.player.service;

import com.example.demo.exception.PlayerNotFoundException;
import com.example.demo.player.dto.PlayerDto;
import com.example.demo.player.entity.Player;
import com.example.demo.player.mapper.PlayerMapper;
import com.example.demo.player.repository.PlayerRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerSearchService {

  private final PlayerRepository playerRepository;
  private final PlayerMapper playerMapper;

  public PlayerDto getPlayerByFirstnameAndLastname(String firstname, String lastname) {
    List<Player> players = playerRepository.findByFirstNameAndLastName(firstname, lastname);
    return playerMapper.mapFromPlayerEntityToPlayerDto(players.get(0));
  }


  public List<PlayerDto> getAllPlayers() {
    return playerRepository.findAll()
        .stream()
        .map(playerMapper::mapFromPlayerEntityToPlayerDto).toList();
  }

  public PlayerDto getPlayerByDni(String dni) {
    Optional<Player> optionalPlayer = playerRepository.findByDni(dni);
    if (optionalPlayer.isPresent()) {
      Player playerEntity = playerRepository.findByDni(dni)
          .orElseThrow();
      return playerMapper.mapFromPlayerEntityToPlayerDto(playerEntity);
    }
    throw new PlayerNotFoundException(String.format("Student with dni %s not found", dni));
  }
}
