package jcp.chapter2;

import java.io.IOException;
import java.math.BigInteger;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import net.jcip.annotations.NotThreadSafe;

@NotThreadSafe
public class UnSafeCountingFactorizer implements Servlet {

  private long count = 0;



  public long getCount() {
    return count;
  }

  @Override
  public void service(ServletRequest req, ServletResponse resp) throws ServletException,
      IOException {
    BigInteger i = extractFromRequest(req);
    BigInteger[] factors = factor(i);
    // Race condition happening over here, as this is not one operation
    count++;
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
