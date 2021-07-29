package com.example.zuulservice.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Component
public class ZuulLoggingFilter extends ZuulFilter {


    @Override
    public Object run() throws ZuulException {
        log.info("*************** printing logs: ");

        RequestContext ctx = RequestContext.getCurrentContext();
        //요청정보
        HttpServletRequest request = ctx.getRequest();
        log.info("*************** " + request.getRequestURI());
        return null;
    }

    @Override
    public String filterType() { //사전필터? 사후필터? 결정
        return "pre";
    }

    @Override
    public int filterOrder() { //여러개의 필터있을경우 순서
        return 1;
    }

    @Override
    public boolean shouldFilter() { //필터로 사용 true
        return true;
    }

}
