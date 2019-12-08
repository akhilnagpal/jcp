package algos.memoryleak.unclosedConnections;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import org.junit.Test;

// https://stackify.com/memory-leaks-java/


/*
 * Technically, an unclosed connection will result in two types of leaks – a low-level resource leak
 * and memory leak.
 * 
 * The low-level resource leak is simply the leak of an OS-level resource – such as open
 * connections, etc. These resources can also leak, just like memory does.
 * 
 * Of course, the JVM uses memory to keep track of these underlying resources as well, which is why
 * this also results in a memory leak.
 */

public class UnclosedConnectionMemoryLeak {

  @Test(expected = OutOfMemoryError.class)
  public void test() throws IOException {
    URL url = new URL("ftp://speedtest.tele2.net");
    URLConnection conn = url.openConnection();

    InputStream stream = conn.getInputStream();

    String str;

    while (true) {

    }

    // Stream/Connections never got closed.
  }
}
