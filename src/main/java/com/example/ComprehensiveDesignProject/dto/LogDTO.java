package com.example.ComprehensiveDesignProject.dto;

import com.example.ComprehensiveDesignProject.entity.Log;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LogDTO {
    private Long id;
    private String dialect; //사투리 입력
    private String region; //지역
    private String result; //결과
    private LocalDateTime startTime; //시작 시간
    private LocalDateTime closeTime; //종료 시간

    public LogDTO(String dialect, String region, String result, LocalDateTime startTime, LocalDateTime closeTime) {
        this.dialect = dialect;
        this.region = region;
        this.result = result;
        this.startTime = startTime;
        this.closeTime = closeTime;
    }

    public LogDTO createLogDTO(Log log){
        return new LogDTO(log.getId(), log.getDialect(), log.getRegion(), log.getResult(), log.getStartTime(), log.getCloseTime());
    }

    public Log toEntity(){
    return new Log(null, dialect, region, result, startTime, closeTime);
    }
}
