package com.HKinneyDev.payback;

import java.util.HashMap;
import java.util.Map;

public class Expense {
	User        		owner;
	Map<User, Double> 	amountDueByUser = new HashMap<User, Double>();
	
	public Expense(double [] amountDue, User [] involvedUsers, User owner) {
		this.owner = owner;
		createHashMap(involvedUsers, amountDue);
	}
	
	private void createHashMap(User[] involvedUsers, double[] amountDue) {
		for(int i = 0; i < involvedUsers.length; i++) {
			amountDueByUser.put(involvedUsers[ i ], amountDue[ i ]);
		}
	}
	
	public double amountDueToOwner() {
		double total = 0;
		for (double d : amountDueByUser.values()) {
		    total += d;
		}
		return total;
	}
	
	public void userPaid(User payingUser, double amount) {
		amountDueByUser.put(payingUser, amountDueByUser.get(payingUser) - amount);
	}
	
	public double amountDueByUser(User queryingUser) {
		return amountDueByUser.get(queryingUser);
	}
}
