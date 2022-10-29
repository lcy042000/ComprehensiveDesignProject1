package com.example.ComprehensiveDesignProject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Log {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String dialect;
    @Column(nullable = false)
    private String region;
    @Column(nullable = false)
    private String result;
    @Column(nullable = false)
    private LocalDateTime startTime;
    @Column(nullable = false)
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
