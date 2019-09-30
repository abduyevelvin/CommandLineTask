package com.order.task.util;

public class CheckPassword {

	public static boolean checkPass(String password) {
		if(!password.equals("admin")) {
			return false;
		}
		
		return true;
	}
}
