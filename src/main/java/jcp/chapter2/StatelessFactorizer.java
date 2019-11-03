package jcp.chapter2;

import java.io.IOException;
import java.math.BigInteger;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import net.jcip.annotations.ThreadSafe;

// 1. Stateless Servlet
// 2. State of the servlet is only in local variables and hence confine to Executing thread only.
// 3. Multiple threads so not interfere with each other, as local variables on each thread own
// stack.
// 4. To threads it seems they are accessing different instances.

@ThreadSafe
public class StatelessFactorizer implements Servlet {

  @Override
  public void service(ServletRequest req, ServletResponse resp) throws ServletException,
      IOException {
    BigInteger i = extractFromRequest(req);
    BigInteger[] factors = factor(i);
    encodeIntoResponse(resp, factors);

  }

  private void encodeIntoResponse(ServletResponse resp, BigInteger[] factors) {
    // TODO Auto-generated method stub

  }

  private BigInteger[] factor(BigInteger i) {
    // TODO Auto-generated method stub
    return null;
  }

  private BigInteger extractFromRequest(ServletRequest req) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void destroy() {
    // TODO Auto-generated method stub

  }

  @Override
  public ServletConfig getServletConfig() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getServletInfo() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void init(ServletConfig arg0) throws ServletException {
    // TODO Auto-generated method stub

  }



}
