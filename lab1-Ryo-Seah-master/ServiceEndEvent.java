
class ServiceEndEvent extends Event{
  /** 
   * The customer instance associated with this particular event.   
   */ 
  private Customer customer;
  /** 
   *  The manager associated with all events.
   * Contains a Counter[] that has all initiated counters.
   */
  private Manager manager;
  /** 
   * The id of a counter associated with this event.  
   * First counter has id 0. Next is 1, 2, etc. 
   */
  private int counterId;
  /** 
   * The id of a customer associated with this event.  
   * First customer has id 0. Next is 1, 2, etc. 
   */
  private int customerId;
  /**
   * Constructor for a service end event.
   * @param customer   The customer instance associated with this event.
   *          
   * @param manager   The manager instance associated with this event.
   */ 
  public ServiceEndEvent(Customer customer, Manager manager) {
    super(customer.getEndTime());
    this.customer = customer;
    this.manager = manager;
    this.counterId = this.manager.getCurrentCounterNo();
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
    str = String.format(": Customer %d service done (by Counter %d)",
            this.customerId, this.counterId);
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
    // The current event is a service-end event.  
    // Mark the counter is available, then schedule
    // a departure event at the current time.
    this.manager.setCounterAvailability(counterId);
    return new Event[] {
      new DepartureEvent(this.customer, this.manager) 
    };
  }
}
