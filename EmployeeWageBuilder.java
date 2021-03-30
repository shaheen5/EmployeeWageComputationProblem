package EmployeeWageProblem;

public class EmployeeWageBuilder {
	public static final int IS_PART_TIME=1;
	public static final int IS_FULL_TIME=2;
	public static final int EMP_RATE_PER_HOUR=20;
	public static final int NUM_OF_WORKING_DAYS=20;

	public static void main(String[] args) {
		System.out.println("Welcome to Employee Wage Computation Program !");
		//variables
		int empWorkHours=0;
		int empWage=0,totalEmpWage=0;
		//Computation
		for (int day=1; day<=NUM_OF_WORKING_DAYS; day++) {
			int empCheck=(int)Math.floor(Math.random()*10)%3;
			switch (empCheck) {
				case IS_PART_TIME: empWorkHours=4;
									break;
				case IS_FULL_TIME: empWorkHours=8;
									break;
				default : empWorkHours=0;
							break;
			}
			empWage=empWorkHours * EMP_RATE_PER_HOUR;
			totalEmpWage=totalEmpWage+empWage;
			System.out.println("Employee Wage Day"+day+" :- "+empWage);
		}
		
		System.out.println("Total Employee Wage :- "+totalEmpWage);	
	}

}
