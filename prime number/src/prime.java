import java.util.Scanner;

public class prime {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入值:");
        int cur=scanner.nextInt();
        int i=2;
        for(;i<cur;++i){
            if(cur%i==0){
                System.out.println("不是素数");
                break;
            }

        }
        if(i==cur){
            System.out.println("是素数");
        }

    }
}
