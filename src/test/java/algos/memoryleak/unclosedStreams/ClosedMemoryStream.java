package algos.memoryleak.unclosedStreams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class ClosedMemoryStream {

  @SuppressWarnings("unused")
public ClosedMemoryStream() throws MalformedURLException, IOException {
    String str = "";
    URLConnection conn = new URL("http://norvig.com/big.txt").openConnection();
    // Added Stream inside the try (). The Implementing class needs to implement auto-implementable
    // The auto-close feature has been implemented in Java 8.
    try (BufferedReader br =
        new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
      try {
        while (br.readLine() != null) {
          str += br.readLine();
        }
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }



  }

}
