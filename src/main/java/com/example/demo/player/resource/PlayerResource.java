package com.example.demo.player.resource;

import com.example.demo.player.dto.PlayerDto;
import com.example.demo.player.service.PlayerEditService;
import com.example.demo.player.service.PlayerSearchService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("player")
@RequiredArgsConstructor
public class PlayerResource {

  private final PlayerEditService playerEditService;
  private final PlayerSearchService playerSearchService;

  @PostMapping
  public void createPlayer(@RequestBody PlayerDto player) {
    playerEditService.createOrUpdatePlayer(player);
  }

  @GetMapping()
  @ResponseBody
  public PlayerDto getPlayerByFirstnameAndLastname(
      @RequestParam(name = "firstname") String firstname,
      @RequestParam(name = "lastname") String lastname) {
    return playerSearchService.getPlayerByFirstnameAndLastname(firstname, lastname);
  }

  @GetMapping("dni/{dni}")
  @ResponseBody
  public PlayerDto getPlayerByDni(@PathVariable String dni) {
    return playerSearchService.getPlayerByDni(dni);
  }

  @PutMapping
  public void updatePlayer(@RequestBody PlayerDto player) {
    playerEditService.createOrUpdatePlayer(player);
  }

  @DeleteMapping
  public void deletePlayer(@RequestParam String dni) {
    playerEditService.deletePlayer(dni);
  }

  @GetMapping("all")
  @ResponseBody
  public List<PlayerDto> getAllPlayers() {
    return playerSearchService.getAllPlayers();
  }
}
