package com.example.guanli.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AdminLoginInterceptor  implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object o) throws IOException {
        String uri=request.getRequestURI();
        if (null==request.getSession().getAttribute("loginUser")){
            request.getSession().setAttribute("errorMsg","请登录");
            String url = "/admin/login";
            System.out.println("拦截成功1");
            response.sendRedirect(url);
            return false;
        }else {
            request.getSession().removeAttribute("errorMsg");
            return true;
        }
    }
}
