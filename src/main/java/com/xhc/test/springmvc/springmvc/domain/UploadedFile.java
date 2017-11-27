package com.xhc.test.springmvc.springmvc.domain;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class UploadedFile implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -7282180624848576908L;

    private MultipartFile multipartFile;

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }
    

    
    
}
