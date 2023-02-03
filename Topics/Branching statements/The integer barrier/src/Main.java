import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;

        while (scanner.hasNextInt() && sum < 1000) {
            int num = scanner.nextInt();
            if (num == 0) {
                break;
            }
            sum += num;
        }

        if (sum >= 1000) {
            sum -= 1000;
        }

        System.out.println(sum);
    }
}