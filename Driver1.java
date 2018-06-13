import java.util.Random;

public class Driver1 {
     public static void main(String[ ] args)
     {
        //Keeps track of total number of customers serviced
    int customerServiced =0;
    //amount of time the customer has been there based on for loop iterations
    int lineSimulation = 60;
    //call to LinkedQueue class
	PriorityQueue pq = new PriorityQueue(lineSimulation);
	PriorityCustomer c = new PriorityCustomer();
    // for loop to simulate the passage of 1 minute per loop
    for(int i = 0; i <= lineSimulation; i++)
    {
        //25% chance a customer comes in
        int customerChance = new Random().nextInt(4) + 1;
        //25% to be 1 if it rolls a 1 new customer is then added to queue
        if (customerChance <= 1)
        {
            //keeps track of number of customers serviced
            customerServiced++;
            //call to the enqueue method from LinkedQueue.java
            pq.insert(c);
            System.out.println("Customer added to the Queue!");
        }    
        
        if (!(pq.isEmpty())) {
            if(pq.getMinimum() != null && pq.getMinimum().getServiceTime() <= 0)
            {
                pq.delMinimum();
                int QL = pq.getHeapSize(); 
                System.out.println("Customer serviced and removed from the queue!\n " + "Queue length is now: " + QL);
            } 
            pq.ProcessTickets();
        }
        
      
System.out.println("---------------------------------------------------");
			

        //if statement to remove customer from front of line once service time is reached and their is at least one person in line
            //calls upon the removal command for a customer fully serviced
        
    }
     }
}
