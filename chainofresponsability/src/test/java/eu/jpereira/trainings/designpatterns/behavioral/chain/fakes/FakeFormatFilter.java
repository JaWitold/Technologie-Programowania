package eu.jpereira.trainings.designpatterns.behavioral.chain.fakes;

import javax.servlet.*;
import java.io.IOException;

public class FakeFormatFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);
        servletResponse.getOutputStream().print(" :Formatted");
    }

    @Override
    public void destroy() {

    }
}
