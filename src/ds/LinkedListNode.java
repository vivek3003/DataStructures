package ds;

/*
 *  @author Vivek Kaarthek
 */
public class LinkedListNode {
	private int data;
	private LinkedListNode next;

	public LinkedListNode(int data) {
		this.data = data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public int getData() {
		return this.data;
	}

	public void setNext(LinkedListNode next) {
		this.next = next;
	}

	public LinkedListNode getNext() {
		return this.next;
	}

	/*
	 * Operations 1.Traversal 2.Insertion 3.Deletion
	 */

	public int ListLength(LinkedListNode headNode) {
		int len = 0;
		LinkedListNode curr = headNode;

		while (curr != null) {
			len++;
			curr = curr.getNext();
		}
		return len;
	}

	public LinkedListNode insertNode(LinkedListNode headNode,
			LinkedListNode newNode, int position, Boolean insertAtEnd) {
		if (headNode == null) {
			return null;
		}

		if (insertAtEnd) {
			LinkedListNode curr = headNode;
			while (curr.next != null) {
				curr = curr.getNext();
			}
			curr.next = newNode;
		} else {
			int size = ListLength(headNode);
			if (position == 1) {
				newNode.setNext(headNode);
			} else {
				LinkedListNode curr = headNode;
				for (int i = 2; i <= position; i++) {
					curr = curr.getNext();
					if (i > size) {
						System.out.print("Invalid Position");
					}
				}
				curr.setNext(newNode);
			}
		}

		return headNode;
	}

	public LinkedListNode deleteNode(LinkedListNode headNode, int position) {
		if (headNode == null) {
			return null;
		}

		int size = ListLength(headNode);

		if (position > size || position < 1) {
			return headNode;
		}

		if (position == 1) {
			LinkedListNode curr = headNode.getNext();
			headNode = null;
			return curr;
		} else {
			LinkedListNode prev = headNode;
			for (int i = 1; i < position - 1; i++) {
				prev = prev.getNext();
			}
			LinkedListNode curr = prev.getNext();
			prev.setNext(curr.getNext());
			curr = null;
		}

		return headNode;

	}
}
