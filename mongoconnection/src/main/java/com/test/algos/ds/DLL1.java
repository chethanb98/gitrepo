package com.test.algos.ds;

public class DLL1 {
	
	Node head;
	
	class Node{
		int data;
		Node next,prev;
		
		Node(int x){data =x;}
	}
	
	public void push(int new_data) {
		// add node at the front
		Node newnode = new Node(new_data);
		
		newnode.next = head;
		newnode.prev = null;
		
		if(head!=null)
			head.prev = newnode;		
		head = newnode;	
	}
	
	public void insertAfter(Node prevNode, int new_data) {
		Node newNode = new Node(new_data);
		
		newNode.prev = prevNode;
		if(prevNode.next!=null) {
			newNode.next = prevNode.next;
			newNode.next.prev = newNode;
			prevNode.next = newNode;
		}		
	}
	
	public void append(int new_data) {
		Node last;
		Node newNode = new Node(new_data);
		if(head!=null)
			last=head;
		last =head;
		while(last.next!=null) {
			last=last.next;
		}
		last.next= newNode;
		newNode.prev = last;
		newNode.next = null;		
	}
	
	public void printList(Node node) {
		Node last;
		last = node;
		while (node!=null) {
			System.out.println("node value is "+ node.data);
			last=node;
			node =node.next;
		}
		
		while(last!=null) {
			System.out.println("node value reverse direction is "+ last.data);
			last = last.prev;
		}
	}
	
	public static void main(String [] args) {
		DLL1 dll = new DLL1();
		
		dll.push(0);
		dll.push(1);
		dll.push(2);
		
		dll.append(10);
		dll.append(11);
		dll.insertAfter(dll.head.next, 8);
		dll.printList(dll.head);
	}
}
