package ds;

/*
 *  @author Vivek Kaarthek
 */
public class LinkedListNode<T> {
	private Object data;
	private LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.data = data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Object getData() {
		return this.data;
	}

	public void setNext(LinkedListNode<T> next) {
		this.next = next;
	}

	public LinkedListNode<T> getNext() {
		return this.next;
	}

	/*
	 * Operations 1.Traversal 2.Insertion 3.Deletion
	 */

	public int ListLength(LinkedListNode<T> headNode) {
		int len = 0;
		LinkedListNode<T> curr = headNode;

		while (curr != null) {
			len++;
			curr = curr.getNext();
		}
		return len;
	}

	public LinkedListNode<T> insertNode(LinkedListNode<T> headNode,
			LinkedListNode<T> newNode, int position, Boolean insertAtEnd) {
		if (headNode == null) {
			return null;
		}

		if (insertAtEnd) {
			LinkedListNode<T> curr = headNode;
			while (curr.next != null) {
				curr = curr.getNext();
			}
			curr.next = newNode;
		} else {
			int size = ListLength(headNode);
			if (position == 1) {
				newNode.setNext(headNode);
				return newNode;
			} else {
				LinkedListNode<T> curr = headNode;
				for (int i = 2; i < position; i++) {
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

	public LinkedListNode<T> deleteNode(LinkedListNode<T> headNode, int position) {
		if (headNode == null) {
			return null;
		}

		int size = ListLength(headNode);

		if (position > size || position < 1) {
			return headNode;
		}

		if (position == 1) {
			LinkedListNode<T> curr = headNode.getNext();
			headNode = null;
			return curr;
		} else {
			LinkedListNode<T> prev = headNode;
			for (int i = 1; i < position - 1; i++) {
				prev = prev.getNext();
			}
			LinkedListNode<T> curr = prev.getNext();
			prev.setNext(curr.getNext());
			curr = null;
		}
		return headNode;

	}
}
