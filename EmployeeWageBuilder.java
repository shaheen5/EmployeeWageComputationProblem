package EmployeeWageProblem;

public class EmployeeWageBuilder {
	public static final int IS_PART_TIME=1;
	public static final int IS_FULL_TIME=2;
	
	public static void computeEmpWage(String company,int empRatePerHour,int numOfWorkingDays,int maxHoursPerMonth) {
		//variables
		int empWorkHours=0;
		int totalEmpWage=0,totalEmpWorkingHours=0,totalWorkingDays=0;
		//Computation
		while(totalEmpWorkingHours <= maxHoursPerMonth && totalWorkingDays < numOfWorkingDays) {
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
				totalEmpWage=totalEmpWorkingHours * empRatePerHour;
				System.out.println("Total Employee Wage for Company: "+company+" is: "+totalEmpWage);	
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Employee Wage Computation Program !");
		computeEmpWage("Dmart",20,20,100);
		computeEmpWage("Reliance",10,25,120);
		computeEmpWage("Samsung",15,20,80);
	}
}
