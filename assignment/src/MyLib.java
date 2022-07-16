
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MyLib {

    public static int inputInt() {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string integer number: ");
        String n = sc.nextLine();
        int m;
        while (true) {
            try {

                if (n.length() > 10) {
                    throw new InputMismatchException("Too long number");
                }
                m = Integer.parseInt(n);
                break;

            } catch (Exception e) {
                System.out.println("You are enter wrong integer number ");
                System.out.println("Reason: " + e.getMessage());
                System.out.print("Enter any integer number again:  ");
                n = sc.nextLine();
            }

        }

        return m;
    }

    public static double inputDouble() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string double number: ");
        String n = sc.nextLine();
        double m;

        while (true) {
            try {
                if (n.length() > 10) {
                    throw new InputMismatchException(" Too long number");
                }
                m = Double.parseDouble(n);
                break;
            } catch (Exception e) {
                System.out.println("You are enter wrong string number !!!");
                System.out.println("Reason  " + e.getMessage());
                System.out.println("Enter a string double number again ");
                n = sc.nextLine();
            }
        }
        return m;

    }

    public static String inputStr(int length) {
        String result;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string include(Digits, Letters, SpeCharaters): ");
        result = sc.nextLine();
        while (true) {

            if (result.length() == length) {
                break;

            } else {
                System.out.println("Wrong input. you are enter a string with length " + result.length());
                System.out.println("Enter again  please!!!");
                result = sc.nextLine();
            }

        }

        return result;
    }

    public static boolean isIncludeDigits(String input) {

        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                return true;

            }

        }

        return false;
    }

    public static boolean isIncludeLetter(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (Character.isLetter(input.charAt(i))) {
                return true;

            }

        }
        return false;
    }

    public static boolean isIncludeSpecialCharacter(String input) {
        char[] arrSpeChar = {'`', '~', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '_', '-', '+', '=', '{', '}', '[', ']', '|', '/', ':', ';', '"', '<', '>', ',', '.', '?'};
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            for (int j = 0; j < arrSpeChar.length; j++) {
                if (c == arrSpeChar[j]) {
                    return true;
                }
            }
        }

        return false;
    }

    public static String inputStr(int length, boolean isIncludeDigits) {
        String result = inputStr(length);
        while (true) {
            if (isIncludeDigits(result) == isIncludeDigits) {

                break;

            } else {
                System.err.println("Wrong string. you have need to enter a string has isIncludeDigits " + isIncludeDigits);
                System.out.println("Enter again please!!!");
                result = inputStr(length);
            }

        }

        return result;
    }

    public static String inputStr(int length, boolean isIncludeDigits, boolean isIncludeLeter) {

        String result = inputStr(length, isIncludeDigits);
        while (true) {
            if (isIncludeLetter(result) == isIncludeLeter) {
                break;
            } else {
                System.err.println("Wrong String. You have need to enter a string has isIncludeLetter " + isIncludeLeter);
                System.out.println("Enter again please !!!");
                result = inputStr(length, isIncludeDigits);

            }

        }

        return result;

    }

    public static String inputStr(int length, boolean isIncludeDigits, boolean isIncludeLetter, boolean isIncludeSpecialCharacter) {
        String result = inputStr(length, isIncludeDigits, isIncludeLetter);
        while (true) {
            if (isIncludeSpecialCharacter(result) == isIncludeSpecialCharacter) {
                break;

            } else {
                System.err.println("Wrong string. you have need to enter a string has isIncludeSpecialCharacter " + isIncludeSpecialCharacter);
                System.out.println("Enter again please !!!");
                result = inputStr(length, isIncludeDigits, isIncludeLetter);
            }
        }
        return result;

    }

//    public static String brandId() {
//        Scanner sc = new Scanner(System.in);
//        String brandId = "";
//        String brandId1 = sc.nextLine();
//        List<Brand> m = BrandList.arrBrand();
//        while (true) {
//            for (int i = 0; i < m.size(); i++) {
//                 if(S)
//            }
//            return brandId1;
//
//        }
//
//    }

    public static String brandName() {
        Scanner sc = new Scanner(System.in);
        String brandId1 = sc.nextLine();
        while (true) {
            if (brandId1 == null) {
                break;
            } else {
                System.out.println("Please enter again ");
                brandId1 = sc.nextLine();
            }
            
        }
        return brandId1;
    }

    
    
}
