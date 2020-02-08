import java.io.IOException;
import java.util.Scanner;

public class FLAMES {

    public static char[] stringToArray(String name) {
        int a = name.length();
        char[] name_array = new char[25];
        for (int i = 0; i < a; i++)
            name_array[i] = name.charAt(i);
        return name_array;
    }

    public static int removeCommonsAndReturnLength(char[] a, char[] b) {
        int a_length = a.length;
        int b_length = b.length;
        for (int i = 0; i < a_length; i++) {
            for (int j = 0; j < b_length; j++) {
                if (a[i] == b[j]) {
                    a[i] = '0';
                    b[j] = '0';
                }

            }
        }
        int sum = 0;
        for (char c : a) {
            if (c != '0')
                sum++;
        }
        for (char c : b) {
            if (c != '0')
                sum++;
        }
        return sum;
    }

    public static String calculateFlames(int sum) throws IOException {
        while (sum > 6)
            sum -= 6;
        switch (sum) {
            case 1:
                return "friends";
            case 2:
                return "love";
            case 3:
                return "affection";
            case 4:
                return "marriage";
            case 5:
                return "enemies";
            case 6:
                return "siblings";
            default:
                throw new IOException("idk why");
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("name 1 =");
        String name = scan.nextLine().toLowerCase();
        System.out.println("name 2 =");
        String name1 = scan.nextLine().toLowerCase();
        char[] a;
        a = stringToArray(name);
        char[] b;
        b = stringToArray(name1);
        int sum = removeCommonsAndReturnLength(a, b);
        System.out.println(calculateFlames(sum));
    }
}
