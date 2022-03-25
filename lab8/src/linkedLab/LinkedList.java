package linkedLab;

public class LinkedList {
	private class Node{
		int data;
		Node next;
		public Node(int data,Node next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node head;
	private Node tail;

	public boolean isEmpty() {
		return head==null && tail==null;
	}

	public int size() {
		int size=0;
		Node current = head;
		while(current!=null) {
			size++;
			current = current.next;
		}
		return size;
	}

	public void insertAtHead(int data) {
		Node node = new Node(data,null);//new head points to old head
		node.next = head;
		head = node;
		if(tail==null) {
			tail = node;
		}

	}

	public void appendAtTail(int data) {
		Node node = new Node(data,null); //will be the tail;
		if(tail!=null) {
			tail.next = node;
		}
		else {//empty list
			head = node;
		}
		tail = node;

	}

	//****IMPLEMENT THIS*******//
	//Look for the node in the list that contains dataBefore
	//Create a new node that contains data and insert it immediately after the dataBefore node
	//For example if I call insertAfter(2,7) with the list [1,2,3]
	//the new list would be [1,2,7,3]
	//if the dataBefore does not exist in the list, print a useful message to the console
	public void insertAfter(int dataBefore, int data) {
		Node current = head;
		Node toInsert = new Node(data, null);
		while (current != null) {
			if (current.data == dataBefore) {
				toInsert.next = current.next;
				current.next = toInsert;
				return;
			} else {
				current = current.next;
			}
		} 
		

	}

	//****IMPLEMENT THIS*******//
	//remove the first node that has data equal to data
	//if the list is empty throw an illegal argument exception
	//if the list doesn't contain a node with data == data, 
	//then print a useful message to the console
	public void delete(int data) {
		while (head != null && head.data == data) {//remove from head 
			   head = head.next; 
			 }  
			 if(head == null) {tail=null;} //empty list or I removed everything} 
			   
			 else {   
			   Node current = head;//where I am in the list 
			   while(current.next!=null) { 
			     if(current.next.data == data) { 
			       current.next = current.next.next;//remove node from the list 
			       if(current.next == null) {//removed the tail 
			       tail = current; 
			     } 
			     } 
			   else { 
			     current = current.next; 
			   } 
			  } 
			  }   
	} 

	


	public int max() {
		assert !isEmpty(): "can't take the max of an empty list";
		return maxRecurse(head);
		//return maxRecurse();

	}

	private int maxIterate() {
		Node current = head;
		int max = Integer.MIN_VALUE;

		while(current!=null) {
			if(current.data>max) {max = current.data;}
			current = current.next;
		}
		return max;	
	}

	//****IMPLEMENT THIS*******//
	//Recursively find the maximum element in the list.
	//Called by max()
	//Feel free to add parameter(s).
	private int maxRecurse(Node x) {
		if (x.next == null) {
			return x.data;
		} else {
			return Math.max(x.data, maxRecurse(x.next));
		}
	}

	//****IMPLEMENT THIS*******//
	//Swap two nodes in a linked list
	//Don't just swap the data in the nodes, swap the actual nodes
	//If either i or j don't exist in the list, print a useful message to the console
	public void swap(int i, int j) {
		if(head == null) {return;} //empty list
		if(i==j) {return;}//swapping wouldn't change the list

//		Node previousNodeI = null;
//		Node previousNodeJ = null;

		Node NodeI = head;
		Node NodeJ = head;
		
		Node previousNodeI = null;
		Node previousNodeJ = null;
		

		while (NodeI != null && NodeI.data != i) {
			previousNodeI = NodeI;
			NodeI = NodeI.next;
		}
		
		while (NodeJ != null && NodeJ.data != j) {
			previousNodeJ = NodeJ;
			NodeJ = NodeJ.next;
		}
		
		if (NodeI == null || NodeJ == null) {
			return;
		} 
		if (previousNodeI != null)
			previousNodeI.next = NodeJ;
        else // make y the new head
            head = NodeJ;
		
		if (previousNodeJ != null)
			previousNodeJ.next = NodeI;
        else // make x the new head
            head = NodeI;
		
		Node temp = NodeI.next;
		NodeI.next = NodeJ.next;
		NodeJ.next = temp;
		
	}


	//****IMPLEMENT THIS*******//
	//Reverse the linked list
	//E.G. [1,2,3] -> [3,2,1]
	//You can only use one while loop
	public void reverse() {
		if(head==null) {return;}//empty list
		else if(head==tail ) {return;}//one element list
        else {
            
        }
	
	}

	public String toString() {
		String s = "[";
		Node current=head;
		while(current!=null) {
			s = s + current.data;
			current = current.next;
			if(current!=null) {s = s+",";}
		}
		return s + "]";
	}

	//put your test code here
	public static void main(String[] args) {
		LinkedList intList = new LinkedList();
		intList.appendAtTail(2);
		intList.appendAtTail(3);
		intList.appendAtTail(5);
		intList.appendAtTail(7);
		
		System.out.println(intList);
		
		intList.swap(2,3);
		System.out.println(intList);
	}

}


