package test;

import java.util.ArrayList;
import java.util.Random;

import csc373_a2.ArrayListMH;
import csc373_a2.Vertex;

public class HeapTest {
	
	public static String almhToString(ArrayListMH almh) {
		ArrayList<Vertex> mh = almh.getMh();
		String result = "";
		
		int s = mh.size();
		int j = s - 1;
		
		double h = Math.floor(Math.log10(s) / Math.log10(2)) + 1;
		
		int numSpace = new Double(Math.pow(2, h) - 1).intValue();
		
		Unit[] row = new Unit[numSpace];
		int i;
		for (i = 0; i < numSpace; i++) {
			row[i] = null;
		}
		
		int numNE = new Double(Math.pow(2, (h - 1))).intValue();
		int[] neIndex = new int[numNE];
		i = 0;
		while (i < numNE) {
			neIndex[i] = i * 2;
			i++;
		}
		
		int total = new Double(Math.pow(2, h) - 1).intValue();
		int numDummy = total - s;
		i = numNE - 1;
		while (numDummy > 0){
			row[neIndex[i]] = new Unit(0, false);
			i--;
			numDummy--;
		}
		while (i >= 0) {
			row[neIndex[i]] = new Unit(mh.get(j).getValue());
			j--;
			i--;
		}
		
		if (numNE > 1) {
			String thisRow = "";
			for (Unit u: row) {
				if (u == null) {
					thisRow += new Unit(0, false).toString();
				} else {
					thisRow += u.toString();
				}
			}
			thisRow += "\n";
			result = thisRow.concat(result);
			
			ArrayList<Integer> dynamicIndex = new ArrayList<>();
			for (int index : neIndex) {
				dynamicIndex.add(index);
			}
			while (dynamicIndex.size() / 2 != 1) {
				ArrayList<Integer> newAL = new ArrayList<>();
				i = 0;
				while (i * 2 < dynamicIndex.size()) {
					newAL.add((dynamicIndex.get(i * 2) + dynamicIndex.get(i * 2 + 1)) / 2);
					i++;
				}
				dynamicIndex = newAL;
				for (i = 0; i < numSpace; i++) {
					row[i] = null;
				}
				i = dynamicIndex.size() - 1;
				while (i >= 0) {
					row[dynamicIndex.get(i)] = new Unit(mh.get(j).getValue());
					j--;
					i--;
				}
				String currRow = "";
				for (Unit u: row) {
					if (u == null) {
						currRow += new Unit(0, false).toString();
					} else {
						currRow += u.toString();
					}
				}
				currRow += "\n";
				result = currRow.concat(result);
			}
			int firstIndex = (dynamicIndex.get(0) + dynamicIndex.get(1)) / 2;
			for (i = 0; i < numSpace; i++) {
				row[i] = null;
			}
			row[firstIndex] = new Unit(mh.get(0).getValue());
			
			
		} 
		String firstRow = "";
		for (Unit u: row) {
			if (u == null) {
				firstRow += new Unit(0, false).toString();
			} else {
				firstRow += u.toString();
			}
		}
		firstRow += "\n";
		result = firstRow.concat(result);
		
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayListMH almh = new ArrayListMH();
//		almh.insert(new Vertex(0));
//		almh.insert(new Vertex(299));
//		almh.insert(new Vertex(90));
		
//		for (int i = 0; i < 31; i++) {
//			almh.insert(new Vertex(i));
//		}
		
		Random rd = new Random();
		
		for (int i = 0; i < 7; i++) {
			double value = rd.nextInt(1000);
			almh.insert(new Vertex(value));
		}
		
		String result = HeapTest.almhToString(almh);
		System.out.println(result);
		
		System.out.println("====");
		System.out.println(almh.extractMin().getValue());
		System.out.println("====");
		
		String alteredResult = HeapTest.almhToString(almh);
		System.out.println(alteredResult);
		
		Vertex v = almh.getMh().get(almh.getMh().size() - 1);
		System.out.println("====");
		System.out.println(v.getValue());
		System.out.println("====");
		almh.decreaseKey(v, almh.getMh().get(0).getValue() - 1);
		System.out.println(HeapTest.almhToString(almh));

	}

}
