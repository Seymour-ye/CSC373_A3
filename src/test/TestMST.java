package test;

import csc373_a2.CircleMST;
import csc373_a2.RandomMST;

public class TestMST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		
//		double result = RandomMST.getSize(50000);
		double result = CircleMST.getSize(50000);
		System.out.println(result);
		
		long end = System.currentTimeMillis();
		double elapsed = (end - start) / 1000.0;
		System.out.println(elapsed);
	}

}
