package com.example.ComprehensiveDesignProject.api;

import com.example.ComprehensiveDesignProject.dto.ReportDTO;
import com.example.ComprehensiveDesignProject.entity.Report;
import com.example.ComprehensiveDesignProject.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ReportController {
    @Autowired
    private ReportService reportService;

    // POST
    @PostMapping("/report/{logId}")
    public ResponseEntity<ReportDTO> create(@PathVariable Long logId, @RequestBody ReportDTO dto){
        ReportDTO report = reportService.create(logId, dto);

        return ResponseEntity.status(HttpStatus.OK).body(report);
    }
}
