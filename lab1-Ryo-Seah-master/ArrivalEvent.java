
/**
 * This class Encapsulates an arrival event
 * of the bank simulation.
 * @author Wei Tsang
 * @version CS2030S AY21/22 Semester 2
 */

class ArrivalEvent extends Event { 
  /** 
   * The manager associated with all events.
   * Contains a Counter[] that has all initiated counters.
   */
  private Manager manager;
  /** 
   * The customer instance associated with this particular event.
   * Contains arrival time, service time and end time associated with it. 
   */ 
  private Customer customer;
  /** 
   * The id of a customer associated with this event.  
   * First customer has id 0. Next is 1, 2, etc. 
   */
  private int customerId;

  /**
   * Constructor for a Arrival event.
   *
   * @param customer   The customer instance associated with this event.
   *          
   * @param manager   The manager instance associated with this event.
   */
  public ArrivalEvent(Customer customer,
       Manager manager) {
    super(customer.getArrivalTime());
    this.customer = customer;
    this.manager = manager;
    this.customerId = customer.getId();
  }
  /**
   * Returns the string representation of the event.
   *
   * @return A string representing the event.
   */
  @Override
  public String toString() {
    String str = "";
    str = String.format(": Customer %d arrives", this.customerId);
    return super.toString() + str; 
    }

  /**
   * The logic that the simulation should follow when simulating
   * this event.
   *
   * @return An array of new events to be simulated.
   */
  @Override
  public Event[] simulate() {
   int counter = manager.allocateCounter();
       if (counter == -1) {
        // If no such counter can be found, the customer
        // should depart.
	       this.customer.setEndTimeToArrival();
         return new Event[] {
           new DepartureEvent(this.customer, this.manager)
         };
       } else {
        // Else, the customer should go the the first
        // available counter and get served.
	         manager.setCurrentCounterNo(counter);
          return new Event[] {
            new ServiceStartEvent(this.customer,
                this.manager)
           };
         }
  } 


}


