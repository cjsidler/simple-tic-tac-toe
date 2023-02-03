import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] nums = new int[length];

        for (int i = 0; i < length; i++) {
            nums[i] = scanner.nextInt();
        }

        int n = scanner.nextInt();
        int sum = 0;

        for (int num : nums) {
            if (num > n) {
                sum += num;
            }
        }

        System.out.println(sum);
    }
}