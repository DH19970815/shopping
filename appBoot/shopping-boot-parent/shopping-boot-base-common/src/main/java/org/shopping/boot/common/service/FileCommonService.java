package org.shopping.boot.common.service;

import org.shopping.boot.common.api.vo.Result;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileCommonService {
    Result uploadFile(MultipartFile file) throws IOException;
}
