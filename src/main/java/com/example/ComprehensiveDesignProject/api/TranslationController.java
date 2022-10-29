package com.example.ComprehensiveDesignProject.api;

import com.example.ComprehensiveDesignProject.dto.LogDTO;
import com.example.ComprehensiveDesignProject.dto.TranslationDTO;
import com.example.ComprehensiveDesignProject.entity.Log;
import com.example.ComprehensiveDesignProject.service.LogService;
import com.example.ComprehensiveDesignProject.service.TranslationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TranslationController {
    @Autowired
    private TranslationService translationService;
    @Autowired
    private LogService logService;

    //POST
    @PostMapping("/translation")
    public ResponseEntity<LogDTO> translation(@RequestBody TranslationDTO dto){
        // 서비스 호출
        LogDTO translated = translationService.translate(dto);

        Log saved = logService.create(translated.toEntity());

        LogDTO result = new LogDTO().createLogDTO(saved);

        // 반환
        return (translated != null) ?
                ResponseEntity.status(HttpStatus.OK).body(result) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
