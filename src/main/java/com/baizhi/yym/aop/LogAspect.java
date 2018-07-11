package com.baizhi.yym.aop;

import com.baizhi.yym.entity.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * Created by Administrator on 2018/7/9.
 */
@Configuration
@Aspect
public class LogAspect {

    @Pointcut(value = "@annotation(LogAnnotation)")
    public void pointCut() {
    }

    @Around(value = "pointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        //是谁  什么时间  干了什么事   执行结果
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpSession session = servletRequestAttributes.getRequest().getSession();
        User user = (User) session.getAttribute("user");
        Date date = new Date();
        String name = proceedingJoinPoint.getSignature().getName();

        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = methodSignature.getMethod();
        LogAnnotation annotation = method.getAnnotation(LogAnnotation.class);
        String s = annotation.name();
        boolean flag = false;
        Object proceed = null;
        try {
            proceed = proceedingJoinPoint.proceed();
            flag = true;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println(user.getName()+"在"+date+"操作的方法"+s+"执行结果是"+flag);
        return proceed;

    }

}
