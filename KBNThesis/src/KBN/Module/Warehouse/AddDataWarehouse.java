package KBN.Module.Warehouse;

import java.util.ArrayList;

public class AddDataWarehouse {
	
	private static ArrayList arrData = new ArrayList<>();
	
	public void addArrayList(ArrayList arr) {
		this.arrData.addAll(arr);

//		Debugger
//		for(int i = 0; i < arrData.size(); i++) {
//			System.out.println(arrData.get(i));
//		}
	}
	
	public ArrayList getData() {
		return this.arrData;
	}
	
	public void clearData() {
		arrData.clear();
	}
}
