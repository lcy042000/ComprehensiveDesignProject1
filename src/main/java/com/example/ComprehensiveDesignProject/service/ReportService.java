package com.example.ComprehensiveDesignProject.service;

import com.example.ComprehensiveDesignProject.dto.ReportDTO;
import com.example.ComprehensiveDesignProject.entity.Log;
import com.example.ComprehensiveDesignProject.entity.Report;
import com.example.ComprehensiveDesignProject.repository.LogRepository;
import com.example.ComprehensiveDesignProject.repository.ReportRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
public class ReportService {
    @Autowired
    private LogRepository logRepository;
    @Autowired
    private ReportRepository reportRepository;

    @Transactional
    public ReportDTO create(Long logId, ReportDTO dto){
        Report report = dto.toEntity();

        Log log = logRepository.findById(logId).orElse(null);
        report.setLog(log);

        Report saved = reportRepository.save(report);

        return ReportDTO.createReportDTO(saved);
    }

    @Transactional
    public Report update(Long id, ReportDTO dto){
        Report report = dto.toEntity();

        // 못찾은 경우 에러 처리 필요
        Report target = reportRepository.findById(id).orElse(null);

        target.patch(dto);

        Report updated = reportRepository.save(target);

        return updated;
    }
}
