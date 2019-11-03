package jcp.chapter2;

import java.io.IOException;
import java.math.BigInteger;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import net.jcip.annotations.GuardedBy;

// Only adding syncronized where ever we are directly accessing the state variables
// Heavy use of local variables.
// Long running process , factor(i), outside of syncronized block.
// Synch polci is to use CachedFactorizer object intrinisic lock
public class CachedFactorizer implements Servlet {
  @GuardedBy("this")
  BigInteger lastNumber;
  @GuardedBy("this")
  BigInteger[] lastFactors;
  @GuardedBy("this")
  long hits;
  @GuardedBy("this")
  long cacheHits;



  public synchronized long getHits() {
    return hits;
  }

  public synchronized double getCacheHitsRatio() {
    return Double.valueOf(cacheHits) / Double.valueOf(hits);
  }

  @Override
  public void service(ServletRequest req, ServletResponse resp) throws ServletException,
      IOException {
    BigInteger i = extractFromRequest(req);
    BigInteger[] factors = null;
    synchronized (this) {
      ++hits;
      if (lastNumber.equals(i)) {
        ++cacheHits;
        factors = lastFactors.clone();
      }
    }
    if (factors == null) {
      // long running process like factor is now outside of synchronized block
      factors = factor(i);
      synchronized (this) {
        lastNumber = i;
        lastFactors = factors;
      }
    }

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
