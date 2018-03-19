package com.imooc.web.controller;

import com.imooc.dto.FileInfo;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/file")
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    private static final String FOLDER = "/Users/corning/IdeaProjects/imooc/security/imooc-security-demo/upload/";

    @PostMapping
    public FileInfo upload(MultipartFile file) throws IOException {
        logger.info(file.getName());
        logger.info(file.getOriginalFilename());

        String filePath = String.format("%s%s.%s", FOLDER, System.currentTimeMillis(), file.getOriginalFilename().split("[.]")[1]);

        File localFile = new File(filePath);
        file.transferTo(localFile);

        return new FileInfo(localFile.getPath());
    }

    @GetMapping("{id}")
    public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) {

        String filePath = String.format("%s%s.%s", FOLDER, id, "txt");
        File file = new File(filePath);
        logger.info(file.getAbsolutePath());

        try (InputStream inputStream = new FileInputStream(file);
             ServletOutputStream outputStream = response.getOutputStream()) {

            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition", "attachment;filename=" + file.getName());

            IOUtils.copy(inputStream, outputStream);
            outputStream.flush();

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

    }


}
