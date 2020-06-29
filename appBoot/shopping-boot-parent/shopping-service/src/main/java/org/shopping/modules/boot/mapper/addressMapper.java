package org.shopping.modules.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.shopping.modules.boot.entity.address;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface addressMapper extends BaseMapper<address> {
	
	address getByIdF( Integer id);
}
