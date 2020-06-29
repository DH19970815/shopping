package org.shopping.modules.boot.service.impl;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Test;
import org.shopping.modules.boot.entity.address;
import org.shopping.modules.boot.mapper.addressMapper;
import org.shopping.modules.boot.service.addressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.io.IOException;

@Service
public class addressServiceImpl extends ServiceImpl<addressMapper, address> implements addressService {

    @Autowired
    private addressService addressService;
    @Autowired
    private addressMapper mapper;

    @Override
    @Transactional
    public address searchAddress() {
        address address = null;
        address = mapper.getByIdF(1);
//        address.setName("yangbai1");
        address.setName("yangbai2");
        try {
//            address = mapper.getByIdF(1);
//            address.setName("yangbai1");
//            addressService.updateById(address);
//            address.setName("yangbai2");
            addressService.updateAddress(address);
//            int a = 1/0;
        }catch (Exception e){
        	e.printStackTrace();
            System.out.println("search");
//            throw new RuntimeException();
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return address;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Boolean updateAddress(address address) {
//        Boolean ok = false;
//        try {
        mapper.updateById(address);
        throw new RuntimeException();
//        }catch (Exception e){
//            System.out.println("update");
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//            return false;

//        }
//        return ok;
    }

	@Override
	public address getById(Integer id) {
		// TODO Auto-generated method stub
        int i = 1/0;
		return mapper.getByIdF(id);
	}

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addRequired(address address) {
        mapper.insert(address);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addRequiredException(address address) {
        Integer ok = mapper.insert(address);
        throw new RuntimeException();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addRequiredExceptionP(address address) {
        try {
            mapper.insert(address);
            throw new RuntimeException();
        }catch(Exception e){
            System.out.println("asd");

        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void tx() {
        address address = new address();
        address.setId(3);
        address.setUserId(3);
        address.setName("张三");
        addressService.addRequired(address);
//
//        address entity = new address();
//        address.setId(4);
//        entity.setUserId(4);
//        entity.setName("李四");
//        addressService.addRequiredException(entity);

        address address2 = new address();
        address2.setId(5);
        address2.setUserId(5);
        address2.setName("王五");
        addressService.addRequiredExceptionP(address2);

//        address address = new address();
//        address.setId(3);
//        address.setUserId(3);
//        address.setName("张三");
//        addressService.addRequired(address);
//
//        address entity = new address();
//        address.setId(4);
//        entity.setUserId(4);
//        entity.setName("李四");
//        try {
//            addressService.addRequiredException(entity);
//        }catch (Exception e){
//
//        }
    }
}
