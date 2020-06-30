package com.sportproject.gym.controller;

import com.sportproject.gym.DTO.VisitDTO;
import com.sportproject.gym.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Egor on 08.06.2020.
 */
@RestController
@RequestMapping(value = "/visit", produces = MediaType.APPLICATION_JSON_VALUE)
public class VisitController {

    private VisitService service;

    @Autowired
    public VisitController(VisitService service) {
        this.service = service;
    }


    @GetMapping()
    public ResponseEntity<List<VisitDTO>> getAll() {
        List<VisitDTO> visits = service.getAll();
        return ResponseEntity.ok(visits);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VisitDTO> get(@PathVariable long id){
        VisitDTO visit = service.get(id);
        return ResponseEntity.ok(visit);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<VisitDTO> create(@RequestBody VisitDTO visitDTO) {
        VisitDTO newVisit = service.create(visitDTO);
        return ResponseEntity.ok(newVisit);
    }

    @PutMapping
    public ResponseEntity<VisitDTO> update(@RequestBody VisitDTO visitDTO) {
        VisitDTO returnVisit = service.update(visitDTO);
        return ResponseEntity.ok(returnVisit);
    }
}
