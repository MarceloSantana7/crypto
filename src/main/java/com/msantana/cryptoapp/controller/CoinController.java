package com.msantana.cryptoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.Timestamp;

import com.msantana.cryptoapp.entity.Coin;
import com.msantana.cryptoapp.repository.CoinRepository;

@RestController
@RequestMapping("/coin")
public class CoinController {

  @Autowired
  private CoinRepository coinRepository;

  @GetMapping()
  public ResponseEntity get() {
    return new ResponseEntity<>(coinRepository.getAll(), HttpStatus.OK);
  }

  @PostMapping()
  public ResponseEntity post(@RequestBody Coin coin) {
    try {
      coin.setDateTime(new Timestamp(System.currentTimeMillis()));
      return new ResponseEntity<>(coinRepository.insert(coin), HttpStatus.CREATED);
    } catch (Exception error) {
      return new ResponseEntity<>(error.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
