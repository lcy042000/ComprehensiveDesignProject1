package com.example.ComprehensiveDesignProject.dto;

import com.example.ComprehensiveDesignProject.entity.Log;
import com.example.ComprehensiveDesignProject.entity.Report;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReportDTO {
    private Long id;
    private Log log;
    private String revisedResult;
    private String reason;

    public Report toEntity(){
        return new Report(null, log, revisedResult, reason);
    }

    public static ReportDTO createReportDTO(Report report){
        return new ReportDTO(report.getId(), report.getLog(), report.getRevisedResult(), report.getReason());
    }
}
