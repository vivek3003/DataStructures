package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ds.LinkedListNode;

public class TestLL {
	protected LinkedListNode<Integer> test;

	@Before
	public void setUp() {
		test = new LinkedListNode<Integer>(1);
		for (int i = 2; i <= 10; i++) {
			test.insertNode(test, new LinkedListNode<Integer>(i), i, false);
		}
	}

	@Test
	public void testLLNode() {
		LinkedListNode<Integer> start = new LinkedListNode<Integer>(5);
		assertTrue(5 == (Integer)start.getData());
	}

	@Test
	public void testLLsetData() {
		LinkedListNode<Integer> start = new LinkedListNode<Integer>(5);
		start.setData(6);
		assertTrue(6 == (Integer)start.getData());
	}

	@Test
	public void testLLListLength() {
		LinkedListNode<Integer> start = new LinkedListNode<Integer>(5);
		assertTrue(10 == start.ListLength(test));
	}

	@Test
	public void testLLInsert() {
		LinkedListNode<Integer> start = new LinkedListNode<Integer>(5);

		// Insert at beginning
		start = start.insertNode(start, new LinkedListNode<Integer>(4), 1, false);
		assertTrue(4 == (Integer)start.getData());

		// Insert at End
		start = start.insertNode(start, new LinkedListNode<Integer>(7), 0, true);
		assertTrue(3 == (Integer)start.ListLength(start));

		// insert middle
		start = start.insertNode(start, new LinkedListNode<Integer>(6), 3, false);
		assertTrue(6 == (Integer) start.getNext().getNext().getData());

	}

	@Test
	public void testLLDelete() {
		// Delete beginning
		test = test.deleteNode(test, 1);
		assertTrue(2 == (Integer) test.getData());

		// Delete end
		test = test.deleteNode(test, test.ListLength(test));
		assertTrue(8 == test.ListLength(test));

		test = test.deleteNode(test, 5);
		assertTrue(7 == test.ListLength(test));
	}
	
	@Test
	public void testLLPointer() {
		
		
		LinkedListNode<Integer> start = test;
		assertTrue("Should be equal:",start.equals(test));
		
		test = test.deleteNode(test, 5);
		assertTrue("Should still be equal",start.equals(test));
		
		test = test.deleteNode(test, 1);
		assertFalse("Should not be equal",start.equals(test));
		
		assertNotNull("Not null",start);
		
		assertNotNull("Should not be null",start.getNext());
		
		assertEquals("Length should be 9",9,start.ListLength(start));
		
		assertEquals("Length should be 8",8,test.ListLength(test));
	}

}
