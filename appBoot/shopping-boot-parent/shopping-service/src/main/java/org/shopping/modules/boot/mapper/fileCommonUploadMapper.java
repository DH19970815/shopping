package org.shopping.modules.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.shopping.boot.common.entity.fileCommon;

@Mapper
public interface fileCommonUploadMapper extends BaseMapper<fileCommon> {
    Integer uploadFileBase(@Param("file") fileCommon fileCommon);
}
