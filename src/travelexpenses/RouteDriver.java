/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelexpenses;

import java.util.Scanner;

/**
 *
 * @author Venkat Sai Jarugula
 */
public class RouteDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter User Details:");
        System.out.print("Select the routes from 1,2 and 3: "); 
        int routeNo=scanner.nextInt();
        System.out.print("How many number of passengers: ");
        int numpassengers=scanner.nextInt();
        System.out.print("Are you a member: ");
        boolean isMember=scanner.nextBoolean();
        System.out.print("Are you a first time user: ");
        boolean isFirstTimeUser=scanner.nextBoolean();
        System.out.print("Do you have coupon: ");
        boolean haveCoupon=scanner.nextBoolean();
        if((routeNo!=1 && routeNo!=2 && routeNo!=3) || (numpassengers==0) || 
                (isMember && isFirstTimeUser)){
            System.out.println("\n*******************************\n");
            if(routeNo!=1 && routeNo!=2 && routeNo!=3){
            System.out.println("Route number should be 1 or 2 or 3");
            }
            if(numpassengers==0){
                System.out.println("Passenger number can't be zero.");
            }
            if(isMember && isFirstTimeUser ){
            System.out.println("User cannot be a member and first time user "
                    + "at a time.");
            }
            System.out.println("Please try again.");
        }
        else{
            RouteCalculator routeCalculator = new RouteCalculator( routeNo, 
                    numpassengers, isMember, isFirstTimeUser, haveCoupon);
            System.out.println("\n*******************************\n");

            System.out.println(routeCalculator.toString());

            System.out.println("\n*******************************\n");
            System.out.println(routeCalculator.printReceipt());
            
        }
        
        

    }
    
}
