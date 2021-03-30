package EmployeeWageProblem;

public class EmployeeWageBuilder {

	public static void main(String[] args) {
		System.out.println("Welcome to Employee Wage Computation Program !");
		//Constants
		int IS_FULL_TIME=1;
		int EMP_RATE_PER_HOUR=20;
		//variables
		int empWorkHours=0;
		int empWage=0;
		//Computation
		double empCheck=Math.floor(Math.random()*10)%2;
		if (empCheck == IS_FULL_TIME)
			empWorkHours=8;
		else
			empWorkHours=0;
		empWage=empWorkHours * EMP_RATE_PER_HOUR;
		System.out.println("Employee Wage :- "+empWage);
		
	}

}
