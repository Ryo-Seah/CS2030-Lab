class DepartureEvent extends Event{
  /** 
   * The customer instance associated with this particular event.   
   */ 
  private Customer customer;
  /**
   * The id of a customer associated with this event.  
   * First customer has id 0. Next is 1, 2, etc. 
   */
  private int customerId;
  /** 
   * The id of a counter associated with this event.  
   * First counter has id 0. Next is 1, 2, etc. 
   */
  private int counterId;
    
  /**
   * Constructor for a Departure event.
   * @param customer   The customer instance associated with this event.
   *          
   * @param manager   The manager instance associated with this event.
   */ 
  public DepartureEvent(Customer customer, Manager manager) {
    super(customer.getEndTime());
    this.customer = customer;
    this.customerId = customer.getId();
    this.counterId = manager.getCurrentCounterNo();
  } 
  /**
   * Returns the string representation of the event.
   *
   * @return A string representing the event.
   */
  @Override
  public String toString() {
    String str = "";
    str = String.format(": Customer %d departed", this.customerId); 
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
 // return nothing
    return new Event[] {};
 }
}                                                                                                                                                                                         
