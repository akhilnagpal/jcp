package jcp.chapter2;

import java.io.IOException;
import java.math.BigInteger;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import net.jcip.annotations.GuardedBy;

// Very bad performance, as this servlet cannot be used mutiple threads.
// Thread-safe but poor concurrency.

public class SynchronizeOptimizer implements Servlet {
  @GuardedBy("this")
  BigInteger lastNumber;
  @GuardedBy("this")
  BigInteger[] lastFactors;

  @Override
  public synchronized void service(ServletRequest req, ServletResponse resp)
      throws ServletException, IOException {
    BigInteger i = extractFromRequest(req);
    if (i.equals(lastNumber)) {
      encodeIntoResponse(resp, lastFactors);
    } else {
      lastNumber = i;
      lastFactors = factor(i);
      encodeIntoResponse(resp, lastFactors);
    }
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
