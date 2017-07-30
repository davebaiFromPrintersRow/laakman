package Ch2LinkedLists;

public class BigO {
    public static void main(String[] args) {

        allFib(15);
        System.out.println("**");
        permu("dog");
    }

    static void allFib(int n) {
        int[] memo = new int[n + 1];
        for (int i = 0; i < n; i++) {
            System.out.println(i + ": " + fib(i, memo));
        }
    }

    private static int fib(int n, int[] memo) {
        if (n <= 0) return 0;
        else if (n == 1) return 1;
        else if (memo[n] > 0) return memo[n];

        memo[n] = fib(n - 1, memo) + fib(n - 2, memo);
        return memo[n];
    }

    static void permu(String str) {
        permu(str, "");
    }

    private static void permu(String str, String prefix) {
        if (str.length() == 0) {
            System.out.println("*" + prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i + 1);
                permu(rem, prefix + str.charAt(i));
            }
        }
    }
}
