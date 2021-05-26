/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelexpenses;

import java.text.DecimalFormat;

/**
 *
 * @author Venkat Sai Jarugula
 */
public class RouteCalculator {
    private int routeNo;
    private int numpassengers;
    private boolean isMember;
    private boolean isFirstTimeUser;
    private boolean haveCoupon;
    private static final double Coupon = 5.00;
    private static final double salesTax = 7.50;
/**
 * Constructs RouteCalculator with the given routeNo, numpassengers, isMember,
 * isFirstTimeUser, haveCoupon
 * @param routeNo Route Number
 * @param numpassengers Number of passengers
 * @param isMember Does user have membership
 * @param isFirstTimeUser Is he first time user
 * @param haveCoupon Does user have a coupon
 */
    public RouteCalculator(int routeNo, int numpassengers, boolean isMember,
            boolean isFirstTimeUser, boolean haveCoupon) {
        this.routeNo = routeNo;
        this.numpassengers = numpassengers;
        this.isMember = isMember;
        this.isFirstTimeUser = isFirstTimeUser;
        this.haveCoupon = haveCoupon;
    }
/**
 * Returns the route number of the passenger
 * @return Returns the route number
 */
    public int getRouteNo() {
        return routeNo;
    }

    /**
     *Sets the route number of the passenger
     * @param routeNo The routeNo to set
     */
    public void setRouteNo(int routeNo) {
        this.routeNo = routeNo;
    }

    /**
     *Returns the number of passengers
     * @return Returns the number of passengers
     */
    public int getNumpassengers() {
        return numpassengers;
    }

    /**
     *Sets the number of passengers
     * @param numpassengers The numpassengers to set
     */
    public void setNumpassengers(int numpassengers) {
        this.numpassengers = numpassengers;
    }

    /**
     *Returns whether the passenger is a member or not
     * @return Returns whether the passenger is a member or not
     */
    public boolean isIsMember() {
        return isMember;
    }

    /**
     *Sets the isMember
     * @param isMember The isMember to set
     */
    public void setIsMember(boolean isMember) {
        this.isMember = isMember;
    }

    /**
     *Returns whether the passenger is a first time user or not
     * @return Returns whether the passenger is a first time user or not
     */
    public boolean isIsFirstTimeUser() {
        return isFirstTimeUser;
    }

    /**
     *Sets the isFirstTimeUser
     * @param isFirstTimeUser The isFirstTimeUser to set
     */
    public void setIsFirstTimeUser(boolean isFirstTimeUser) {
        this.isFirstTimeUser = isFirstTimeUser;
    }

    /**
     *Returns whether the passenger have a coupon or not
     * @return Returns whether the passenger have a coupon or not
     */
    public boolean isHaveCoupon() {
        return haveCoupon;
    }

    /**
     *Sets the haveCoupon
     * @param haveCoupon The haveCoupon to set
     */
    public void setHaveCoupon(boolean haveCoupon) {
        this.haveCoupon = haveCoupon;
    }

    /**
     *Returns the RouteCalculator object in string format
     * @return Returns the RouteCalculator object in string format
     */
    @Override
    public String toString() {
        return "User Route details:" + "\nrouteNo: " + routeNo 
                + ", numpassengers: " 
                + numpassengers + ", isMember: " + isMember 
                + ", isFirstTimeUser: " + isFirstTimeUser 
                + ", haveCoupon: " + haveCoupon  ;
    }
    /**
     * Calculates and returns the route price for the given route number
     * @return Returns the route price for the given route number
     */
    private double calcRoutePrice() {
        double price=0.0;
        if(routeNo==1){
            if(numpassengers==1){
                price=35;
            }
            else if(numpassengers==2){
                price=60;
            }
             else if(numpassengers>2){
                 price=numpassengers*26.50;
            }   
            }
        
        else if (routeNo==2){
            if(numpassengers==1){
                price=32.89;
            }
            else if(numpassengers==2){
                price=53.12;
            }
             else if(numpassengers>2){
                 price=numpassengers*24.20;
            }   
            
            
    }
        else if (routeNo==3){
            if(numpassengers==1){
                price=38;
            }
            else if(numpassengers==2){
                price=63.78;
            }
             else if(numpassengers>2){
                 price=numpassengers*28.78;
            }   
            
    }
        
        
        return price;
    }
    
    /**
     * Calculates and returns the membership discount
     * @return Returns the membership discount
     */
    private double calcMembershipDiscount(){
        double membershipDiscount=0.0;
        if(isMember){
            if(numpassengers==1){
                membershipDiscount=calcRoutePrice()*0.05;
            }
            else if(numpassengers==2){
                membershipDiscount=calcRoutePrice()*0.62;
            }
             else if(numpassengers>2){
                 membershipDiscount=calcRoutePrice()*0.08;
            }
            
            
        }
       
        return membershipDiscount;
    }
    /**
     * Calculates and returns the first time user discount 
     * @return Returns the first time user discount
     */
    private double calcFirstTimeUserDiscount(){
        double firstTimeUserDiscount=0.0;
        if(isFirstTimeUser){
           if(numpassengers==1){
                firstTimeUserDiscount=calcRoutePrice()*0.10;
            }
            else if(numpassengers==2){
                firstTimeUserDiscount=calcRoutePrice()*0.07;
            }
             else if(numpassengers>2){
                 firstTimeUserDiscount=calcRoutePrice()*0.04;
            } 
            
        
    }
        return firstTimeUserDiscount;
    }
    /**
     * Calculates and returns the coupon discount
     * @return Returns the coupon discount
     */
    private double calcCouponDiscount(){
        double couponDiscount = 0.0;
       if(haveCoupon){
           couponDiscount=calcRoutePrice()-Coupon;
       }
       return couponDiscount;
    }
    /**
     * Calculates and returns the total price
     * @return Returns the total price
     */
    private double totalPrice() {
        return calcRoutePrice()-(calcMembershipDiscount()+calcFirstTimeUserDiscount()+Coupon);
    }
    /**
     * Calculates and returns the total price with sales tax
     * @return Returns the total price with sales tax
     */
    private double totalPriceWithSalesTax(){
        double totalPriceWithTax = Math.round((totalPrice()+(totalPrice()*(salesTax/100)))*100)/100.0;
        return totalPriceWithTax;
    }
    
    /**
     *Prints the receipt
     * @return Returns the receipt with complete details
     */
    public String printReceipt(){
       String  receipt=" Receipt "+ 
    "\nTravel Charges for "+ numpassengers +" passengers on route "
               + routeNo +": $" +calcRoutePrice()+
    "\nMembership Discount: $"+calcMembershipDiscount()+
    "\nFirst Time user discount: $"+calcFirstTimeUserDiscount()+
    "\nCoupon Discount: $"+calcCouponDiscount()+
    "\nCharges After applying Discount: $"+totalPrice()+
    "\nTotal Price with Tax: $"+totalPriceWithSalesTax();
    return receipt;
    } 
}
