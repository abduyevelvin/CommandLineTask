package com.order.task.util;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShowRoleChoice {
	
	@Autowired
	private ShowAdminMenu showAdminMenu;
	@Autowired
	private ShowUserMenu showUserMenu;

	int count = 1;
	
	public void roleChoice() {

		/*
		 * @SuppressWarnings("resource") AnnotationConfigApplicationContext ctx = new
		 * AnnotationConfigApplicationContext(ApplicationConfig.class);
		 * 
		 * ShowAdminMenu showAdminMenu = ctx.getBean(ShowAdminMenu.class); ShowUserMenu
		 * showUserMenu = ctx.getBean(ShowUserMenu.class);
		 */
		Scanner sc = new Scanner(System.in);
		// boolean exit = false;
		
		try {
			
			System.out.println("Please choose your role: \n1. Admin \n2. User \n3. Exit");
			int choice = sc.nextInt();
			
			switch (choice) {
			case 1:
				sc.nextLine();
				System.out.print("Please enter your paswword: ");
				String pass = sc.nextLine();

				if (CheckPassword.checkPass(pass)) {
					showAdminMenu.showMenu();
				} else {
					while(count != 3) {
						System.out.println("Password is wrong! Try again! Last " + (3 - count) + " chance!");
						count++;
						roleChoice();
					}
					System.out.println("You have entered 3 times wrong password!");
					System.exit(0);
				}
				break;
			case 2:
				System.out.println("Dear user, welcome to our lunch ordering system!");
				showUserMenu.showMenu();
				break;
			case 3:
				System.out.println("Thanks for using our system! See you again...");
				System.exit(0);
				break;
			default:
				System.out.println("Please choose rigth user from the list!");
				roleChoice();
				break;
			}
		} catch (Exception e) {
			sc.close();
			e.printStackTrace();
		}

	}
}
