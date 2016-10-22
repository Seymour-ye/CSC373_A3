package csc373_a2;

public interface MinHeap {

	public void insert(Vertex v);
	public Vertex extractMin();
	public void decreaseKey(Vertex v, double value);
}
