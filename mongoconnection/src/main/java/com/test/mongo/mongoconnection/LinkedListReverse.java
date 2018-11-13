package com.test.mongo.mongoconnection;


//Java program for reversing the linked list 

class LinkedList { 

  Node head; 

  class Node { 

     int data; 
     Node next; 

     Node(int d) { 
         data = d; 
         next = null; 
     } 
 } 

 /* Function to reverse the linked list */
 Node reverse(Node node) { 
     Node prev = null; 
     Node current = node; 
     Node next = null; 
     while (current != null) { 
         next = current.next; 
         current.next = prev; 
         prev = current; 
         current = next; 
     } 
     node = prev; 
     return node; 
 } 

 // prints content of double linked list 
 void printList(Node node) { 
     while (node != null) { 
         System.out.print(node.data + " "); 
         node = node.next; 
     } 
 } 

 public static void main(String[] args) { 
     LinkedList list = new LinkedList(); 
    
     list.head = list.new Node(85); 
     list.head.next = list.new Node(15); 
     list.head.next.next = list.new Node(4); 
     list.head.next.next.next = list.new Node(20); 
       
     System.out.println("Given Linked list"); 
     list.printList(list.head); 
     list.head = list.reverse(list.head); 
     System.out.println(""); 
     System.out.println("Reversed linked list "); 
     list.printList(list.head); 
     
     LinkedList list1 = new LinkedList();
     LinkedList list2 = new LinkedList();     
     
     System.out.println("linked list1\n");  
     
     list1.head = list1.new Node(3);
     list1.head.next = list1.new Node(2);
     list1.head.next.next = list1.new Node(3);
     
     list2.head = list2.new Node(4);
     list2.head.next = list2.new Node(4);
     list2.head.next.next = list2.new Node(5);
     
     list1.printList(list1.head); 
     
     System.out.println("linked list2 \n"); 
     list2.printList(list2.head);
     
     	new solution(list1, list2);
    	     
 } 
} 

class solution{
	
	solution(LinkedList list1, LinkedList list2){
		
		LinkedList list3 = new LinkedList();
		
		list3.head = list3.new Node(list1.head.data + list2.head.data);
		list3.head.next = list3.new Node(list1.head.next.data + list2.head.next.data);
		list3.head.next.next = list3.new Node(list1.head.next.next.data + list2.head.next.next.data);
			
		System.out.println("linked list3\n"); 
		 
		list3.printList(list3.head); 
		
		list3.head = list3.reverse(list3.head); 
	     System.out.println(""); 
	     System.out.println("Reversed linked list "); 
	     list3.printList(list3.head); 

	}
}
