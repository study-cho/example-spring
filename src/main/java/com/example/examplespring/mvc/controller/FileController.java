package com.example.examplespring.mvc.controller;

import com.example.examplespring.configuration.GlobalConfig;
import com.example.examplespring.configuration.exception.BaseException;
import com.example.examplespring.configuration.http.BaseResponse;
import com.example.examplespring.configuration.http.BaseResponseCode;
import com.example.examplespring.mvc.parameter.UploadFileParameter;
import com.example.examplespring.mvc.service.UploadFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/file")
@Api(tags = "파일 API")
public class FileController {

    Logger logger = LoggerFactory.getLogger(getClass());

    private final GlobalConfig config;
    private final UploadFileService uploadFileService;

    /**
     * 업로드 리턴
     * @return
     */
    @PostMapping("/save")
    @ApiOperation(value = "업로드")
    public BaseResponse<Boolean> save(@RequestParam("uploadFile")MultipartFile multipartFile) {
        logger.debug("config : {}", config);

        if (multipartFile == null || multipartFile.isEmpty())
           throw new BaseException(BaseResponseCode.DATA_IS_NULL);

        //날짜폴더 추가
        String currentDate = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
        String uploadFilePath = config.getUploadFilePath() + currentDate + "/";
        logger.debug("uploadFilePath : {}", uploadFilePath);
        String originalFilename = multipartFile.getOriginalFilename();
        String prefix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1, originalFilename.length());
        String filename = UUID.randomUUID().toString() + "." + prefix;
        logger.info("filename : {}", filename);

        File folder = new File(uploadFilePath);
        // 폴더가 없다면 생성
        if (!folder.isDirectory())
            folder.mkdirs();

        String pathname = uploadFilePath + filename;
        String resourcePathname = config.getUploadResourcePath() + currentDate + "/" + filename;
        File dest = new File(pathname);
        logger.debug("dest : {}", dest);
        try {
            multipartFile.transferTo(dest);
            //파일업로드된 후 DB에 저장
            UploadFileParameter parameter = new UploadFileParameter();
            //컨텐츠 종류
            parameter.setContentType(multipartFile.getContentType());
            //원본파일명
            parameter.setOriginalFilename(originalFilename);
            //저장파일명
            parameter.setFilename(filename);
            //실제파일 저장경로
            parameter.setPathname(pathname);
            //파일크기
            parameter.setSize((int) multipartFile.getSize());
            //static resource 접근 경로
            parameter.setResourcePathname(resourcePathname);

            uploadFileService.save(parameter);
        } catch (IOException e) {
            logger.error("e", e);
        }
        return new BaseResponse<>(true);
    }
}
