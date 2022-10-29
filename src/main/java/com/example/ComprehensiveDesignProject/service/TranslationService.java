package com.example.ComprehensiveDesignProject.service;

import com.example.ComprehensiveDesignProject.dto.LogDTO;
import com.example.ComprehensiveDesignProject.dto.TranslatedDTO;
import com.example.ComprehensiveDesignProject.dto.TranslationDTO;
import com.example.ComprehensiveDesignProject.enums.RegionType;
import com.example.ComprehensiveDesignProject.webClient.WebClientConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@Service
public class TranslationService {

    @Autowired
    WebClientConfig webClient;

    public LogDTO translate(TranslationDTO dto){
        // 시간 측정 시작
        LocalDateTime start = LocalDateTime.now();

        // 번역
        TranslatedDTO result = runTranslation(dto);

        // 시간 측정 종료
        LocalDateTime close = LocalDateTime.now();

        //반환
        LogDTO logDTO = new LogDTO(dto.getDialect(), result.getRegion(), result.getStandard_form(), start, close);

        return logDTO;
    }

    private TranslatedDTO runTranslation(TranslationDTO dto){

        TranslatedDTO translatedDTO = new TranslatedDTO();

        webClient.webClient()
                .post()
                .uri("/translate")
                .bodyValue(dto)
                .retrieve()
                .bodyToMono(TranslatedDTO.class)
                .subscribe(data -> {
                    translatedDTO.setStandard_form(data.getStandard_form());
                    translatedDTO.setRegion(data.getRegion());
                });

        return translatedDTO;
    }
}
