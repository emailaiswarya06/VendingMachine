

import java.util.Scanner;

public class VendingMachine {
   static double totalAmount;

    static int itemValue1 = 10;
    static int itemValue2 = 5;
    static int itemValue3 = 20;
    static int itemValue4 = 6;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char flag;

        int itemValue=0;

        System.out.println("WELCOME !! Please choose from below items :");
        System.out.println("0:  Cancel");
        System.out.println("1:  Kitkat\t Rs "+itemValue1);
        System.out.println("2:  Gems\t Rs "+itemValue2);
        System.out.println("3:  Soda\tRs "+itemValue3);
        System.out.println("4:  Lays\tRs "+itemValue4);


        do {

            System.out.println("Kindly enter the item ");
            int itemId = sc.nextInt();

            switch (itemId){

                case 0:
                    break;

                case 1:
                    itemValue = itemValue1;
                    break;
                case 2:
                    itemValue = itemValue2;
                    break;
                case 3:
                    itemValue = itemValue3;
                    break;
                case 4:
                    itemValue = itemValue4;
                    break;

            }


            double inputAmount = 0;
            //valid input item id check
            if (itemId < 0 || itemId > 4) {
                System.out.println("Please enter Valid input item");

            } else {
                if (itemId > 0) {
                    System.out.println("Enter Amount");
                    inputAmount = sc.nextDouble();
                }
                payment(itemId, itemValue,inputAmount);

            }
            System.out.println("Do you still want more items. Press 'Y' to Continue and 'N' to exit");
            flag= sc.next().charAt(0);
        }while(flag=='Y'||flag=='y');

        System.out.println("Total Amount in vending machine = "+totalAmount);
    }

    static void payment(int itemId,int itemValue,double inputAmount ){
                double balanceAmount;

                switch (itemId){

                    case 0:
                        System.out.println("Thank you! Please collect your money back");
                        break;

                    default:
                        if (itemId<5){


                            if (inputAmount>=itemValue){
                                balanceAmount = inputAmount -itemValue;
                                totalAmount = totalAmount+balanceAmount;
                                System.out.println("Balance :"+balanceAmount);
                            }
                            else {
                                System.out.println("Insufficient Balance");
                            }

                        }
                        else {

                            System.out.println("Please enter a valid input.");
                        }

                        break;

                }

    }

}
