package com.example.examplespring.mvc.service;

import com.example.examplespring.mvc.parameter.UploadFileParameter;
import com.example.examplespring.mvc.repository.UploadFileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 업로드 파일 서비스
 */
@Service
@RequiredArgsConstructor
public class UploadFileService {

    private final UploadFileRepository repository;

    /**
     * 등록 처리.
     * @param parameter
     */
    public void save(UploadFileParameter parameter) {
        repository.save(parameter);
    }
}
