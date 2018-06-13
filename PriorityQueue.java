
public class PriorityQueue {
	      private PriorityCustomer[] data;
	      private int heapSize;
	      PriorityCustomer PQ = new PriorityCustomer();
	 
	      public PriorityQueue(int size) {
	    	  data = new PriorityCustomer[size];
              heapSize = 0;
              
            
        }
          public int getHeapSize() {
        	  return heapSize;
          }
	      
	      private void Heapify(int nodeIndex) {
              PriorityCustomer current = data[nodeIndex];
              PriorityCustomer left = data[getLeftChildIndex(nodeIndex)];
              PriorityCustomer right = data[getRightChildIndex(nodeIndex)];
              PriorityCustomer temp;
              int minimum = 10000000;
              int minSide = -1; // 0 left, 1 right

              if (left != null && left.getServiceTime() < minimum) {
                  minimum = left.getServiceTime();
                  minSide = 0;
              }

              if (right != null && right.getServiceTime() < minimum) {
                  minimum = right.getServiceTime();
                  minSide = 1;
              }

              if ((current != null && current.getServiceTime() > minimum) || current == null) {
                  if (minSide == 0) {
                      temp = current;
                      current = left;
                      left = temp;
                      Heapify(getLeftChildIndex(nodeIndex));
                  } else if (minSide == 1) {
                      temp = current;
                      current = right;
                      right = temp;
                      Heapify(getRightChildIndex(nodeIndex));
                  }
              } 
        }
	      public void ProcessTickets() {
              for (int i = 0; i < heapSize; i++) {
                  if (data[i] != null)
                    data[i].decServiceTime();
              }
          }
	     

	      private void ReHeapify() {
	            for (int i = heapSize; i > 0; i--) {
	                  Heapify(i);
	              }
	        }
	      
	      public void insert(PriorityCustomer c){
	    	    data[heapSize] = c; 
	    	    heapSize++; 
	    	    ReHeapify();
	    	}
	      
        public void deleteRoot() {
              data[0] = null;
              ReHeapify();
        }
        public void delMinimum() {
            if (isEmpty())
                  throw new HeapException("Heap is empty");
            else {
                  deleteRoot();
            }
        }

        public PriorityCustomer getMinimum() {
            if (isEmpty())
                  throw new HeapException("Heap is empty");
            else {
                  return data[0];
            }
        }
	      
	 
	      public boolean isEmpty() {
	            return (heapSize == 0);
	      }
	 
	      private int getLeftChildIndex(int nodeIndex) {
	            return 2 * nodeIndex + 1;
	      }
	 
	      private int getRightChildIndex(int nodeIndex) {
	            return 2 * nodeIndex + 2;
	      }
	 
	      private int getParentIndex(int nodeIndex) {
	            return (nodeIndex - 1) / 2;
	      }
	 
	      public class HeapException extends RuntimeException {
	            public HeapException(String message) {
	                  super(message);
	            }
	      }
	}