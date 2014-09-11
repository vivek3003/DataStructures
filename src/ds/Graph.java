package ds;
/*
 * @author Vivek Kaarthek
 * A simple adjacency list.Graph stores inetger as labels and weights.(Directed Graph)
 */
public class Graph {
	
	public LinkedListNode<Vertex> start;
	class Vertex{
		int label;
		LinkedListNode<Edge> Edges;		
		public Vertex(int label){
			this.label = label;
		}
	}
	
	class Edge{
		int weight;
		LinkedListNode<Vertex> to;
	}
	
	/*
	 * Initialise a graph with n nodes.0 edges
	 */
	public Graph(int n){
		if(n<=0){
			return;
		}
		this.start = new LinkedListNode<Vertex>(new Vertex(1));
		
		LinkedListNode<Vertex> pointerThatMakesAllTheDifference = this.start;
		if(n>1)
		for (int i=2;i<=n;i++){
			start.insertNode(pointerThatMakesAllTheDifference,  new LinkedListNode<Vertex>(new Vertex(i)), 0, true);
			pointerThatMakesAllTheDifference = pointerThatMakesAllTheDifference.getNext();
		}
	}	
	
}
