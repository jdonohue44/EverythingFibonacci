import java.util.*;
public class Fibonacci{

  public static void main(String[] args){
    Scanner s = new Scanner(System.in);
    HashMap<Integer,Integer> memo = new HashMap<Integer,Integer>();
    System.out.println("Which element (0-45) of the Fibonacci sequence would you like?");
    int n = s.nextInt();
    
    System.out.println(formulaicFib(n));
    System.out.println(memoizedFib(n,memo));
    System.out.println(iterativeFib(n));
    System.out.println(recursiveFib(n));
  }
  
  public static long recursiveFib(int n){
    if(n==0){return 0;}
    if(n==1){return 1;}
    return recursiveFib(n-2)+recursiveFib(n-1);
  }
  
  public static long iterativeFib(int n){
    long n1 = 0;
    long n2 = 1;
    long n3 = 0;
    int ctr = 1;
    while(ctr < n){
         n3 = n1+n2;
         n1 = n2;
         n2 = n3;
         ctr ++;
    }
    return n3;
  }
  
  public static long formulaicFib(int n){
    double num = Math.pow((1+Math.sqrt(5)),(double)n) - Math.pow((1-Math.sqrt(5)),(double)n);
    double den = Math.pow(2,(double)n) * Math.sqrt(5);
    return (long)Math.floor(num/den);
  }
  
  @SuppressWarnings("unchecked")
  public static int memoizedFib(int n, HashMap memo){
    int f = 0;
    if(memo.containsKey(n)){return (Integer)memo.get(n);}
    if(n<=2){f = 1;}
    else{
      f = memoizedFib(n-1,memo) + memoizedFib(n-2,memo);
      memo.put(n,f);
    }
    return f;
  }
}