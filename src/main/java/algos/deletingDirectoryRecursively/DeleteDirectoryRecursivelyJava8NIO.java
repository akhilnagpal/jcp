package algos.deletingDirectoryRecursively;

import static org.junit.Assert.assertFalse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

// https://www.baeldung.com/java-delete-directory

public class DeleteDirectoryRecursivelyJava8NIO {

  private static Path TEMP_DIRECTORY;
  private static final String DIRECTORY_NAME = "toBeDeleted";
  private static final List<String> ALL_LINES = Arrays.asList("This is line 1", "This is line 2",
      "This is line 3", "This is line 4", "This is line 5", "This is line 6");

  @BeforeClass
  public static void initializeTempDirectory() throws IOException {
    TEMP_DIRECTORY = Files.createTempDirectory("tmpForJUnit");
  }

  @AfterClass
  public static void cleanTempDirectory() throws IOException {
    Files.delete(TEMP_DIRECTORY);
  }

  @Before
  public void setupDirectory() throws IOException {
    Path tempPathForEachTest = Files.createDirectory(TEMP_DIRECTORY.resolve(DIRECTORY_NAME));

    // Create a directory structure
    Files.write(tempPathForEachTest.resolve("file1.txt"), ALL_LINES.subList(0, 2));
    Files.write(tempPathForEachTest.resolve("file2.txt"), ALL_LINES.subList(2, 4));

    Files.createDirectories(tempPathForEachTest.resolve("Empty"));

    Path aSubDir = Files.createDirectories(tempPathForEachTest.resolve("notEmpty"));
    Files.write(aSubDir.resolve("file3.txt"), ALL_LINES.subList(3, 5));
    Files.write(aSubDir.resolve("file4.txt"), ALL_LINES.subList(0, 3));

    aSubDir = Files.createDirectories(aSubDir.resolve("anotherSubDirectory"));
    Files.write(aSubDir.resolve("file5.txt"), ALL_LINES.subList(4, 5));
    Files.write(aSubDir.resolve("file6.txt"), ALL_LINES.subList(0, 2));
  }


  @Test
  public void deleteDirectory() throws IOException {
    Path pathToBeDeleted = TEMP_DIRECTORY.resolve(DIRECTORY_NAME);
    // I am using try with resources
    // and using Java 8 streams and sorted and map and terminal operation forEach
    try (Stream<Path> paths = Files.walk(pathToBeDeleted)) {
      paths.sorted(Comparator.reverseOrder()).map(Path::toFile).forEach(File::delete);
    }

    assertFalse("Directory still exists", Files.exists(pathToBeDeleted));
  }
}
