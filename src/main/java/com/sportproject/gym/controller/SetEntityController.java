package com.sportproject.gym.controller;

import com.sportproject.gym.DTO.SetEntityDTO;
import com.sportproject.gym.entity.Person;
import com.sportproject.gym.entity.SetEntity;
import com.sportproject.gym.service.PersonService;
import com.sportproject.gym.service.SetEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Alex on 27.05.2020.
 */
@RestController
@RequestMapping(value = "/set", produces = MediaType.APPLICATION_JSON_VALUE)
public class SetEntityController {

    private SetEntityService service;

    @Autowired
    public SetEntityController(SetEntityService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<SetEntityDTO>> getAll() {
        List<SetEntityDTO> setEntitys = service.getAll();
        return ResponseEntity.ok(setEntitys);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SetEntityDTO> get(@PathVariable long id) {
        SetEntityDTO setEntity = service.get(id);
        return ResponseEntity.ok(setEntity);
    }

    @PostMapping()
    public ResponseEntity<SetEntityDTO> create(@RequestBody SetEntity setEntity) {
        SetEntityDTO newSetEntity = service.create(setEntity);
        return ResponseEntity.ok(newSetEntity);
    }

    @PutMapping()
    public ResponseEntity<SetEntityDTO> update(@RequestBody SetEntity setEntity) {
        SetEntityDTO returnSetEntity = service.update(setEntity);
        return ResponseEntity.ok(returnSetEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }


}
