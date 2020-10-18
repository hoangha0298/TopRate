package Exercise1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String str1 = "hoang";
        String str2 = "hoang";
        String str3 = new String("hoang");
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);

//        switchCaseUseString();
//        switchCaseUseObject();
    }

    private static void switchCaseUseString() {
        Scanner sc = new Scanner(System.in);
        String month = new String("ten");
        System.out.println(month == "ten");
        month = sc.nextLine();

        switch (month) {
            case "one":
                System.out.println(month + " This month has 31 days");
                break;
            case "tow":
                System.out.println(month + " This month has 28 or 29 days");
                break;
            case "three":
                System.out.println(month + " This month has 31 days");
                break;
            case "for":
                System.out.println(month + " This month has 30 days");
                break;
            case "five":
                System.out.println(month + " This month has 31 days");
                break;
            case "six":
                System.out.println(month + " This month has 30 days");
                break;
            case "seven":
                System.out.println(month + " This month has 31 days");
                break;
            case "eight":
                System.out.println(month + " This month has 31 days");
                break;
            case "nine":
                System.out.println(month + " This month has 30 days");
                break;
            case "ten":
                System.out.println(month + " This month has 31 days");
                break;
            case "eleven":
                System.out.println(month + " This month has 30 days");
                break;
            case "twelve":
                System.out.println(month + " This month has 31 days");
                break;
            default:
                System.out.println("default");
        }
    }

//    private static void switchCaseUseString() {
//        String month = new String("10");
//        System.out.println(month == "10");
//
//        switch (month) {
//            case "1":
//                System.out.println(month + " This month has 31 days");
//                break;
//            case "2":
//                System.out.println(month + " This month has 28 or 29 days");
//                break;
//            case "3":
//                System.out.println(month + " This month has 31 days");
//                break;
//            case "4":
//                System.out.println(month + " This month has 30 days");
//                break;
//            case "5":
//                System.out.println(month + " This month has 31 days");
//                break;
//            case "6":
//                System.out.println(month + " This month has 30 days");
//                break;
//            case "7":
//                System.out.println(month + " This month has 31 days");
//                break;
//            case "8":
//                System.out.println(month + " This month has 31 days");
//                break;
//            case "9":
//                System.out.println(month + " This month has 30 days");
//                break;
//            case "10":
//                System.out.println(month + " This month has 31 days");
//                break;
//            case "11":
//                System.out.println(month + " This month has 30 days");
//                break;
//            case "12":
//                System.out.println(month + " This month has 31 days");
//                break;
//            default:
//                System.out.println("default");
//        }
//    }

//    private static void switchCaseUseObject() {
//        Month month = new Month("10");
//        System.out.println(month == new Month("10"));
//
//        switch (month) {
//            case new Month("1"):
//                System.out.println(month + " This month has 31 days");
//                break;
//            case new Month("2"):
//                System.out.println(month + " This month has 28 or 29 days");
//                break;
//            case new Month("3"):
//                System.out.println(month + " This month has 31 days");
//                break;
//            case new Month("4"):
//                System.out.println(month + " This month has 30 days");
//                break;
//            case new Month("5"):
//                System.out.println(month + " This month has 31 days");
//                break;
//            case new Month("6"):
//                System.out.println(month + " This month has 30 days");
//                break;
//            case new Month("7"):
//                System.out.println(month + " This month has 31 days");
//                break;
//            case new Month("8"):
//                System.out.println(month + " This month has 31 days");
//                break;
//            case new Month("9"):
//                System.out.println(month + " This month has 30 days");
//                break;
//            case new Month("10"):
//                System.out.println(month + " This month has 31 days");
//                break;
//            case new Month("11"):
//                System.out.println(month + " This month has 30 days");
//                break;
//            case new Month("12"):
//                System.out.println(month + " This month has 31 days");
//                break;
//            default:
//                System.out.println("default");
//        }
//    }

}
