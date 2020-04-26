import java.util.Scanner;
public class Time {

   public static void main(String[] args) 
   
   {
       Scanner sc = new Scanner(System.in);
       System.out.println("****************************************************");
       System.out.println("\tWelcome to Time Converted Program");
       System.out.println("****************************************************");
      
       int totalSeconds;
       System.out.print("Please Enter the seconds Which will be conerted:");
       totalSeconds = sc.nextInt();
       int hours,minutes,seconds;
       seconds = totalSeconds%60;
       minutes = totalSeconds/60;
       hours = minutes/60;
       minutes = minutes%60;
       System.out.printf("The corresponding hours, minutes, seconds is %d hrs, %d mins, %d secs",hours,minutes,seconds);
       System.out.println();
       if((hours>=0 && hours<=23)||(hours==24 && minutes==0 && seconds==0)) {
           System.out.print("The valid time is:");
           
           if(hours>=10) {
               System.out.print(hours);
           }
           else {
               System.out.print("0"+hours);
           }
           System.out.print(":");
           if(minutes>=10) {
               System.out.print(minutes);
           }
           else {
               System.out.print("0"+minutes);
           }
           System.out.print(":");
           if(seconds>=10) {
               System.out.print(seconds);
           }
           else {
               System.out.print("0"+seconds);
           }
           System.out.println();
       }
       else {
           System.out.println("There is no valid time of your input.");
           String number1 = Integer.toString(totalSeconds);
           int n = number1.length();
           String number = number1.substring(n-1,n)+number1.substring(1, n-1)+number1.substring(0,1);
           totalSeconds = Integer.valueOf(number);
           System.out.println("The swapped sequence of the input time is:"+totalSeconds);
           seconds = totalSeconds%60;
           minutes = totalSeconds/60;
           hours = minutes/60;
           minutes = minutes%60;
           System.out.printf("The corresponding hours, minutes, seconds is %d hrs, %d mins, %d secs",hours,minutes,seconds);
           System.out.println();
       }
       System.out.println("Thank you for using the time converter program!");
   }

}