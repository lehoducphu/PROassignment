
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public static int int_getChoice(ArrayList options) {
        
        /*in ra các lựa chọn tạo ra từ ArrayList đc truyền vào
        và trả về số đứng trước lựa chọn người dùng nhập (đã qua kiểm tra)
        VD: cho 1 ArrayList: {"option 1", "option 2", "option 3"}
        
        output:
        
        1. option 1
        2. option 2
        3. option 3
        
        Please choose an option: */
        Scanner sc = new Scanner(System.in);
        int response;
        int N = options.size();
        for (int i = 0; i < N; i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
        System.out.print("\nPlease choose an option: ");
        response = inputInt(false, false, true, 1, options.size());
        return response;

    }

    public static Object ref_getChoice(ArrayList options) {
        
        /*trả về object đã chọn ở method int_getChoice(int) trong ArrayList
        
        VD: cho 1 ArrayList: {"option 1", "option 2", "option 3"}
        output:
        1. option 1
        2. option 2
        3. option 3
        
        Please choose an option: 
        Chọn 1 thì method này sẽ trả về "option 1" */

        int response;
        int N = options.size();
        response = int_getChoice(options);
        return options.get(response - 1);

    }

    public static String inputInt(boolean isIncludeLetter) {
        
        // kiểm tra có chữ trong input ko
        
        Scanner sc = new Scanner(System.in);
        String result = sc.nextLine();
        while (true) {
            if (MyLib.isIncludeLetter(result) == isIncludeLetter) {
                break;
            } else {
                System.err.println("You have entered wrong option.\nReason: Your input contains letter.\n");
                System.err.println("Please enter option again: ");
                result = sc.nextLine();
            }
        }
        return result;
    }

    public static int inputInt(boolean isIncludeLetter, boolean isIncludeSpecialChar) {
        
        //kiểm tra có chữ, có kí tự đặc biệt trong input ko
        
        String result = inputInt(isIncludeLetter);
        while (true) {
            if (MyLib.isIncludeSpecialCharacter(result) == isIncludeSpecialChar) {
                break;

            } else {
                System.err.println("You have entered wrong option.\nReason: Your input contains special character.");
                System.err.println("Please enter option again: ");
                result = inputInt(isIncludeLetter);
            }
        }
        int num = Integer.parseInt(result);
        return num;
    }

    public static int inputInt(boolean isIncludeLetter, boolean isIncludeSpecialChar, boolean isInRange, int start, int end) {
        
        //kiểm tra có chữ, có kí tự đặc biệt, có nằm trong khoảng [start, end] trong input ko
        
        int num = inputInt(isIncludeLetter, isIncludeSpecialChar);
        while (true) {
            if (MyLib.isInRange(num, start, end) == isInRange) {
                break;
            } else {
                System.err.println("You have entered wrong option.\nReason: Your input is out of range of option's list.");
                System.err.println("Please enter option again with option from " + start + "to " + end + ": ");
                num = inputInt(isIncludeLetter, isIncludeSpecialChar);
            }
        }
        return num;
    }

}
