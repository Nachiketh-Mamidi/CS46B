package bst;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
	
	private static class BSTNode{
		private int data;
		private BSTNode leftChild;
		private BSTNode rightChild;
		
		public BSTNode(int data) {
			this.data = data;
		}
		
		public String toString() {
			return data+"";
		}
	}
	
	private BSTNode root;
	
	public BinarySearchTree(int data) {
		root = new BSTNode(data);
	}
	
	public void insert(int data) {
		root = recursiveInsert(root,data);
	}
	
	private BSTNode recursiveInsert(BSTNode node, int data) {
		if(node == null) {
			return new BSTNode(data);
		}
		
		else if(data < node.data) {
			node.leftChild = recursiveInsert(node.leftChild,data);
		}
		else if(data > node.data) {
			node.rightChild = recursiveInsert(node.rightChild,data);
		}
		return node;
	}
	
	public void delete(int data) {
		root = recursiveDelete(root,data);
	}
	
	private BSTNode recursiveDelete(BSTNode node,int data){
		if(node == null) {
			return node;
		}
		else {
		if(data < node.data) {
			node.leftChild = recursiveDelete(node.leftChild,data);
		}
		else if(data > node.data) {
			node.rightChild = recursiveDelete(node.rightChild,data);
		}
		else {//we found the node to delete
			if(node.leftChild==null && node.rightChild == null) {
				return null;
			}
			else if(node.leftChild == null) {
				return node.rightChild;
			}
			else if(node.rightChild == null) {
				return node.leftChild;
			}
			else {//Still need to handle the case with two children
				BSTNode predecessor = getMax(node.leftChild);
				int d = predecessor.data;
				node.data = d;//update data at node
				//remove predecessor node
				node.leftChild = recursiveDelete(node.leftChild,d);
			}
		}
		return node;
		}
	}
	
	//assumes root is not null
	public BSTNode getMax(BSTNode root){
		while(root.rightChild!= null) {
			root = root.rightChild;
		}
		return root;
	}

	//assumes root is not null
	public BSTNode getMin(BSTNode root){
		while(root.leftChild!=null) {
			root = root.leftChild;
		}
		return root;
	}
	
	public boolean contains(int data) {
		if(find(data) == null) {return false;}
		else {return true;}
	}
	
	public BSTNode find(int key) {
		return recursiveFind(root,key);
	}
	
	private BSTNode recursiveFind(BSTNode node,int key) {
		//base case, made it to the end or I found it
		if(node == null || key == node.data) {
			return node;
		}
		if(key < node.data) {
			return recursiveFind(node.leftChild,key);
		}
		else {
			return recursiveFind(node.rightChild,key);
		}
		
	}
	
	//Traverse the tree in an preorder fashion
	//Print the current node first and then recurse on the children
	public void preOrder() {
		preOrderRecurse(root); 
	}
	
	public void preOrderRecurse(BSTNode node) {
//		if (node != null) {
//			System.out.print(node.data + " ");
//		} 
//		if (node.leftChild != null) {
//			preOrderRecurse(node.leftChild);
//		} 
//		if (node.rightChild != null) {
//			preOrderRecurse(node.rightChild);
//		}
		if (node == null) {
			return;
		} 
		System.out.print(node.data + " ");
		preOrderRecurse(node.leftChild);
		preOrderRecurse(node.rightChild);
	}
		

	//Traverse the tree in an inorder fashion
	//Recursively print the left side of the current node, then the current node, 
	//then recursively print the right side of current node
	//For a bst this will print the values in sorted order from smallest to largest
	public void inOrder() {
		inOrderRecurse(root); 
	}
	
	public void inOrderRecurse(BSTNode node) {
		if (node == null) {
			return;
		} 
		inOrderRecurse(node.leftChild);
		System.out.print(node.data + " ");
		inOrderRecurse(node.rightChild);
	}

	//Traverse the tree in an postorder fashion
	//Recurse on the children and then print the value in the current node
	public void postOrder() {
		postOrderRecurse(root); 
	}
	
	public void postOrderRecurse(BSTNode node) {
		if (node == null) {
			return;
		} 
		postOrderRecurse(node.leftChild);
		postOrderRecurse(node.rightChild);
		System.out.print(node.data + " ");
	}
			
	//Traverse the tree in an level order fashion
	//Print the current node, then the two children, then their children, ...
	public void levelOrder() {
		Queue<BSTNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {

			BSTNode current = queue.poll();//look up what this function does in the Java Documentation
			System.out.print(current.data + " ");

			//Enqueue (add) left child if it isn't null  
			if (current.leftChild != null) {
				queue.add(current.leftChild);
			}

			//Enqueue (add) left child if it isn't null  
			if (current.rightChild != null) {
				queue.add(current.rightChild);
			}
		}
	}
	
	//counts the number of nodes in the tree
	public int count() {
		return countRecurse(root);
	}
	
	//recursive helper method to count the nodes in the tree
	private int countRecurse(BSTNode node) {
		int count = 0;
		if(node != null)
		{
			
			if(node.leftChild != null)
			{
				count += countRecurse(node.leftChild);
			}
			count++;
			if(node.rightChild != null)
			{
				count += countRecurse(node.rightChild);
			}
			
		}
		return count;

	}

	public int countOdds() {
		return countOddsRecurse(root);
	}
	
	private int countOddsRecurse(BSTNode node) {
		int count = 0;
		if(node != null)
		{
			if(node.leftChild != null)
			{
				count += countOddsRecurse(node.leftChild);
			}
			if(node.data % 2 != 0)
			{
				count++;
			}	
			if(node.rightChild != null)
			{
				count += countOddsRecurse(node.rightChild);
			}
		}
		return count;
	}
	
	

	public int countEvens() {
		return countEvensRecurse(root);

	}
	
	private int countEvensRecurse(BSTNode node) {
		int count = 0;
		if(node != null)
		{
			if(node.leftChild != null)
			{
				count += countEvensRecurse(node.leftChild);
			}
			if(node.data % 2 == 0)
			{
				count++;
			}	
			if(node.rightChild != null)
			{
				count += countEvensRecurse(node.rightChild);
			}
		}
		return count;
	}
	
	//returns the sum of the data in the tree
	public int sum() {
		return recursiveSum(root);
	}
	
	//recursive helper method to compute the sum
	private int recursiveSum(BSTNode node) {
		int sum = 0;
		if(node != null)
		{
			if(node.leftChild != null)
			{
				sum += recursiveSum(node.leftChild);
			}
			sum += node.data ;
			if(node.rightChild != null)
			{
				sum += recursiveSum(node.rightChild);
			}
		}
		return sum;
	}

	//max length path from root to leaf node
	public int height() {
		return recursiveHeight(root);
	}
	
	private int recursiveHeight(BSTNode node) {
//		if (node == null)
//            return 0;
//        else
//        {
//            int lDepth = recursiveHeight(node.leftChild);
//            int rDepth = recursiveHeight(node.rightChild);
//  
//           
//            if (lDepth > rDepth)
//                return (lDepth + 1);
//             else
//                return (rDepth + 1);
//        }
		int leftHeight = 1;
		int rightHeight = 1;
		
		if (node.leftChild != null) {
			leftHeight += recursiveHeight(node.leftChild);
		}
		if (node.rightChild != null) {
			rightHeight += recursiveHeight(node.rightChild);
		}
		
		return Math.max(leftHeight, rightHeight);
	}
	

	
	//This method creates a test tree that you can use as
	//you build out your find and insert methods
	//After you have created your insert method, 
	//you should use that method to create test trees in the main method
	public static BinarySearchTree testTree(){
		BinarySearchTree bst = new BinarySearchTree(9);
		bst.root.rightChild = new BSTNode(11);
		bst.root.leftChild = new BSTNode(7);
		bst.root.leftChild.leftChild = new BSTNode(2); 
		bst.root.leftChild.rightChild = new BSTNode(8); 
		bst.root.rightChild.rightChild = new BSTNode(15); 
		return bst;
	}
	
	public String toString() {
		return "Tree:" + recursiveToString(root, "");		
	}	

	private String recursiveToString(BSTNode node, String indent) {
		
		if(node == null) {return "";}
		else {
			return "\n" + indent + node.data +
					recursiveToString(node.leftChild,indent + "  ")+
					recursiveToString(node.rightChild,indent + "  ");
		}	
	}
	
	public static void main(String[] args) {
		//DO LOTS OF TESTING!!
        
        BinarySearchTree bst = testTree();
				
		System.out.println(bst);
		System.out.println("PreOrder recurse");
		bst.preOrder();
		System.out.println("");
		
		
		System.out.println("Inorder Recurse");
		bst.inOrder();
		System.out.println("");
		
		System.out.println("Postorder recurse");
		bst.postOrder();
		System.out.println("");	
		
		System.out.println("levelorder recurse");
		bst.levelOrder();
		System.out.println("");	
		
		System.out.println("Count : " + bst.count());
		System.out.println("Sum : " + bst.sum());
		System.out.println("Height : " + bst.height());
		System.out.println("Odd Count : " + bst.countOdds());
		System.out.println("Even Count : " + bst.countEvens());
	}
}

