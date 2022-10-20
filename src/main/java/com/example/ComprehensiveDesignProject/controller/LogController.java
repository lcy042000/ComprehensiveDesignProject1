package com.example.ComprehensiveDesignProject.controller;

import com.example.ComprehensiveDesignProject.dto.LogDTO;
import com.example.ComprehensiveDesignProject.entity.Log;
import com.example.ComprehensiveDesignProject.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LogController {
    @Autowired
    private LogRepository logRepository;

    @PostMapping("/log/create")
    public String createLog(LogDTO logDTO){
        Log log = logDTO.toEntity();

        Log savedLog = logRepository.save(log);

        return "";
    }
}
