package mx.ucol.threads;

public class App {
    public static void main(String args[]) throws InterruptedException {
        int numberOfThreads = 0;

        if (args.length > 0) {
            try {
                numberOfThreads = Integer.parseInt(args[0]);
                System.out.println("Creating 5 threads for counting 5000000 primes.");
                Thread[] threads = new Thread[numberOfThreads];
                for (int i = 0; i < threads.length; i++)
                    threads[i] = new Thread(new CountPrimesClass());
                for (int i = 0; i < threads.length; i++)
                    threads[i].start();
            } catch (NumberFormatException e) {
                System.err.println("Argument " + args[0] + " must be an integer.");
                System.exit(1);
            }
        }

        if (numberOfThreads == 0) {
            System.out.println("Argument must be more than zero.");
            System.exit(1);
        }
   }
}