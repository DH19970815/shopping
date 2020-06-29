package org.shopping.modules.boot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@TableName("tb_address")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class address {
	@TableId(type = IdType.UUID)
    private Integer id;

    private Integer userId;

    private String name;

    private String state;

    private String city;

    private String district;

    private String address;

    private String phone;

    private String email;

    private String addressAlias;

    private Integer defaultAddress;
}
