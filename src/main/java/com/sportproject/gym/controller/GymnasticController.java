package com.sportproject.gym.controller;

import com.sportproject.gym.DTO.GymnasticDTO;
import com.sportproject.gym.DTO.SetEntityDTO;
import com.sportproject.gym.entity.Gymnastic;
import com.sportproject.gym.service.GymnasticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Alex on 14.05.2020.
 */
@RestController
@RequestMapping(value = "/gymnastic", produces = MediaType.APPLICATION_JSON_VALUE)
public class GymnasticController {
    private GymnasticService service;

    @Autowired
    public GymnasticController(GymnasticService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<GymnasticDTO>> getGymnastics() {
        List<GymnasticDTO> gymnastics = service.getAll();
        return ResponseEntity.ok(gymnastics);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<GymnasticDTO> getGymnasticById(@PathVariable long id) {
        GymnasticDTO gymnastic = service.get(id);
        return ResponseEntity.ok(gymnastic);
    }

    @PostMapping()
    public ResponseEntity<GymnasticDTO> create(@RequestBody GymnasticDTO gymnastic) {
        GymnasticDTO newSetEntity = service.create(gymnastic);
        return ResponseEntity.ok(newSetEntity);
    }

    @PutMapping()
    public ResponseEntity<GymnasticDTO> update(@RequestBody GymnasticDTO gymnastic) {
        GymnasticDTO returnSetEntity = service.update(gymnastic);
        return ResponseEntity.ok(returnSetEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }
}
