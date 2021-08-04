package com.botscrew.university.service;

import com.botscrew.university.entity.Lector;
import com.botscrew.university.repository.LectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectorService {

    private final LectorRepository lectorRepository;

    @Autowired
    public LectorService(LectorRepository lectorRepository) {
        this.lectorRepository = lectorRepository;
    }

    public List<Lector> searchByTemplate(String template) {
        return lectorRepository.findByLectorFullNameContaining(template);
    }
}
