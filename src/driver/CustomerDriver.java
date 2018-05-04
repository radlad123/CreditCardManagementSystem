package driver;

import DAO.CustomerDAO;
import exception.MismatchException;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class CustomerDriver {
    private static Scanner scanner = new Scanner(System.in);
    private static CustomerDAO customerDAO = new CustomerDAO();
    static void getCustDetails() throws MismatchException {
        System.out.println("ENTER ID");
        int input = scanner.nextInt();
        if(!isValidId(String.valueOf(input)))
            throw new MismatchException("INVALID INPUT");
        customerDAO.getCustDetails(input);
    }
    static void modifyCustDetails(){


        String firstName;
        String middleName;
        String lastName;
        long accountID;
        String creditCardNo;
        String streetName;
        String aptNo;
        String city;
        String state;
        String country;
        String zip;
        String email;
        long phone;

        System.out.println("ENTER ID");
        accountID = scanner.nextLong();
        boolean exited = false;

        String statement = "-------------\n"+" 1: Change FirstName "+"\n"+
                " 2: Change MiddleName  "+"\n" +
                " 3: Change LastName  "+"\n"+
                " 4: Change StreetName  "+"\n"+
                " 5: Change Apartment Number "+"\n"+
                " 6: Change City "+"\n"+
                " 7: Change State "+"\n"+
                " 8: Change Country "+"\n"+
                " 9: Change Zip "+"\n"+
                " 10: Change Email "+"\n"+
                " 11: Change Phone "+"\n"+
                " 12: EXIT"+"\n"+
                "-------------\n";
        while(!exited) {
            System.out.println(statement);
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    System.out.println("ENTER FIRST NAME");
                    firstName = scanner.next();
                    customerDAO.modifyCustDetails("FIRST_NAME", firstName, accountID);
                    break;
                case 2:
                    System.out.println("ENTER MIDDLE NAME");
                    middleName = scanner.next();
                    customerDAO.modifyCustDetails("MIDDLE_NAME", middleName, accountID);
                    break;
                case 3:
                    System.out.println("ENTER LAST NAME");
                    lastName = scanner.next();
                    customerDAO.modifyCustDetails("LAST_NAME", lastName, accountID);
                    break;
                case 4:
                    System.out.println("ENTER STREETNAME");
                    streetName = scanner.nextLine();
                    customerDAO.modifyCustDetails("STREET_NAME", streetName, accountID);
                    break;
                case 5:
                    System.out.println("ENTER APT NUMBER");
                    aptNo = scanner.next();
                    customerDAO.modifyCustDetails("APT_NO", aptNo, accountID);
                    break;
                case 6:
                    System.out.println("ENTER CITY");
                    city = scanner.next();
                    customerDAO.modifyCustDetails("CUST_CITY", city, accountID);
                    break;
                case 7:
                    System.out.println("ENTER STATE");
                    state = scanner.next();
                    customerDAO.modifyCustDetails("CUST_STATE", state, accountID);
                    break;
                case 8:
                    System.out.println("ENTER COUNTRY");
                    country = scanner.nextLine();
                    customerDAO.modifyCustDetails("CUST_COUNTRY", country, accountID);
                    break;
                case 9:
                    System.out.println("ENTER ZIP");
                    zip = scanner.next();
                    customerDAO.modifyCustDetails("CUST_ZIP", zip, accountID);
                    break;
                case 10:
                    System.out.println("ENTER EMAIL");
                    email = scanner.next();
                    customerDAO.modifyCustDetails("CUST_EMAIL", email, accountID);
                    break;
                case 11:
                    System.out.println("ENTER PHONE");
                    phone = scanner.nextLong();
                    customerDAO.modifyCustDetails("CUST_PHONE", String.valueOf(phone), accountID);
                    break;
                case 12:
                    exited=true;
                    break;

            }
        }


//        System.out.println("ENTER CREDITCARD NUMBER");
//        creditCardNo = scanner.next();

    }
    static void generateBill(){
        System.out.println("ENTER CARD_NUM");
        String cardNum = scanner.next();
        System.out.println("ENTER MONTH");
        int month = scanner.nextInt();
        System.out.println("ENTER YEAR");
        int year = scanner.nextInt();
        customerDAO.generateBill(cardNum,month,year);

    }
    static void displayTransBetweenDates() {
        scanner = new Scanner(System.in);
        System.out.println("ENTER ID");
        int id = scanner.nextInt();
        System.out.println("ENTER START YEAR");
        int startYear = scanner.nextInt();
        System.out.println("ENTER END YEAR");
        int endYear = scanner.nextInt();
        System.out.println("ENTER START MONTH");
        int startMonth = scanner.nextInt();
        System.out.println("ENTER END MONTH");
        int endMonth = scanner.nextInt();
        System.out.println("ENTER START DAY");
        int startDay = scanner.nextInt();
        System.out.println("ENTER END DAY");
        int endDay = scanner.nextInt();
        customerDAO.displayTransBetweenDates(id, startYear, endYear, startMonth, endMonth, startDay, endDay);
    }
    static boolean isValidCard(String card){
        Pattern p = Pattern.compile("[A-Z 0-9]{16}");
        Matcher m = p.matcher(card);
        return m.matches();

    }
    static boolean isValidId(String id){
        Pattern p = Pattern.compile("[0-9]{9}");
        Matcher m = p.matcher(id);
        return m.matches();

    }
    static boolean isValidDay(String day){
        Pattern p = Pattern.compile("[\\d]{2}");
        Matcher m = p.matcher(day);
        return m.matches();

    }
    private static boolean isValidMonth(int month){
        return month<0 || month>12;
    }


}
