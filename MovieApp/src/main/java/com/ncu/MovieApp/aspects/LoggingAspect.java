package com.ncu.MovieApp.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @After("execution(* com.ncu.MovieApp.services.BookingService.getBookingById(..))")
    public void logAfterBookingFetch(JoinPoint joinPoint) {
        System.out.println("@After completed: " + joinPoint.getSignature().getName());
    }

    @Before("execution(* com.ncu.MovieApp.services.BookingService.insertBooking(..))")
    public void logBeforeBookingInsert(JoinPoint joinPoint) {
        System.out.println("@Before method called: " + joinPoint.getSignature().getName());

        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println("argument: " + arg);
        }
    }
    @AfterReturning(
            pointcut = "execution(* com.ncu.MovieApp.services.BookingService.getBookingById(..))",
            returning = "result"
    )
    public void logAfterReturning(Object result) {
        if (result != null) {
            System.out.println("@AfterReturning booking fetched: " + result);
        }
    }
    @AfterThrowing(
            pointcut = "execution(* com.ncu.MovieApp.services.BookingService.deleteBookingById(..))",
            throwing = "ex"
    )

    public void logException(Throwable ex) {
        System.out.println("@AfterThrowing Exception caught: " + ex.getMessage());
    }

    @Around("execution(* com.ncu.MovieApp.controllers.*.*(..))")
    public Object trackExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed(); // proceed with the method execution

        long duration = System.currentTimeMillis() - start;
        System.out.println("@Around execution time of " +
                joinPoint.getSignature().getDeclaringType().getSimpleName() + "." +
                joinPoint.getSignature().getName() + ": " + duration + " ms");

        return result;
    }


}
