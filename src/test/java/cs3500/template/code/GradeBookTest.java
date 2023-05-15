package cs3500.template.code;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static uk.org.webcompere.systemstubs.SystemStubs.tapSystemOut;

import org.junit.jupiter.api.Test;

class GradeBookTest {

  @Test
  void checkAveraging() {
    final double delta = 0.01;
    GradeBook g1 = new GradeBook(0, 0, 0);
    assertEquals(0, g1.getAverage(), delta);
  }

  @Test
  public void checkSystemOutWrite() throws Exception {
    String text = tapSystemOut(() -> printError("problem!"));
    assertEquals("problem!", text.trim());
  }

  private void printError(String output) {
    System.out.println(output);
  }
}