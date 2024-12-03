import java.lang.reflect.Array;
import java.util.Arrays;

public class test {
    public void test(){
        int[] arr=new int[1_0000];

    }

    public static void main(String[] args) {
        int[]arr={5,1,3,6,4,2};
        sort insertsort=new sort();
       insertsort.MergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
}
