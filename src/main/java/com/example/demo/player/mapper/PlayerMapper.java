package com.example.demo.player.mapper;

import com.example.demo.player.dto.PlayerDto;
import com.example.demo.player.entity.Player;
import org.springframework.stereotype.Component;

@Component
public class PlayerMapper {

  public Player mapFromPlayerDtoToPlayerEntity(PlayerDto playerDto) {

    java.sql.Date sqlDate = new java.sql.Date(playerDto.getBirthDate().getTime());
    return
        Player.builder()
            .birthDate(sqlDate)
            .block(playerDto.getBlock())
            .firstName(playerDto.getFirstName())
            .gender(playerDto.getGender())
            .height(playerDto.getHeight())
            .lastName(playerDto.getLastName())
            .spike(playerDto.getSpike())
            .teamId(1)
            .weight(playerDto.getWeight())
            .dni(playerDto.getDni())
            .build();
  }

  public PlayerDto mapFromPlayerEntityToPlayerDto(Player player) {
    return PlayerDto.builder()
        .birthDate(player.getBirthDate())
        .block(player.getBlock())
        .firstName(player.getFirstName())
        .gender(player.getGender())
        .height(player.getHeight())
        .lastName(player.getLastName())
        .spike(player.getSpike())
        .teamName("In progress...")
        .weight(player.getWeight())
        .dni(player.getDni())
        .build();
  }
}
