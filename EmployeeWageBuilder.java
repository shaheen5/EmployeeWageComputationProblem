package EmployeeWageProblem;
import java.util.ArrayList;
import java.util.HashMap;

  interface IComputeEmpWage{
	   public void addCompanyEmpWage(String company,int empRatePerHour,int numOfWorkingDays,int maxHoursPerMonth);
	   public void computeEmpWage();
	   public int getTotalWage(String company);
  }

  class CompanyEmployeeWage {
	   public  final String company ;
	   public  final int empRatePerHour;
	   public  final int numOfWorkingDays;
	   public  final int maxHoursPerMonth;
	   public int totalEmpWage;
	   public int dailyWage;

	   public CompanyEmployeeWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {
		   this.company = company;
		   this.empRatePerHour = empRatePerHour;
		   this.numOfWorkingDays = numOfWorkingDays;
		   this.maxHoursPerMonth = maxHoursPerMonth;
	   }

	   public void setTotalEmpWage(int totalEmpWage) {
		   this.totalEmpWage=totalEmpWage;
	   }
	  
       public void setDailyWage(int dailyWage) {
    	   this.dailyWage = dailyWage;
       }

	@Override
	   public String toString() {
		   return "Total Employee Wage for Company "+company+" is: "+totalEmpWage+"\n";
	   }
  }

  public class EmployeeWageBuilder implements IComputeEmpWage {
  	   public static final int IS_PART_TIME=1;
       public static final int IS_FULL_TIME=2;
	   private ArrayList<CompanyEmployeeWage> companyEmpWageList;
	   private HashMap<String,CompanyEmployeeWage> companyToEmpWageMap;

       public EmployeeWageBuilder() {
		 companyEmpWageList = new ArrayList<>();
		 companyToEmpWageMap=new HashMap<>();
       }
       //create objects of companyEmpWage and add it in list and map
	   public void addCompanyEmpWage(String company,int empRatePerHour,int numOfWorkingDays,int maxHoursPerMonth) {
		 CompanyEmployeeWage companyEmpWage=new CompanyEmployeeWage(company,empRatePerHour,numOfWorkingDays,maxHoursPerMonth);
		 companyEmpWageList.add(companyEmpWage);
		 companyToEmpWageMap.put(company, companyEmpWage);
	   }
	   
	   public void computeEmpWage() {
		 for (int i=0;i < companyEmpWageList.size(); i++) {
			 CompanyEmployeeWage companyEmpWage=companyEmpWageList.get(i);
		     companyEmpWage.setTotalEmpWage(this.computeEmpWage(companyEmpWage));
			 System.out.println(companyEmpWage);
		 }
	   }
	   
	   //compute employee wage of company
	   private int computeEmpWage(CompanyEmployeeWage companyEmpWage) {
		 //variables
		 int empWorkHours=0,totalEmpWorkingHours=0,totalWorkingDays=0,dailyWage=0;
		 //Computation
	   	 while(totalEmpWorkingHours <= companyEmpWage.maxHoursPerMonth && totalWorkingDays < companyEmpWage.numOfWorkingDays) {
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
	   	 dailyWage=empWorkHours*companyEmpWage.empRatePerHour;
		 System.out.println("Day#:"+totalWorkingDays + "  Employee Work Hours:"+empWorkHours+"  Daily Wage :"+dailyWage);	
		 }
		 return totalEmpWorkingHours * companyEmpWage.empRatePerHour;	
	   }
	   
	   //ability to get total wage by company name
	   public int getTotalWage(String company) {
			return companyToEmpWageMap.get(company).totalEmpWage;
		}
	   public static void main(String[] args) {
		 System.out.println("Welcome to Employee Wage Computation Program !");
		 IComputeEmpWage empWageBuilder=new EmployeeWageBuilder();
		 empWageBuilder.addCompanyEmpWage("Dmart",20,20,100);
		 empWageBuilder.addCompanyEmpWage("Reliance",10,25,120);
		 empWageBuilder.addCompanyEmpWage("Samsung",15,20,80);
		 empWageBuilder.computeEmpWage();
		 System.out.println("Total Wage for Dmart Company:-"+empWageBuilder.getTotalWage("Dmart"));
		 System.out.println("Total Wage for Reliance Company:-"+empWageBuilder.getTotalWage("Reliance"));
		 System.out.println("Total Wage for Samsung Company:-"+empWageBuilder.getTotalWage("Samsung"));
       }
   }
