package csc373_a2;

import java.util.ArrayList;

public class ArrayListMH implements MinHeap {
	
	private ArrayList<Vertex> mh;
	
	private void minHeapify(int index) {
		while (index > 0) {
			int parentIndex;
			if (index % 2 == 0) {
				parentIndex = index / 2 - 1;
			} else {
				parentIndex = (index - 1) / 2;
			}
			
			Vertex parent = mh.get(parentIndex);
			double parentValue = parent.getValue();
			Vertex curr = mh.get(index);
			double currValue = curr.getValue();
			if (currValue < parentValue) {
				curr.setValue(parentValue);
				parent.setValue(currValue);
				index = parentIndex;
			} else {
				break;
			}
		}
	}

	public ArrayListMH() {
		// TODO Auto-generated constructor stub
		mh = new ArrayList<>();
	}
	
	public ArrayListMH(int initialCapacity) {
		// TODO Auto-generated constructor stub
		mh = new ArrayList<>(initialCapacity);
	}

	@Override
	public void insert(Vertex v) {
		// TODO Auto-generated method stub
		mh.add(v);
		this.minHeapify(mh.size() - 1);
	}

	@Override
	public Vertex extractMin() {
		// TODO Auto-generated method stub
		Vertex min = mh.remove(0);
		
		if (mh.size() == 0) {
			return min;
		}
		
		mh.add(0, mh.remove(mh.size() - 1));
		
		int i = 0;
		int s = mh.size();
		while (i < s) {
			Vertex curr = mh.get(i);
			double currValue = curr.getValue();
			
			int leftIndex = i * 2 + 1;
			if (leftIndex >= s) {
				break;
			}
			Vertex leftChild = mh.get(leftIndex);
			double leftValue = leftChild.getValue();
			
			Vertex smallest;
			if (leftValue < currValue) {
				smallest = leftChild;
			} else {
				smallest = curr;
			}
			
			int rightIndex = (i + 1) * 2;
			if (rightIndex < s) {
				Vertex rightChild = mh.get(rightIndex);
				double rightValue = rightChild.getValue();
				
				if (rightValue < smallest.getValue()) {
					curr.setValue(rightValue);
					rightChild.setValue(currValue);
					i = rightIndex;
					continue;
				}
			}
			
			if (smallest == curr) {
				break;
			} else {
				curr.setValue(leftValue);
				leftChild.setValue(currValue);
				i = leftIndex;
			} 
		}
		
		return min;
	}

	@Override
	public void decreaseKey(Vertex v, double value) {
		// TODO Auto-generated method stub
		v.setValue(value);
		this.minHeapify(mh.indexOf(v));
		
	}

	public ArrayList<Vertex> getMh() {
		//TODO For testing only, shall be deleted in the end
		return mh;
	}

}
