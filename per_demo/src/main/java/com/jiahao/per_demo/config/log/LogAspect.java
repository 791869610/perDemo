package com.jiahao.per_demo.config.log;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
@Order(1)// 有多个日志时，ORDER可以定义切面的执行顺序（数字越大，前置越后执行，后置越前执行）
@Slf4j
public class LogAspect {
    /**
     * 线程副本类去记录各个线程的开始时间
     */
    ThreadLocal<Long> startTime = new ThreadLocal<>();

    /**
     * 定义切入点
     * 1、execution 表达式主体
     * 2、第1个* 表示返回值类型  *表示所有类型
     * 3、包名  com.*.*.controller下
     * 4、第4个* 类名，com.*.*.controller包下所有类
     * 5、第5个* 方法名，com.*.*.controller包下所有类所有方法
     * 6、(..) 表示方法参数，..表示任何参数
     *
     * @author: jiahao
     * @date: 2021/2/4 15:19
     * @return: void
     */
    //com.jiahao.per_demo.core.controller
    @Pointcut("execution(public * com.jiahao.*.core.controller.*.*(..))")
    public void weblog() {

    }

    /**
     * 方法里面注入连接点
     *
     * @param joinPoint:
     * @author: jiahao
     * @date: 2021/2/4 15:22
     * @return: void
     */
    @Before("weblog()")
    public void dobefore(JoinPoint joinPoint) {
        //info ,debug ,warn ,erro四种级别，这里我们注入info级别
        log.info("|【开始调用】========================================：");
        startTime.set(System.currentTimeMillis());

        //获取servlet请求对象---因为这不是控制器，这里不能注入HttpServletRequest，但springMVC本身提供ServletRequestAttributes可以拿到
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 想那个url发的请求
        log.info("|【URL】:" + request.getRequestURL().toString());
        log.info("|【METHOD】:" + request.getMethod());
        // 请求的是哪个类，哪种方法
        log.info("|【CLASS_METHOD】:" + joinPoint.getSignature().getDeclaringTypeName() + "."
            + joinPoint.getSignature().getName());
        // 方法本传了哪些参数
        log.info("|【ARGS】:" + Arrays.toString(joinPoint.getArgs()));
    }

    /**
     * 方法的返回值注入给ret
     *
     * @param ret:
     * @author: jiahao
     * @date: 2021/2/4 15:21
     * @return: void
     */
    @AfterReturning(returning = "ret", pointcut = "weblog()")
    public void doafter(Object ret) {
        // 响应的内容---方法的返回值responseEntity
        log.info("|【RESPONSE】:" + ret);
        log.info("|【SPEND】:{}ms", (System.currentTimeMillis() - startTime.get()));
        log.info("|【结束调用】========================================：");
    }
}
