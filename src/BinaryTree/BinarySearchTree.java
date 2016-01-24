package BinaryTree;
/** 
 * 
 * @author UJ
 *
 * @param <T>
 */

import java.util.*;
import java.lang.*;


public class BinarySearchTree <T extends Comparable<? super T> > implements IBTreeInterface<T>{
	private Node <T> root;
	private int height;
	
	BinarySearchTree(){
		root = null;
		height = 0;
	}
	
	public Node<T> getRoot() {
		return root;
	}

	public void setRoot(Node<T> root) {
		this.root = root;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	boolean isTreeEmpty(){
		return(size(this.getRoot()) == 0);
	}
	
	@Override
	public void insert(BinarySearchTree b, T value) {
		if(isTreeEmpty()){
			setRoot(new Node<T>(value));
			return;
		}
		else{
			Node<T> temp = getRoot();
			insertNodeToTree(temp,value);
		}
	}
	
	public void insertNodeToTree(Node<T> treeNode, T value){
		T data = treeNode.getData();
		
		if( value.compareTo(data) >= 0){
			if(treeNode.getRight() == null){
				Node<T> newNode = new Node<T>(value);
				treeNode.setRight(newNode);
				return;
			}
			else{
				insertNodeToTree(treeNode.getRight(),value);
			}
		}
		else{
			if(treeNode.getLeft() == null){
				Node<T> newNode = new Node<T>(value);
				treeNode.setLeft(newNode);
				return;
			}
			else{
				insertNodeToTree(treeNode.getLeft(),value);
			}
		}
	}
	
	public Node<T> lookUpUtil(Node curNode, T value){
		if(curNode == null){
			return null;
		}
		else if(curNode.getData() == value){
			return curNode;
		}
		//Need to check which casting is done here!!!
		else if(((Comparable<? super T>) curNode.getData()).compareTo(value) >= 0){
			return lookUpUtil(curNode.getLeft(), value);
		}
		else
			return lookUpUtil(curNode.getRight(), value);
	}
	
	@Override
	public Node<T> lookUp(Node b, T value){
		Node<T> curNode = root;
		return lookUpUtil(curNode,value);
	}

	@Override
	public Node<T> delete(Node b, T value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size(Node curNode) {
		// TODO Auto-generated method stub
		
		if(curNode == null)
			return 0;
		return (size(curNode.getRight())+ size(curNode.getLeft()) + 1);
	}

	@Override
	public int maxDepth(BinarySearchTree b) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T minValue(BinarySearchTree b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasPathSum(BinarySearchTree b, int sumValue) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Node mirror(BinarySearchTree b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isBST(BinarySearchTree b) {
		// TODO Auto-generated method stub
		return isBSTUtil(b.getRoot());
	}

	public boolean isBSTUtil(Node curNode){		
		if(curNode == null || curNode.getLeft()== null || curNode.getRight() == null)
			return true;
		if((((Comparable<? super T>) curNode.getLeft().getData()).compareTo((T) curNode.getData()) >= 0) || 
				(((Comparable<? super T>) curNode.getRight().getData()).compareTo((T) curNode.getData()) <= 0)){
			return false;
		}
		else return true;
	}
	@Override
	public void printPostOrder(Node curNode) {
		// TODO Auto-generated method stub
		if(curNode == null)
			return;
		printInOrder(curNode.getLeft());
		printInOrder(curNode.getRight());
		System.out.println(curNode.getData());
	}

	@Override
	public void printPreOrder(Node curNode) {
		// TODO Auto-generated method stub
		if(curNode == null)
			return;
		System.out.println(curNode.getData());
		printInOrder(curNode.getLeft());
		printInOrder(curNode.getRight());
	}

	@Override
	public void printInOrder(Node curNode) {
		// TODO Auto-generated method stub
		if(curNode == null)
			return;
		printInOrder(curNode.getLeft());
		System.out.println(curNode.getData());
		printInOrder(curNode.getRight());	
	}
}
