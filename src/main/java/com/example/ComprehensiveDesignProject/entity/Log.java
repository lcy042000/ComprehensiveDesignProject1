package com.example.ComprehensiveDesignProject.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
public class Log {
    @Id @GeneratedValue
    private Long id;

    @Column
    private String dialect;
    @Column
    private String region;
    @Column
    private String result;
    @Column
    private LocalDateTime startTime;
    @Column
    private LocalDateTime closeTime;

    public Log(Long id, String dialect, String region, String result, LocalDateTime startTime, LocalDateTime closeTime) {
        this.id = id;
        this.dialect = dialect;
        this.region = region;
        this.result = result;
        this.startTime = startTime;
        this.closeTime = closeTime;
    }
}
