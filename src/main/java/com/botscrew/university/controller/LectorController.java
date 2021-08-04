package com.botscrew.university.controller;

import com.botscrew.university.entity.Department;
import com.botscrew.university.entity.Lector;
import com.botscrew.university.repository.LectorRepository;
import com.botscrew.university.service.LectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LectorController {

    private final LectorService lectorService;
    private final LectorRepository lectorRepository;

    @Autowired
    public LectorController(LectorService lectorService,
                            LectorRepository lectorRepository) {
        this.lectorService = lectorService;
        this.lectorRepository = lectorRepository;
    }

    @GetMapping("/lectors")
    public List<Lector> getLectors(){
        return lectorRepository.findAll();
    }

    @GetMapping("/lector/{id}")
    public Lector getLector(@PathVariable Long id){
        return lectorRepository.getById(id);
    }

    @PostMapping("/lector")
    public void addLector(@RequestBody Lector lector){
        lectorRepository.save(lector);
    }

    @PatchMapping("/lector")
    public void editLector(@RequestBody Lector lector){
        lectorRepository.save(lector);
    }

    @DeleteMapping("/lector/{id}")
    public void deleteLector(@PathVariable Long id){
        lectorRepository.deleteById(id);
    }

    @GetMapping("/lector/template/{template}")
    public List<Lector> searchByTemplate(@PathVariable String template){
        return lectorService.searchByTemplate(template);
    }
}
