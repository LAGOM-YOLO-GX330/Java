import java.util.Scanner;

public class number {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        for(int i=0;i<=999;++i){
            int a=i%10;
            int b=(i/10)%10;
            int c=(i/100)%10;
            if(i==a*a*a+b*b*b+c*c*c){
                System.out.println(i);
            }
        }
    }
}
