package com.example.ComprehensiveDesignProject.dto;

import com.example.ComprehensiveDesignProject.entity.Log;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
public class LogDTO {
    private String dialect;
    private String region;
    private String result;
    private LocalDateTime startTime;
    private LocalDateTime closeTime;

    public LogDTO(String dialect, String region, String result, LocalDateTime startTime, LocalDateTime closeTime) {
        this.dialect = dialect;
        this.region = region;
        this.result = result;
        this.startTime = startTime;
        this.closeTime = closeTime;
    }

    public Log toEntity(){
    return new Log(null, dialect, region, result, startTime, closeTime);
    }
}
