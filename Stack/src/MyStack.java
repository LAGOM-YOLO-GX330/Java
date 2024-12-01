import java.util.Arrays;

public class MyStack {
    public Object arr[];
    int usesize;

    public MyStack( ) {
        this.arr = new Object[4];
        this.usesize =0;
    }
    private void ensureCapacity(){
        if(arr.length==usesize){
            arr= Arrays.copyOf(arr,usesize*2);
        }
    }
    public Object push(Object e){
        ensureCapacity();
        arr[usesize]=e;
        ++usesize;
        return e;
    }
    public Object pop(){
        Object e=arr[--usesize];
        usesize--;
        return e;
    }
    public Object peek(){
        if(empty()){
            throw new RuntimeException("栈为空，无法获取栈顶元素");
        }
        return arr[--usesize];
    }
    public boolean empty(){
        return usesize==0;
    }
    public int size(){
        return usesize;
    }
}
