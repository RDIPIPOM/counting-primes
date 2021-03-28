package mx.ucol.threads;

public class CountPrimesClass implements Runnable {
    private static int countPrimes(int min, int max) {
        int count = 0;
        for (int i = min; i <= max; i++) {
            if (isPrime(i)) {
                count++;
            }
        }

        return count;
    }

    private static boolean isPrime(int x) {
        assert x > 1;
        int top = (int)Math.sqrt(x);

        for (int i = 2; i <= top; i++) {
            if (x % i == 0) {
                return false;
            }
        }

        return true;
    }

    @Override
    public void run(){
        double currentTime = System.currentTimeMillis();
        int numberOfPrimes = this.countPrimes(1, 5000000);
        double currentTime2 = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + " counted " + numberOfPrimes + " primes in " + (currentTime2 - currentTime)/1000 + " seconds.");
    }
}
