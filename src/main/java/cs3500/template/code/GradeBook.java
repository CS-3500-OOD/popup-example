package cs3500.template.code;

/**
 * GradeBook represents one student's scores on up to 3 exams.
 *
 */
public class GradeBook {
  private final int exam1;
  private final int exam2;
  private final int exam3;

  /**
   * Initialize a GradeBook object with 3 exam scores.
   *
   * @param e1 grade on exam 1
   * @param e2 grade on exam 2
   * @param e3 grade on exam 3
   */
  public GradeBook(int e1, int e2, int e3) {
    exam1 = e1;
    exam2 = e2;
    exam3 = e3;
  }

  /**
   * returns the numerical average of the three exams.  This method assumes the exams
   * are evenly weighted.
   *
   * @return average of the three exam grades
   */
  public double getAverage() {
    return (exam1 + exam2 + exam3) / 3.0;
  }
}
