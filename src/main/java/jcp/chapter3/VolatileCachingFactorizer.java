package jcp.chapter3;

import java.io.IOException;
import java.math.BigInteger;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class VolatileCachingFactorizer implements Servlet {
  // One value cache is immutable and will maintain the invariant.
  // By volatile, threads will not partially constructed OneValueCache
  private volatile OneValueCache cache = new OneValueCache(null, null);

  @Override
  public void service(ServletRequest req, ServletResponse resp) throws ServletException,
      IOException {
    BigInteger i = extractFromRequest(req);
    // Reader thread will wait for cache to be re-constructed, if already thread is initialising One
    // Value Cache at line 24
    BigInteger[] factors = cache.getLastFactors(i);
    if (factors == null) {
      factors = factor(i);
      // Since cache reference is volatile, other threads will not see partially constructed
      // One value Cache.
      cache = new OneValueCache(i, factors);
    }
    encodeIntoResponse(resp, factors);
  }

  private BigInteger[] factor(BigInteger i) {
    return null;
  }

  private void encodeIntoResponse(ServletResponse resp, BigInteger[] factors) {
    // TODO Auto-generated method stub

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
