package org.shopping.modules.boot.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.shopping.modules.boot.entity.address;

public interface logAopService {
//    public void around(ProceedingJoinPoint joinPoint) throws Throwable;

    public void before();

    public address afterReturn(JoinPoint joinPoint, address result);

    public void exception(JoinPoint joinPoint, Exception e);

    public void after(JoinPoint joinPoint);
}
