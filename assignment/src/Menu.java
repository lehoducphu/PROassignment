
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public static int int_getChoice(ArrayList options) {
        Scanner sc = new Scanner(System.in);
        int response;
        int N = options.size();
        for (int i = 0; i < N; i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
        System.out.print("Please choose an option: ");
        response = sc.nextInt();
        return response;

    }

    public static Object ref_getChoice(ArrayList options) {
        int response;
        int N = options.size();
        do {
            response = int_getChoice(options);
        } while (response < 0 || response > N);

        return options.get(response - 1);

    }

}
