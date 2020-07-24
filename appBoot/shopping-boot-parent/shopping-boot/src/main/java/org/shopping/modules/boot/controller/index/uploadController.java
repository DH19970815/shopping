package org.shopping.modules.boot.controller.index;

import lombok.extern.slf4j.Slf4j;

import org.shopping.boot.common.api.vo.Result;
import org.shopping.boot.common.service.FileCommonService;
import org.shopping.modules.boot.service.FileCommonUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/boot/upload")
public class uploadController {

    @Autowired
    private FileCommonService fileCommonService;
    @Autowired
    private FileCommonUploadService fileCommonUploadService;

//    @GetMapping(value = "/init")
//    public Result<String> init() {
//        Result<String> result = new Result<>();
//        result.setResult();
//        return result;
//    }

    @PostMapping(value = "/picture")
    @Transactional(propagation = Propagation.REQUIRED)
    public Result<?> uploadPicture(@RequestParam(value = "file",required = false) MultipartFile file) throws IOException {
        try {
            fileCommonUploadService.uploadFileBase(file);
//            fileCommonService.uploadFile(file);
        }catch (Exception e){
            e.printStackTrace();
        }
        Result<?> result = new Result<>();
        result.setSuccess(true);
        return result;
    }
}
