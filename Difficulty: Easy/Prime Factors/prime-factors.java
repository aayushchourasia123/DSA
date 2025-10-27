class Solution {
    public static boolean isPrime(int number) {
        // 0, 1, and negative numbers are not prime
        if (number <= 1) {
            return false;
        }

        // 2 is the only even prime number
        if (number == 2) {
            return true;
        }

        // Check if the number is even (and not 2), then it's not prime
        if (number % 2 == 0) {
            return false;
        }

        // Check for divisibility by odd numbers from 3 up to the square root of the number
        // We only need to check up to the square root because if a number has a divisor greater than its square root,
        // it must also have a divisor smaller than its square root.
        for (int i = 3; i * i <= number; i += 2) { // Increment by 2 to check only odd numbers
            if (number % i == 0) {
                return false; // If divisible, it's not prime
            }
        }

        return true; // If no divisors found, it's prime
    }
    public static ArrayList<Integer> primeFac(int n) {
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=2;i<=n;i++){
            if(n%i==0 && isPrime(i)){
                ans.add(i);
            }
        }
        return ans;
    }
}