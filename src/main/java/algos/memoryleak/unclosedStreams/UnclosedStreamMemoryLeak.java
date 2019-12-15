package algos.memoryleak.unclosedStreams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import org.junit.Test;

public class UnclosedStreamMemoryLeak {

  /*
   * Technically, an unclosed stream will result in two types of leaks – a low-level resource leak
   * and memory leak.
   * 
   * The low-level resource leak is simply the leak of an OS-level resource – such as file
   * descriptors, open connections, etc. These resources can also leak, just like memory does.
   * 
   * Of course, the JVM uses memory to keep track of these underlying resources as well, which is
   * why this also results in a memory leak.
   */

  @Test(expected = OutOfMemoryError.class)
  public void givenURL_whenUnclosedStream_thenOutOfMemory() throws IOException, URISyntaxException {
    String str = "";
    URLConnection conn = new URL("http://norvig.com/big.txt").openConnection();
    BufferedReader br =
        new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));

    while (br.readLine() != null) {
      str += br.readLine();
    }

    //
  }

}
