package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import ds.Graph;

public class TestGraph {

	@Test
	public void testGraphInit() {
		int n = 100000;
		Graph g= new Graph(n);
		assertTrue(g.start.ListLength(g.start) == n);
	}

}
