package managers;

import contracts.*;
import problemdomain.*;
import java.io.*;

/**
 * @author JONGHYUN PARK
 * @version 05 Apr, 2020
 */
public class SLL implements LinkedListADT, Serializable {
	/**
	 * The first node in the linked list.
	 */
	private Node head;

	/**
	 * The number of nodes in the linked list.
	 */
	private int size;
	
	/**
	 * Generated default serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @throws NotSerializableException
	 */
	public SLL() throws NotSerializableException {
		this.head = null;
		this.size = 0;
	}

	/**
	 * Checks if the list is empty.
	 * @return True if it is empty.
	 */
	public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		return false;
	}

	/**
	 * Clears the list.
	 */
	public void clear() {
		head = null;
		size = 0;
	}
	
	/**
	 * Prepends (adds to beginning) data to the list.
	 * @param Oject data Data to store as a first element.
	 */
	public void prepend(Object data) {
		Node newNode = new Node(data);
		newNode.setNext(head);
		head = newNode;
		size++;
	}
	
	/**
	 * Adds to the end of the list.
	 * @param Oject data Data to append.
	 */
	public void append(Object data) {
		Node newNode = new Node(data);
		if (isEmpty()) {
			head = new Node(data);
			size++;
		} else {
			Node previous = head;
			while (previous.getNext() != null) {
				previous = previous.getNext();
			}
			previous.setNext(newNode);
			size++;
		}
	}
	
	/**
	 * Adds a new element at a specific position.
	 * @param Oject data Data to insert at specific index.
	 * @param index Index to add a new element at.
	 * @exception IndexOutOfBoundsException Thrown if index is negative or past the size of the list.
	 */
	public void insert(Object data, int index) throws IndexOutOfBoundsException {
		if (size >= index) {
			Node newNode = new Node(data);
			if (index == 0) {
				newNode.setNext(head);
				head = new Node(data);
				size++;
			} else {
				Node previous = head;
				for (int i = 0; i < index - 1; i++) {
					previous = previous.getNext();
				}
				Node now = previous.getNext();
				previous.setNext(newNode);
				newNode.setNext(now);
				size++;
			}
		} else {
			throw new IndexOutOfBoundsException();
		}
	}
	
	/**
	 * Replaces the data  at index.
	 * @param Ojbect data Data to replace at specific index.
	 * @param index Index of the element to replace.
	 * @exception IndexOutOfBoundsException Thrown if index is negative or larger than size - 1 of list.
	 */
	public void replace(Object data, int index) throws IndexOutOfBoundsException {
		if (size >= index) {
			if (index == 0) {
				Node newNode = new Node(data);
				newNode.setNext(head);
				head = newNode;
				size++;
			} else {
				Node current = head;
				for (int i = 0; i < index; i++) {
					current = current.getNext();
				}
				current.setData(data);
			}
		} else {
			throw new IndexOutOfBoundsException();
		}
	}
	
	/**
	 * Gets the number of elements in the list.
	 * @return Size of list (0 meaning empty)
	 */
	public int size() {
		Node nodeSize = head;
		int count = 0;
		while (nodeSize != null) {
			nodeSize = nodeSize.getNext();
			count++;
		}
		return count;
	}
	
	/**
	 * Removes element at index from list, reducing the size.
	 * @param index Index of the element to remove.
	 * @exception IndexOutOfBoundsException Thrown if index is negative or past the size - 1.
	 */
	public void delete(int index) throws IndexOutOfBoundsException {
		if (size >= index) {
			if (index == 0) {
				Node current = head;
				current.setNext(current.getNext());
				current = current.getNext();
				current = head;
			} else {
				Node previous = head;
				for (int i = 0; i < index - 1; i++) {
					previous = previous.getNext();
				}
				Node now = previous.getNext();
				previous.setNext(now.getNext());
				now.setNext(null);
				size--;
			}
		} else {
			throw new IndexOutOfBoundsException();
		}
	}
	
	/**
	 * Gets the data at the specified index.
	 * @param index Index of the element to get.
	 * @return Data in element or null if it was not found.
	 * @exception IndexOutOfBoundsException Thrown if index is negative or larger than size - 1 of the list.
	 */
	public Object retrieve(int index) throws IndexOutOfBoundsException {
		if (size >= index) {
			Node found = head;
			for (int i = 0; i < index; i++) {
				found = found.getNext();
			}
			return found.getData();
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	/**
	 * Gets the first index of element containing data.
	 * @param Object data Matched data to find at the first index of.
	 * @return First of index of the element with matching data or -1 if not found.
	 */
	public int indexOf(Object data) {
		int index = 0;
		Node current = head;
		while (current != null) {
			if (data == current.getData()) {
				return index;
			} else {
				index++;
				current = current.getNext();
			}
		}
		return index;
	}

	/**
	 * Go through elements and check if we have one with data.
	 * @param Oject data Data to search for.
	 * @return True if element exists with value.
	 */
	public boolean contains(Object data) {
		boolean found = false;
		Node current = head;
		while (!found && current != null) {
			if (data == current.getData()) {
				found = true;
			} else {
				current = current.getNext();
			}
		}
		return found;
	}
}