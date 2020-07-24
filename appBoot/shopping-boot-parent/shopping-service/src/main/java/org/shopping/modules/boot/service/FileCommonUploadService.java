package org.shopping.modules.boot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.shopping.boot.common.entity.fileCommon;
import org.springframework.web.multipart.MultipartFile;

public interface FileCommonUploadService {
    Integer uploadFileBase(MultipartFile file);
}
