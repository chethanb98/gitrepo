package com.test.mongo.mongoconnection;

public class LinkedListLL {
	
	Node head;	
	
	public static void printList(Node l1) {
		while(l1 != null){
			System.out.println(l1.data);
			l1 =l1.next;
		}
	}
	public static Node Reverse(Node l1) {
		Node curr =l1; Node nxt = null; Node prv = null;
		while(curr != null) {
			nxt = curr.next;
			curr.next =prv;
			prv =curr;
			curr =nxt;			
		}
		l1 =prv;
		return l1;
	}

	public void append(int new_data) {
		Node new_node = new Node(new_data); 		  
	    new_node.next = head; 
	    head = new_node;
	}
	
	public void insert(Node prevNode, int new_data) {
		
		Node newNode = new Node(new_data);
		
		newNode.next = prevNode.next;
		prevNode.next = newNode;
		
	}
	
	public void circular(Node node) {
		while(node.next!=null) {
			node=node.next;
		}
		node.next=head;
	}
	public boolean iscircular(Node node) {
		if(node == null)
			return true;
		
		node= node.next;
		while(node!=null && node!=head) {
			node= node.next;
		}
		
		return (node ==head);
	}

	public Node mergeLists(Node node1, Node node2) {
		if(node1==null)
			return node2;
		if(node2==null)
			return node1;

		Node newNode = new Node(0);
		
		Node temp =newNode;
		
		while(node1!=null || node2!=null) {
			if(node1==null) {
				newNode.next = node2;
				break;
			} 
			else if(node2 ==null) {
				newNode.next = node1;
				break;
			}
			else if(node1.data < node2.data) {	
				newNode.next = node1;
				node1 = node1.next;
				}
				else {
					newNode.next = node2;
					node2 = node2.next;
				}
			newNode = newNode.next;
		}
		return temp.next;		
	}
	
	public static void main(String []args) {
		
		LinkedListLL l1 = new LinkedListLL();
		LinkedListLL l2 = new LinkedListLL();
		
		Node lll = new Node(1);
		
		lll.next = new Node(2);
		
		lll.next.next = new Node(3);
		
//		l1.head = l1.new Node(1);
//		l1.head.next = l1.new Node(11);
					
//		printList(l1.head);
		System.out.println("Reverse the data");
//		printList(Reverse(l1.head));
		
		l2.append(12);
		l2.append(10);
		l2.append(5);
		l2.append(4);
		l2.append(3);
//		
//		printList(l2.head);
//		
//		System.out.println("merge two sorted lists");
//		printList(l1.mergeLists(l1.head,l2.head));
//				
//		System.out.println("is circular "+l1.iscircular(l1.head));		
//		l1.circular(l1.head);
//		System.out.println("is circular "+l1.iscircular(l1.head));
		
	}	
}

class Node{
	int data;
	Node next;
	Node(int x){
		this.data =x;
		}
}
