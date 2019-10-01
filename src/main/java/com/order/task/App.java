package com.order.task;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.order.task.config.ApplicationConfig;
import com.order.task.util.ShowRoleChoice;

public class App {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource") 
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		ShowRoleChoice showRoleChoice = ctx.getBean(ShowRoleChoice.class);

		showRoleChoice.loadData();
		showRoleChoice.roleChoice();
	}
}
