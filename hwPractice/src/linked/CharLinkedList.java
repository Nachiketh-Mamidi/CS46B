package linked;

import java.util.*;


public class CharLinkedList 
{
	private CharNode		head;	// Empty if head and
	private CharNode		tail;	// tail are null
	
	
	public CharLinkedList()		{ }


	public CharLinkedList(CharNode head, CharNode tail)
	{
		this.head = head;
		this.tail = tail;
	}
	
	
	public CharLinkedList(String s)
	{
		for (int i=s.length()-1; i>=0; i--)
			insertAtHead(s.charAt(i));
	}
	
	
	public void insertAtHead(char ch)
	{
		assert hasIntegrity();		// Precondition
		
		CharNode node = new CharNode(ch);
		node.setNext(head);
		head = node;
		if (tail == null)
			tail = node;			// Corner case: inserting into empty node
		
		assert hasIntegrity();		// Postcondition
	}
	
	
	public String toString()
	{
		String s = "";
		CharNode node = head;
		while (node != null)
		{
			s += node.getData();
			node = node.getNext();
		}
		return s;
	}
	
	public CharNode find (char ch) {
		CharNode current = head;
		while (current != null) {
			if (current.getData() == ch) {
				return current;
			}
			current = current.getNext();
		}
		return null;
	}
	
	public void duplicate(char ch) throws IllegalArgumentException  {
		if (find(ch) == null) {
			throw new IllegalArgumentException("Character not present");
		} 
		CharNode dup = new CharNode(ch);
		CharNode foundnode = find(ch);
		if(tail.getData() == ch) {
			tail.setNext(dup);
			tail = dup;
		} else {
			dup.setNext(foundnode.getNext());
			foundnode.setNext(dup);
		}
	}
		
	
	
	//
	// Returns true if this list has emptiness integrity, has tail integrity, has no loops,  
	// and tail is reachable from head.
	//
	// Caution: this checks for most but not all common integrity problems. 
	//
	boolean hasIntegrity()
	{
		// Check emptiness. If either head or tail is null, the other must
		// also be null. Different logic from what you saw in lecture. Returns
		// immediately if this list is empty.
		if (head == null  ||  tail == null)
			return head == null  &&  tail == null;
		
		// Check tail integrity (tail.next must be null).
		if (tail.getNext() != null)
			return false;
		
		// Check for loops.
		Set<CharNode> test = new HashSet<>();
		CharNode current = head;
		while (current != null) {
			if (test.contains(current)) {
				return false;
			} else {
				test.add(current);
			}
			current = current.getNext();
		}
		
		// Make sure tail is reachable from head.
		CharNode node1 = head;
		while (node1 != null && node1 != tail)
			node1 = node1.getNext();
		return node1 == tail;
	}
}
