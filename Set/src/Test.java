public class Test {
    public static void main(String[] args) {
        SearchSet test=new SearchSet();
        int[]arr={5,12,3,2,11,15};
        for(int i=0;i<arr.length;i++){
            test.Insert(arr[i]);
        }
        System.out.println(test.Search(11));
        System.out.println(test.Search(111));
        System.out.println("sdf");
    }
}
