package jcp.chapter2;

import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class UnSafeCachingOptimizer implements Servlet {

  AtomicReference<BigInteger> lastNumber = new AtomicReference<>();
  AtomicReference<BigInteger[]> lastFactors = new AtomicReference<>();

  @Override
  public void service(ServletRequest req, ServletResponse resp) throws ServletException,
      IOException {
    BigInteger i = extractFromRequest(req);
    // Below two lines of line 23 and 24 should be in one atomic operation,
    // otherwise it will violate the invariant of lastFactors has to always come from lastNumber
    if (lastNumber.get().equals(i)) {
      encodeIntoResponse(resp, lastFactors.get());
    } else {
      // Below two lines (29-30) can cause race condition
      // This is violating the invariant, where factors has to come from lastNumber
      // Interleave can happen between below two lines
      lastNumber.set(i);
      lastFactors.set(factor(i));
      encodeIntoResponse(resp, lastFactors.get());
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
