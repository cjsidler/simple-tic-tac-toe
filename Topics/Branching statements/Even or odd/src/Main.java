import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num;
        while (scanner.hasNextInt()) {
            num = scanner.nextInt();
            if (num == 0) {
                break;
            }
            String output = num % 2 == 0 ? "even" : "odd";
            System.out.println(output);
        }
    }
}