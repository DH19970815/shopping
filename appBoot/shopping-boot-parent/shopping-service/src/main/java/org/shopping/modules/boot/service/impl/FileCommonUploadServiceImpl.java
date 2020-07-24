package org.shopping.modules.boot.service.impl;

import org.shopping.boot.common.entity.fileCommon;
import org.shopping.boot.common.service.FileCommonService;
import org.shopping.modules.boot.mapper.fileCommonUploadMapper;
import org.shopping.modules.boot.service.FileCommonUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
public class FileCommonUploadServiceImpl implements FileCommonUploadService {

    @Autowired
    private fileCommonUploadMapper mapper;
    @Autowired
    private FileCommonService service;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Integer uploadFileBase(MultipartFile file) {
        Integer ok = null;
        try{
            String name = file.getOriginalFilename();
            String path = "E:\\微信小程序\\boot\\appBoot\\shopping-boot-parent\\upload\\" +file.getOriginalFilename();
            String type = file.getContentType();
            String id = UUID.randomUUID().toString();
            fileCommon entity = new fileCommon();
            entity.setId(id);
            entity.setPath(path);
            entity.setName(name);
            entity.setType(type);
            entity.setDelFlag('0');
            ok = mapper.uploadFileBase(entity);
            service.uploadFile(file);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ok;
    }
}
