package com;

import java.util.Set;

public class Utility {
	
	
	public static void populateAll(Set set){
		for(int i=0;i<9;i++){
			set.add(String.valueOf(i));
		}//for
	}
}
