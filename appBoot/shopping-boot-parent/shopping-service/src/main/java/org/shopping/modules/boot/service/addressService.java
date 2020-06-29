package org.shopping.modules.boot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.shopping.modules.boot.entity.address;

public interface addressService extends IService<address> {

    /**查询*/
    public address searchAddress();

    public Boolean updateAddress(address address);
    
    public address getById(Integer id);

    public void addRequired(address address);

    public void addRequiredException(address address);

    public void addRequiredExceptionP(address address);

    public void tx();

}
