package com.linkedList;

public class SortedLinkedList <T extends Comparable<T>> {

	Node<T> head;
	Node<T> tail;

	public static void main(String[] args) {			
		SortedLinkedList<Integer> nodeMethods = new SortedLinkedList<Integer>();

		System.out.println("Sorting and Adding 56, 30, 40, 70");
		nodeMethods.sortAdd(56);
		nodeMethods.sortAdd(30);
		nodeMethods.sortAdd(40);
		nodeMethods.sortAdd(70);
		nodeMethods.printLinkedList();
	}

	public void sortAdd(T element) {
		Node<T> newNode = new Node<T>(element);

		if (head == null) {
			head = newNode;
			tail = newNode;
		}
		else
			if(head.data.compareTo(newNode.data) > 0) {
				newNode.next = head;
				head = newNode;
			}
			else
				if (tail.data.compareTo(newNode.data) < 0) {
					tail.next = newNode;
					tail = newNode;
				}
				else {
					Node<T> thisNode = head.next;
					Node<T> previous = head;
					while(thisNode.data.compareTo(newNode.data) < 0 && thisNode != tail) {
						previous = thisNode;
						thisNode = thisNode.next;
					}
					previous.next = newNode;
					newNode.next = thisNode;
				}
	}

	public void printLinkedList() {
		Node<T> thisNode = head;

		if (thisNode == null) 
			System.out.println("\nThe Linked list is empty.\n");
		else {
			System.out.println("\nDisplaying the Linked List : \n");
			while (thisNode != null) {
				System.out.print(" -> " + thisNode.data);
				thisNode = thisNode.next;
			} 
		}
	}
}
