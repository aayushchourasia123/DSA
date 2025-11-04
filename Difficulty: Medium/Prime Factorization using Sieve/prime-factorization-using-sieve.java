import java.util.*;

class Solution {
    static final int LIMIT = 1000000;
    static boolean sieveBuilt = false;
    static int[] prime;

    static void sieve() {
        if (sieveBuilt) return; // run only once
        sieveBuilt = true;

        prime = new int[LIMIT + 1];
        Arrays.fill(prime, 1);
        prime[0] = prime[1] = 0;

        for (int i = 2; i * i <= LIMIT; i++) {
            if (prime[i] == 1) {
                for (int j = i * i; j <= LIMIT; j += i)
                    prime[j] = 0;
            }
        }
    }

    static List<Integer> findPrimeFactors(int N) {
        sieve(); // ensures it’s built exactly once
        List<Integer> ans = new ArrayList<>();

        for (int i = 2; i * i <= N; i++) {
            if (prime[i] == 1) {
                while (N % i == 0) {
                    ans.add(i);
                    N /= i;
                }
            }
        }

        if (N > 1) ans.add(N);
        return ans;
    }

    // Optional: If GFG/CodeChef-style input handling
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sieve(); // pre-build sieve ONCE

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            List<Integer> res = findPrimeFactors(n);
            for (int x : res)
                System.out.print(x + " ");
            System.out.println();
        }
    }
}
