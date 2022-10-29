package com.example.ComprehensiveDesignProject.service;

import com.example.ComprehensiveDesignProject.entity.Log;
import com.example.ComprehensiveDesignProject.repository.LogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class LogService {
    @Autowired
    private LogRepository logRepository;

    @Transactional
    public Log create(Log log){
        Log saved = logRepository.save(log);

        return saved;
    }
}
