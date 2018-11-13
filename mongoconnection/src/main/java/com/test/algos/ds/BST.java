package com.test.algos.ds;

public class BST {
	
	Node root;
	
	BST(int key){
		root = new Node(key);		
	}
	BST(){
		root =null;
	}
	
	class Node{
		int key;
		Node left, right;
		
		public Node(int x){key =x;}		
	}
	
	public void PrintInOrder(Node root) {
		if(root==null) 
			return;					
		PrintInOrder(root.left);
		System.out.print("   "+ root.key);
		PrintInOrder(root.right);				
	}
	public void PrintPostOrder(Node root) {
		if(root==null) 
			return;					
		PrintPostOrder(root.right);
		System.out.print("   "+ root.key);
		PrintPostOrder(root.left);				
	}
	public void PrintPreOrder(Node root) {
		if(root==null) 
			return;							
		System.out.print("   "+ root.key);		
		PrintPreOrder(root.left);				
		PrintPreOrder(root.right);
	}
	public void InsertLeft(Node root, int data) {
		
		while(root.left!=null) {
			root= root.left;
		}
		root.left = new Node(data);
	}
	public void InsertRight(Node root, int data) {
		
		while(root.right!=null) {
			root= root.right;
		}
		root.right = new Node(data);
	}

	public boolean IsBST(Node root) {
		if(root ==null) return true;				
		if(root!=null && root.left.key < root.key) IsBST(root.left); 
		if(root!=null && root.right.key > root.key)  IsBST(root.right);
		return false;
	}
	
	public static void main(String []args) {
		
		BST tree = new BST();
		
		tree.root = tree.new Node(1);	
		tree.InsertLeft(tree.root, 2);
		tree.InsertLeft(tree.root, 3);
		tree.InsertRight(tree.root, 4);
		tree.InsertRight(tree.root, 5);
		System.out.println(" print Inorder binary tree enteres ");
		tree.PrintInOrder(tree.root);
		System.out.println("\n");
		System.out.println(" print post order binary tree enteres ");
		tree.PrintPostOrder(tree.root);
		System.out.println("\n");
		System.out.println(" print pre order binary tree enteres ");
		tree.PrintPreOrder(tree.root);
		System.out.println("\n");
		
	}
}