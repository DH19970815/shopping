package org.shopping.modules.boot.service.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.shopping.modules.boot.entity.address;
import org.shopping.modules.boot.service.logAopService;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class logAopServiceImpl implements logAopService {

    @Pointcut("execution(public * org.shopping.modules.boot.service.addressService.getById(..))")
    public void pointCut(){};

    //前置通知

    @Before("pointCut()")
    @Override
    public void before() {
        try {
            System.out.println("前置通知");
        }catch (Exception e){

        }
    }

    @AfterReturning(pointcut = "pointCut()", returning = "result")
    @Override
    public address afterReturn(JoinPoint joinPoint, address result) {
        try {
            System.out.println("后置通知");
        }catch (Exception e){

        }
        return result;
    }

    @AfterThrowing(pointcut = "pointCut()", throwing = "e")
    @Override
    public void exception(JoinPoint joinPoint, Exception e) {
        try {
            System.out.println("异常通知"+e);
        }catch (Exception ex){
            System.out.println("catch--------------------");
            ex.printStackTrace();
        }
    }

    @After("pointCut()")
    @Override
    public void after(JoinPoint joinPoint) {
        System.out.println("后置通知无返回结果");
    }


    //环绕通知
//    @Override
//    @Around("pointCut()")
//    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
//        try {
//            System.out.println("环绕通知前");
//            Object result =  joinPoint.proceed();
//       System.out.println(result);
//            System.out.println("环绕通知后");
//        }catch (Exception e){
//            e.printStackTrace();
//
//        }
//        System.out.println("环绕通知前");
//        Object result =  joinPoint.proceed();
//      System.out.println(result);
//       System.out.println("环绕通知后");
//
//    }

}
