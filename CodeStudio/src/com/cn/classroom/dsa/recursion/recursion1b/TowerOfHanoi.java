package com.cn.classroom.dsa.recursion.recursion1b;

public class TowerOfHanoi {

	public static void towerOfHanoi(int disks, char source, char auxiliary, char destination) {
		if(disks == 1) {
			System.out.println("Move 1st disk from "+ source + " to " + destination);
			return;
		}
		
		// Move disks -1 from source to auxiliary using destination
		towerOfHanoi(disks -1 , source,  destination, auxiliary);
		
		//Move the largest disk from source to destination
		System.out.println("Move "+ disks +"th disk from "+ source + " to " + destination);
		
		// Move disks -1 auxiliary  to destination using source
		towerOfHanoi(disks -1 , auxiliary,  source, destination);

	}
	
}
