

class ServiceStartEvent extends Event{
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
   * Constructor for a service start event.
   *
   * .
   * @param time  The time at which this event happens
   *
   * @param counterId   The customer instance associated with this event.
   *          
   * @param counterList   The indicator of which counter is
   *                    available.
   */
  public ServiceStartEvent(Customer customer, Manager manager) {
    super(customer.getArrivalTime());
    this.customer = customer;
    this.manager = manager;
    this.counterId = this.manager.getCurrentCounterNo();
    this.customerId = this.customer.getId();
  }
  /**
   * Returns the string representation of the event.
   *
   * @return A string representing the event.
   */
  @Override
  public String toString() {
    String str = "";
    str = String.format(": Customer %d service begin (by Counter %d)",
            customerId, counterId);
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
    // The current event is a service-begin event.  
    // Mark the counter is unavailable, then schedule
    // a service-end event at the current time + service time.
    this.manager.setCounterAvailability(counterId);
    return new Event[] { 
      new ServiceEndEvent( this.customer,
           this.manager)
      };

  
  }


}
