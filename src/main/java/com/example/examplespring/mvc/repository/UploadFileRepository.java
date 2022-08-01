package com.example.examplespring.mvc.repository;

import com.example.examplespring.mvc.parameter.UploadFileParameter;
import org.springframework.stereotype.Repository;

/**
 * 업로드 파일 Repository
 */
@Repository
public interface UploadFileRepository {

    void save(UploadFileParameter parameter);

}
