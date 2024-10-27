package com.example.demo.player.service;

import com.example.demo.player.dto.PlayerDto;
import com.example.demo.player.entity.Player;
import com.example.demo.player.mapper.PlayerMapper;
import com.example.demo.player.repository.PlayerRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerEditService {

  private final PlayerRepository playerRepository;
  private final PlayerMapper playerMapper;

  @Transactional
  public void createOrUpdatePlayer(PlayerDto playerDto) {
    Player playerEntity;

    Optional<Player> optionalPlayer = playerRepository.findByDni(playerDto.getDni());
    // we have to check whether the team exists
    playerEntity = playerMapper.mapFromPlayerDtoToPlayerEntity(playerDto);
    optionalPlayer.ifPresent(player -> playerEntity.setId(player.getId()));

    playerRepository.save(playerEntity);
  }

  @Transactional
  public void deletePlayer(String dni) {
    playerRepository.deleteByDni(dni);
  }
}
