import java.util.Scanner;
import java.util.SortedMap;

public class VendingMachine {
   static double totalAmount;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char flag;
        System.out.println("WELCOME !! Please choose from below items :");
        System.out.println("0:  Cancel");
        System.out.println("1:  Kitkat\tRs 10 ");
        System.out.println("2:  Gems\tRs 5 ");
        System.out.println("3:  Soda\tRs 20 ");
        System.out.println("4:  Lays\tRs 6 ");
        do {

            System.out.println("Kindly enter the item ");

            int itemId = sc.nextInt();
            double inputAmount = 0;
            //valid input item id check
            if (itemId < 0 || itemId > 5) {
                System.out.println("Please enter Valid input item");

            } else {
                if (itemId > 0) {
                    System.out.println("Enter Amount");
                    inputAmount = sc.nextDouble();
                }
                payment(itemId, inputAmount);


            }
            System.out.println("Do you still want more items. Press 'Y' to Continue and 'N' to exit");
            flag= sc.next().charAt(0);
        }while(flag=='Y'||flag=='y');

        System.out.println("Total Amount in vending machine = "+totalAmount);
    }

    static void payment(int itemId,double inputAmount ){
                double balanceAmount;
            switch (itemId){

                case 0:
                    System.out.println("Thank you! Please collect your money back");
                    break;
                case 1:
                    if (inputAmount>=10){
                        balanceAmount = inputAmount -10;
                        totalAmount = totalAmount+balanceAmount;
                        System.out.println("Balance :"+balanceAmount);
                    }
                    else {
                        System.out.println("Insufficient Balance");
                    }
                    break;
                case 2:
                    if (inputAmount>=5){
                        balanceAmount = inputAmount -5;
                        totalAmount = totalAmount+balanceAmount;
                        System.out.println("Balance :"+balanceAmount);
                    }
                    else {
                        System.out.println("Insufficient Balance");
                    }
                    break;
                case 3:
                    if (inputAmount>=20){
                        balanceAmount = inputAmount -20;
                        totalAmount = totalAmount+balanceAmount;
                        System.out.println("Balance :"+balanceAmount);
                    }
                    else {
                        System.out.println("Insufficient Balance");
                    }
                    break;
                case 4:
                    if (inputAmount>=6){
                        balanceAmount = inputAmount -6;
                        totalAmount = totalAmount+balanceAmount;
                        System.out.println("Balance :"+balanceAmount);
                    }
                    else {
                        System.out.println("Insufficient Balance");
                    }
                    break;
            }
    }

}
