public class Fibonacci {

    public static int fibSequence(int n){
        // base case
        if(n == 0){
            return 0;
        }

        if(n == 1 || n == 2){
            return 1;
        }

        return fibSequence(n-2) + fibSequence(n-1);
    }

    private void start(){
        System.out.println(fibSequence(5));
    }

    public static void main(String[] args) {
        new Fibonacci().start();
    }
}
