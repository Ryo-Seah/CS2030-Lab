/**
 * This class encapsulates all counter objects it .
 * @author Ryo Seah
 * @version CS2030S AY21/22 Semester 2
 */
class Manager {
  /**
   * The number of counters in total  
   **/    
  private int numOfCounter;
  /**
   * The List containing all the counter objects.  
   **/  
  private Counter[] counterList;
  /**
   * The current counter being accessed for the current event.
   **/ 
  private int currentCounterNo;
  /**
   * Constructor for a Manager instance.
   *
   * @param numOfCounter The number of counters to be initialized 
   *
   */ 
  public Manager(int numOfCounter) {
    this.numOfCounter = numOfCounter;
    this.counterList = new Counter[numOfCounter];
      for (int i = 0; i < numOfCounter; i++) {
         counterList[i] = new Counter();
      }
  }
  /**
   * Allocates the first availabile counter to service a customer and changes its availability,
   * then returns that counterId.
   */ 

  public int allocateCounter() {
    int counter = -1;
      for (int i = 0; i < this.counterList.length; i += 1) {
        if (this.counterList[i].get_availability()) {
          counter = i;
          break;
        }
      }
    return counter;  
  }
  /**
   * Sets the current Counter for the current event to the given counterId
   *
   * @param counterNo CounterId of the counter to be set
   **/  
  public void setCurrentCounterNo(int counterNo) {
    this.currentCounterNo = counterNo;
  }
  /**
   * Returns the current Counter for the current event.
   **/  
  public int getCurrentCounterNo() {
    return this.currentCounterNo;
  }
   /**
   * Change the availability of given counter
   *
   * @param counterNo CounterId of the counter to have availability changed
   **/  
  public void setCounterAvailability(int counterNo) {
    this.counterList[counterNo].change_availability();
  }
}
