package cs3500.template.code;


/**
 * This is the main driver of this project.
 */
public class Main {
  /**
   * Project entry point
   *
   * @param args - no command line args required
   */
  public static void main(String[] args) {
    GradeBook cs3500 = new GradeBook(100, 100, 100);

    System.out.println(cs3500.getAverage());

  }
}