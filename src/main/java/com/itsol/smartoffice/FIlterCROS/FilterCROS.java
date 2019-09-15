package com.itsol.smartoffice.FIlterCROS;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@Component
public class FilterCROS implements Filter {
    private static final Logger LOGGER = LoggerFactory.getLogger(FilterCROS.class);
    public void destroy() {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        System.out.println("CORSFilter HTTP Requests: " + request.getMethod());

        // Authorize (allow) all domains to consume the content
        ((HttpServletResponse) resp).addHeader("Access-Control-Allow-Origin", "*");
        ((HttpServletResponse) resp).addHeader("Access-Control-Allow-Methods","GET, OPTIONS, HEAD, PUT, POST, DELETE");
        ((HttpServletResponse) resp).addHeader("Access-Control-Allow-Headers","X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
        ((HttpServletResponse) resp).addHeader("Access-Control-Max-Age","1728000");

        HttpServletResponse response = (HttpServletResponse) resp;

        // For HTTP OPTIONS verb/method reply with ACCEPTED status code -- per CORS handshake
        if (request.getMethod().equals("OPTIONS")) {
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
            return;
        }

        // pass the request along the filter chain
        chain.doFilter(request, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        LOGGER.info("Initializing CROSFilter");
    }

}
