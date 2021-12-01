
import java.text.SimpleDateFormat;
import java.util.*;

public class VendingMachine {
    static double totalAmount,inputAmount,balanceAmount;
    static int ledgerSNo=0;
    static String[][] itemDetails;
    static List<Object> ledger = new ArrayList<>();
    static Map<Integer,Object> displayLedger =new HashMap<>();


    //static List<Object> ledger = new ArrayList<>(Arrays.asList("S.No\t\tDate\t\tItem ID\t\tItem Name\t\tItem Value\t\tAmount Entered" +
          //  "\t\tBalance returned\\ttAmount in machine\t\t"));


    public static void main(String[] args) {

        itemDetails = new String[][]{{"0","Cancel", "0"}, {"1","Kitkat", "10"}, {"2", "Gems","5"}, {"3","Soda", "20"}, {"4", "Lays", "6"}};

        System.out.println("WELCOME !! Please choose from below items :");
        System.out.println(itemDetails[0][0] + ":  " + itemDetails[0][1]);
        System.out.println(itemDetails[1][0] + ":  " + itemDetails[1][1] + "\t Rs " + itemDetails[1][2]);
        System.out.println(itemDetails[2][0] + ":  " + itemDetails[2][1] + "\t Rs " + itemDetails[2][2]);
        System.out.println(itemDetails[3][0] + ":  " + itemDetails[3][1] + "\tRs " + itemDetails[3][2]);
        System.out.println(itemDetails[4][0] + ":  " + itemDetails[4][1] + "\tRs " + itemDetails[4][2]);


        int itemId;
        char flag,ledgerFlag;
        Scanner sc = new Scanner(System.in);

        do {

            System.out.println("Please enter Item ID ");
            itemId = sc.nextInt();


            if (itemId >= 0 && itemId <=4) {

                vendingMachinePayment(Integer.parseInt(itemDetails[itemId][0]), Double.parseDouble(itemDetails[itemId][2]),itemDetails[itemId][1]);

            } else {

                System.out.println("Please enter Valid input item");

            }
            System.out.println("Do you still want more items. Press 'Y' to Continue and 'N' to exit");
            flag= sc.next().charAt(0);


        }while(flag=='Y'||flag=='y');


        System.out.println("Total Amount in vending machine = "+totalAmount);

        System.out.println("Do you wish to see the previous transaction details/ ledger");
        ledgerFlag= sc.next().charAt(0);

        if (ledgerFlag=='y'||ledgerFlag=='Y'){

//using for loop

            System.out.println("Using For Loop\n ");
            for(Map.Entry e : displayLedger.entrySet()){
                System.out.println(e.getKey()+ "  " +e.getValue());
            }

        }


    }

     static void vendingMachinePayment(int itemId, double itemValue, String itemName){
         inputAmount = 0;
         if (itemId > 0) {
             System.out.println("Enter Amount");
             Scanner sc = new Scanner(System.in);
             inputAmount = sc.nextDouble();
         }

         switch (itemId) {

             case 0:
                 System.out.println("Thank you! Please collect your money back");
                 break;

             default:

                 if (inputAmount >= itemValue) {
                     balanceAmount = inputAmount - itemValue;
                     totalAmount = totalAmount + balanceAmount;
                     System.out.println("Balance :" + balanceAmount);

                     String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());


                     ++ledgerSNo;

                     ledger = Arrays.asList(timeStamp, itemId, itemName, itemValue, inputAmount, balanceAmount, totalAmount);

                     displayLedger.put(ledgerSNo,ledger);

                 } else {
                     System.out.println("Insufficient Balance");
                 }

                 break;


         }

     }


}
