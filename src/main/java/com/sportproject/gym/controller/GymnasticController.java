package com.sportproject.gym.controller;

import com.sportproject.gym.entity.Gymnastic;
import com.sportproject.gym.service.GymnasticService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<List<Gymnastic>> getGymnastics() {
        List<Gymnastic> gymnastics = service.getAll();
        return ResponseEntity.ok(gymnastics);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Gymnastic> getGymnasticById(@PathVariable Long id) {
        Gymnastic gymnastic = service.getById(id);
        return ResponseEntity.ok(gymnastic);
    }

    @GetMapping(value = "/type")
    @ResponseBody
    public ResponseEntity<Gymnastic> getGymnasticByName(@RequestParam String name) {
        Gymnastic gymnastic = service.getByName(name);
        return ResponseEntity.ok(gymnastic);
    }
}
