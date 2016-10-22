package csc373_a2;

public class RandomMST {
	
	public static double getSize(int numVertex) {
		double result = 0;
		ArrayListMH almh = new ArrayListMH();
		for (int i = 0; i < numVertex; i++) {
			double value = Math.random();
			almh.insert(new Vertex(value));
		}
		
		int s = almh.getMh().size();
		while (s != 0) {
			result += almh.extractMin().getValue();
			for (Vertex v : almh.getMh()) {
				double newVal = Math.random();
				if (newVal < v.getValue()) {
					almh.decreaseKey(v, newVal);
				}
			}
			s = almh.getMh().size();
		}
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numV = Integer.parseInt(args[0]);
		double result = RandomMST.getSize(numV);
		System.out.println(result);

	}

}
