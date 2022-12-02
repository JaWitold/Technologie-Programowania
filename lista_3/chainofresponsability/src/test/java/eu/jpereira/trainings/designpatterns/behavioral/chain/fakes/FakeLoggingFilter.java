package eu.jpereira.trainings.designpatterns.behavioral.chain.fakes;

import javax.servlet.*;
import java.io.IOException;

public class FakeLoggingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.getOutputStream().print("Logging: ");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
