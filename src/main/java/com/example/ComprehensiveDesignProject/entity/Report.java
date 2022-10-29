package com.example.ComprehensiveDesignProject.entity;

import com.example.ComprehensiveDesignProject.dto.ReportDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Log log;
    @Column(nullable = false)
    private String revisedResult;
    @Column(nullable = false)
    private String reason;

    public void patch(ReportDTO dto){
        if(this.id != dto.getId()){
            // 에러 처리 필요
        }

        if(dto.getRevisedResult() != null){
            this.revisedResult = dto.getRevisedResult();
        }

        if(dto.getReason() != null){
            this.reason = dto.getReason();
        }
    }
}
