package EmployeeWageProblem;

public class EmployeeWageBuilder {
	public static final int IS_PART_TIME=1;
	public static final int IS_FULL_TIME=2;
	private  final String company ;
	private  final int empRatePerHour;
	private  final int numOfWorkingDays;
	private  final int maxHoursPerMonth;
	private int totalEmpWage;
	
	public EmployeeWageBuilder(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth){
		this.company = company;
		this.empRatePerHour = empRatePerHour;
		this.numOfWorkingDays = numOfWorkingDays;
		this.maxHoursPerMonth = maxHoursPerMonth;
	}

	public void computeEmpWage() {
		//variables
		int empWorkHours=0,totalEmpWorkingHours=0,totalWorkingDays=0;
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
	}
	
	@Override
	public String toString() {
		return "Total Employee Wage for company :"+company+" is: "+totalEmpWage;
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Employee Wage Computation Program !");
		EmployeeWageBuilder	dmart=new EmployeeWageBuilder("Dmart",20,20,100);
		dmart.computeEmpWage();
		System.out.println(dmart);
		EmployeeWageBuilder	reliance=new EmployeeWageBuilder("Reliance",10,25,120);
		reliance.computeEmpWage();
		System.out.println(reliance);
		EmployeeWageBuilder	samsung=new EmployeeWageBuilder("Samsung",15,20,80);
		samsung.computeEmpWage();
		System.out.println(samsung);
	}
}
