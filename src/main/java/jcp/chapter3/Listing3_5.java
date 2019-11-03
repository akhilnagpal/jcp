package jcp.chapter3;

import java.util.HashSet;
import java.util.Set;

public class Listing3_5 {
  // Escaping the knownSecrets object reference, any class or thread can access and manipulate the
  // so- called
  // internal state
  public static Set<String> knownSecrets;

  public void initialize() {
    knownSecrets = new HashSet<String>();
  }

}
