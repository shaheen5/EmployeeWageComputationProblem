package EmployeeWageProblem;

public class EmployeeWageBuilder {
	public static final int IS_PART_TIME=1;
	public static final int IS_FULL_TIME=2;
	public static final int EMP_RATE_PER_HOUR=20;
	public static final int NUM_OF_WORKING_DAYS=20;
	public static final int MAX_HRS_IN_MONTH=100;
	
	public static void computeEmpWage() {
		//variables
				int empWorkHours=0;
				int totalEmpWage=0,totalEmpWorkingHours=0,totalWorkingDays=0;
				//Computation
				while(totalEmpWorkingHours <= MAX_HRS_IN_MONTH && totalWorkingDays < NUM_OF_WORKING_DAYS) {
					totalWorkingDays++;
					int empCheck=(int)Math.floor(Math.random()*10)%3;
					switch (empCheck) {
						case IS_PART_TIME: empWorkHours=4;
											break;
						case IS_FULL_TIME: empWorkHours=8;
											break;
						default : empWorkHours=0;
									break;
					}
					totalEmpWorkingHours += empWorkHours;
					System.out.println("Day#:"+totalWorkingDays + "  Employee Work Hours:"+empWorkHours);	
				}
				totalEmpWage=totalEmpWorkingHours * EMP_RATE_PER_HOUR;
				System.out.println("Total Employee Wage :- "+totalEmpWage);	
			}

	public static void main(String[] args) {
		System.out.println("Welcome to Employee Wage Computation Program !");
		computeEmpWage();
	}
}
