import java.util.*;
public class Fibonacci{

  public static void main(String[] args){
    Scanner s = new Scanner(System.in);
    System.out.println("Which Fibonacci number would you like?");
    int n = s.nextInt();
    
    System.out.println(formulaicFib(n));
    System.out.println(memoizedFib(n));
    System.out.println(iterativeFib(n));
    System.out.println(recursiveFib(n));
  }
  
  //O(P^n) where P = golden ratio = (1 + sqrt(5))/2
  public static long recursiveFib(int n){
    if(n>45){System.out.println("Too large for recursion! Im out!\n");return -1;}
    if(n<=2){return 1;}
    return recursiveFib(n-2)+recursiveFib(n-1);
  }
  
  //O(n) space-optimized
  public static long iterativeFib(int n){
    long f1 = 1;
    long f2 = 1;
    long f3 = 0;
    if(n<=2){return 1;}
    for(int i = 2; i < n; i++){
         f3 = f1+f2;
         f1 = f2;
         f2 = f3;
    }
    return f3;
  }
  
  //O(3)
  public static long formulaicFib(int n){
    double num = Math.pow((1+Math.sqrt(5)),(double)n) - Math.pow((1-Math.sqrt(5)),(double)n);
    double den = Math.pow(2,(double)n) * Math.sqrt(5);
    return (long)Math.floor(num/den);
  }
  
  //O(n) keeps record of solutions
  @SuppressWarnings("unchecked")
  public static long memoizedFib(int n){
    if(n<=2){return 1;}
    long[] memo = new long[1000];
    memo[0] = 1l;
    memo[1] = 1l;
    for(int i=2; i<n; i++){
      memo[i] = memo[i-2] + memo[i-1];
    }
    return memo[n-1];
  }
}
