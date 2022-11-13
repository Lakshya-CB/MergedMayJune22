package Lec_HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class HashMap_demo {
	public static void main(String[] args) {
		HashMap<String, Integer> HM = new HashMap<>();

//		O(1)
		HM.put("A", 10);
		HM.put("B", 15);
		HM.put("C", 11);
		HM.put("CC1", 10);
		HM.put("A2", 20);
		System.out.println(HM);
		HM.put("A2", 21);
		System.out.println(HM);
		HM.put("bachha", null);
		System.out.println(HM);
		
		System.out.println(HM.get("bachha"));
		System.out.println(HM.get("A20"));
		
//		O(1)
		System.out.println(HM.containsKey("bachha"));
		System.out.println(HM.containsKey("A20"));
		
		HM.remove("bachha");
		System.out.println(HM);
		
		
		HM.remove("goli mar dunga");
		System.out.println(HM);
		
		System.out.println(HM.size());
		
//		
		System.out.println("===========");
		System.out.println(HM.keySet());
		Set<String> keys = HM.keySet();
		
		
		System.out.println(keys);
		ArrayList<String> AL = new ArrayList<String>(keys);
		System.out.println(AL);
		
		for(String key : HM.keySet()) {
			System.out.println(key +" => "+HM.get(key) );
		}
		
		
		
	}
}
