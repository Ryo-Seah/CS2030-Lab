/**
 * This class Encapsulates a Customer Object.
 * @author Ryo Seah
 * @version CS2030S AY21/22 Semester 2
 */
class Customer {
  /** The number of customers associated with the class used to instantiate customers with a
   *    a customer Id
   **/    
  private static int customerCount = 0;
  /** 
   * The id of a customer associated with this event.  
   * First customer has id 0. Next is 1, 2, etc. 
   */
  private int customerId;
  /** 
   * The Arrival time, servicetime and end time associated with a customer. 
   */
  private double arrivalTime, serviceTime, endTime;
  /**
   * Constructor for a Customer instance.
   *
   * @param arrivalTime 
   *
   * @param serviceTime
   */ 
  public Customer(double arrivalTime, double serviceTime) {
    this.arrivalTime = arrivalTime;
    this.serviceTime = serviceTime;
    this.endTime = serviceTime + arrivalTime;    
    this.customerId = customerCount;
    customerCount++;
  }

 /**
  * The logic that the simulation should follow when simulating
  * this event.
  *
  *
  * @return An array of new events to be simulated.
  */
  public int getId() {
    return this.customerId;
 }

  public double getArrivalTime() {
    return this.arrivalTime;
  }
  public double getServiceTime() {
    return this.serviceTime;
  }
  public double getEndTime() {
    return this.endTime;
  }
  public void setEndTimeToArrival() {
    this.endTime = arrivalTime;
  }
}

