/*
 ** Name : Israel Kwawu
 ** Programming Lab: 2
 */

public class FooCorporation {
    private final double MINIMUM_WAGE = 8.00d;
    private final double MAXIMUM_HOUR =60.0d;
    private final double MINIMUM_HOUR = 40.0d;
    private final double OVERTIME_HOUR = 1.5d;
    private int hoursWorked;
    private  double basePay;


    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getBasePay() {
        return basePay;
    }

    public void setBasePay(double basePay) {
        this.basePay = basePay;
    }

    public void totalPay(double hoursWorked, double basePay){
        if (hoursWorked <= this.MAXIMUM_HOUR){
            double regularPay = 0.0d ;
            double overtimePay = 0.0d;
            double overtimeHour = 0.0d;
            double totalPay = 0.0d;
           if (basePay >= this.MINIMUM_WAGE){

               if(hoursWorked > this.MINIMUM_HOUR){

                   overtimeHour = hoursWorked % this.MINIMUM_HOUR;

                   for (int i=0; i < overtimeHour;i++){
                       overtimePay += (basePay * this.OVERTIME_HOUR);
                   }

                   regularPay = (hoursWorked - overtimeHour) * basePay;
                   totalPay = regularPay + overtimePay;

               }else {
                   regularPay = hoursWorked * basePay;
                   totalPay = regularPay + overtimePay;
               }

               System.out.println("Total pay for employee is $"+ totalPay);

           }else{
               System.out.println("Base pay is less than minimum wage, please revise.");
           }

        }else{
            System.out.println("The time ("+ hoursWorked +" hours) entered exceeds maximum allowed work hour (60) per week.");
        }

    }

    public static void main(String[] args) {
        FooCorporation employee1 = new FooCorporation();
        FooCorporation employee2 = new FooCorporation();
        FooCorporation employee3 = new FooCorporation();

        employee1.setBasePay(7.50);
        employee2.setBasePay(8.20);
        employee3.setBasePay(10.0);

        employee1.setHoursWorked(35);
        employee2.setHoursWorked(47);
        employee3.setHoursWorked(73);

        int emp1HoursWorked = employee1.getHoursWorked();
        double emp1BasePay= employee1.getBasePay();
        int emp2HoursWorked = employee2.getHoursWorked();
        double emp2BasePay= employee2.getBasePay();
        int emp3HoursWorked = employee3.getHoursWorked();
        double emp3BasePay= employee3.getBasePay();

        employee1.totalPay(emp1HoursWorked,emp1BasePay);
        employee2.totalPay(emp2HoursWorked,emp2BasePay);
        employee3.totalPay(emp3HoursWorked,emp3BasePay);



    }
}
