package driver;

import exception.MismatchException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) throws MismatchException {
        String greeting ="-------------\n"+" 1: Get Customer Details "+"\n"+
                " 2: Modify Customer Details "+"\n" +
                " 3: Generate Customer Bill "+"\n"+
                " 4: Display Transaction between Dates "+"\n"+
                " 5: Get Transactions by ZipCode "+"\n"+
                " 6: Get Number and Total Transactions by Type "+"\n"+
                " 7: Get Number and Total Transactions by State "+"\n"+
                " 8: EXIT"+"\n"+
                "-------------\n";

        System.out.println("Starting Application");
        //System.out.println(greeting);

        Scanner scan = new Scanner(System.in);
        boolean exit = false;
        try{
        while(!exit){
            System.out.println(greeting);
            System.out.println("Please Enter Number for Option");
            int input =scan.nextInt();
            if(input<1|| input>8)throw new InputMismatchException("NOT VALID INPUT");
            switch (input) {
                case 1:
                    CustomerDriver.getCustDetails();
                    break;
                case 2:
                    CustomerDriver.modifyCustDetails();
                    break;
                case 3:
                    CustomerDriver.generateBill();
                    break;
                case 4:
                    CustomerDriver.displayTransBetweenDates();
                    break;
                case 5:
                    TransactionDriver.getTransbyZipcode();
                    break;
                case 6:
                    TransactionDriver.getNumAndTotalByType();
                    break;
                case 7:
                    TransactionDriver.getNumAndTotalByState();
                    break;
                case 8:
                    System.out.println("EXITING PROGRAM");
                    exit=true;
                    break;

            }
        }
        }catch(InputMismatchException e){
                e.printStackTrace();
            }
        ///which poption
//        CustomerDAO customerDAO = new CustomerDAO();
//        customerDAO.getCustDetails(123456100);
//        customerDAO.getCustDetails(123453023);
//        customerDAO.getCustDetails(123456466);
//      customerDAO.displayTransBetweenDates(123456100,2018,2018,1,2,1,30);
//        customerDAO.generateBill("4210653312528499",1,2018);
//
//        TransactionDAO transactionDAO = new TransactionDAO();
//        transactionDAO.getNumAndTotalByState("NY");
//        transactionDAO.getNumAndTotalByType("Education");
//        transactionDAO.getTransbyZipcode(98444,2,2018);
        System.out.println("Ending Application");
    }
}
