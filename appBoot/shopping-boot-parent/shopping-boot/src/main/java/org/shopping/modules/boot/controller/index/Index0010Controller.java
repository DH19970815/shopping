package org.shopping.modules.boot.controller.index;

import lombok.extern.slf4j.Slf4j;
import org.shopping.modules.boot.entity.address;
import org.shopping.modules.boot.service.addressService;
import org.shopping.modules.boot.service.logAopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.shopping.modules.boot.service.addressService;

@Slf4j
@RestController
@RequestMapping("/boot/index0010")
public class Index0010Controller {

    @Autowired
    private addressService addressService;
    @Autowired
    private org.shopping.modules.boot.service.logAopService logAopService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public void search(){
//        addressService.searchAddress();
//        addressService.tx();
        addressService.getById(1);
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public void update(){
        address address = addressService.getById(1);
        address.setName("yangyang");
        addressService.updateAddress(address);
    }


}
