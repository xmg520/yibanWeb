//package com.mxz.yiban.config;
//
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//import javax.servlet.http.HttpServletRequest;
//
//// @ControllerAdvice(注解定义全局异常处理类) + @ExceptionHandler(注解声明异常处理方法) 全局处理 Controller 层异常
//// 将 Controller 层的异常和数据校验的异常进行统一处理，减少模板代码，减少编码量，提升扩展性和可维护性。
//// 减少controller层报错使用try-catch
//// 此方法对Interceptor（拦截器）层的异常，Spring 框架层的异常无效
//@ControllerAdvice
//public class GlobalExceptionHandler {
//
//    // defaultErrorHandler 方法会处理 Controller 层抛出的 Exception 及其子类的异常，
//    //处理方法为跳转到 page/404.html页面
//    @ExceptionHandler({Exception.class})
//    public String defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception{
//        return "/error";
//    }
//}
