/**
 * This class Encapsulates a counter Object
 *   of the bank simulation.
 * @author Ryo Seah
 * @version CS2030S AY21/22 Semester 2
 */
class Counter {
  /** 
   * The id of this counter instance. 
   * First counter has id 0. Next is 1, 2, etc. 
   */
  private int counterId;
  /** 
   * The counter count of the Counter class. 
   * This is used to assign counter Ids to each instance. 
   */
  private static int counterCount = 0;
  /** 
   * This shows whether a counter is available for service 
   */
  private boolean availability;
  /**
   * Constructor for a Counter object.
   */ 
  public Counter() {
    this.counterId = counterCount;
    counterCount++;
    this.availability = true;
  }
  /** 
   * Returns the availabilty of a counter
   * 
   * @Return a boolean representing availability of counter.
   */ 
  public boolean get_availability() {
    return this.availability;
  }
  /** 
   * Changes availability of counter. 
   */ 
  public void change_availability() {
    if (this.availability) {
      this.availability = false;
    } else {
      this.availability = true;
    }
  
  }


}

