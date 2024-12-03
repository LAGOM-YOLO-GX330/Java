import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class sort {
    //插入排序
    public static void InsertSort(int[] arr){
      for(int i=1;i<arr.length;i++){
          int tmp=arr[i];
          int j=i-1;
          for(;j>=0;j--){
              if(arr[j]>tmp){
                  arr[j+1]=arr[j];
              }else{
                  break;
              }
          }
          arr[j+1]=tmp;
      }
    }
    //希尔排序
    public void shellsort(int[] arr){
        int gap=arr.length;
        while(gap>1){
            gap/=2;
            for(int i=gap;i<arr.length;i+=gap){
                int tmp=arr[i];
                int j=i-gap;
                for(;j>=0;j-=gap){
                    if(arr[j]>tmp){
                        arr[j+gap]=arr[j];
                    }else{
                        break;
                    }
                }
                arr[j+gap]=tmp;
            }
        }
    }
    public void shell(int[] arr,int gap){
        for(int i=gap;i<arr.length;i+=gap){
            int tmp=arr[i];
            int j=i-gap;
            for(;j>=0;j-=gap){
                if(arr[j]>tmp){
                    arr[j+gap]=arr[j];
                }else{
                    break;
                }
            }
            arr[j+gap]=tmp;
        }
    }
    //选择排序
    public void choicesort(int[] arr){
        for(int i=0;i<arr.length;++i){
            int j=i+1;
            int minx=i;
            for(;j<arr.length;j++){
                if(arr[minx]>arr[j]){
                    minx=j;
                }
            }
            Swap(arr,i,minx);
        }
    }
    public void Swap(int[] arr,int i,int j){
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
    //双向选择排序
    public void SelectSort(int[] arr) {
        int right=arr.length-1;
        int left=0;
        while(left<right) {
                int max = left;
                int min = left;
                for (int i =left+1; i <=right; i++) {
                    if (arr[i]<arr[left]) {
                        min = i;
                    }
                    if(arr[i]>arr[max]){
                        max = i;
                    }
                }
                Swap(arr, left, min);
                if (max == left) {
                    max = min;
                }
                Swap(arr, right, max);
                right--;
                left++;
        }
    }
    //堆排序
    public void HeapSort(int[] arr){
        PriorityQueue<Integer> q1 = new PriorityQueue<>(new IntCmp());
        for(int i=0;i<arr.length;++i){
            q1.offer(arr[i]);
        }
        int i=0;
        while(!q1.isEmpty()) {
            arr[i]=q1.poll();
            i++;
        }
    }
    //MY堆排
    public void SetHeap(int[]arr){
        for(int parent=(arr.length-1-1)/2;parent>=0;parent--){
            siftdown(arr,parent,arr.length);
        }
    }
    public void siftdown(int[]arr,int parent,int len){
        int child=parent*2+1;
         while(child<len){
             if(child+1<len&&arr[child]<arr[child+1]){
                 child=child+1;
             }
             if(arr[parent]<arr[child]){
                 Swap(arr,parent,child);
                 parent=child;
                 child=parent*2+1;
             }else{
                 break;
             }
         }
    }

    public void Heapsort1(int[]arr){
        SetHeap(arr);
        int end=arr.length-1;
        while(end>0){
            Swap(arr,0,end);
            siftdown(arr,0,end);
            end--;
        }
    }
    //冒泡排序
    public void bubbleSort(int[]arr){
        for(int i=0;i< arr.length;i++){
            boolean flg=false;
            for(int j=0;j< arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    Swap(arr,j+1,j);
                    flg=true;
                }
            }
            if(!flg){
                break;
            }
        }
    }
    //快排
    public void QuickSort(int[]arr,int start,int end){
        if(start>=end){
            return;
        }
        int pivot=PartSort(arr,start,end);
        QuickSort(arr,start,pivot-1);
        QuickSort(arr,pivot+1,end);
    }
    public int partition(int[]arr,int start,int end){
        int left=start;
        int right=end;
        while(left<right){
            while(left<right&&arr[right]>=arr[start]){
                right--;
            }
            while(left<right&&arr[left]<=arr[start]){
                left++;
            }
            Swap(arr,left,right);
        }
        Swap(arr,start,left);
        return left;
    }
    public int partitoionHoare(int[]arr,int start,int end){
        int mid=(start+end)/2;
        if(arr[start]<arr[end]){
            if(arr[mid]>arr[end]){
                return end;
            }else if(arr[mid]<arr[start]){
                return start;
            }else{
                return mid;
            }
        }else{
            if(arr[mid]>arr[start]){
                return start;
            }else if(arr[mid]<arr[end]){
                return end;
            }else{
                return mid;
            }
        }
    }
    //非递归
    public void QuickSortNor(int[]arr){
        int start=0;
        int end=arr.length-1;
        Stack<Integer> stack=new Stack<>();
        int pivot=PartSort(arr,start,end);
        if(pivot-1>start){
            stack.push(start);
            stack.push(pivot-1);
        }
        if(pivot+1<end){
            stack.push(pivot+1);
            stack.push(end);
        }
        while(!stack.isEmpty()) {
            end = stack.pop();
            start = stack.pop();
            pivot=PartSort(arr,start,end);
            if (pivot - 1 > start) {
                stack.push(start);
                stack.push(pivot - 1);
            }
            if (pivot + 1 < end) {
                stack.push(pivot + 1);
                stack.push(end);
            }
        }

    }
    public int PartSort(int[]arr,int left,int right){
        int tmp=arr[left];
        while(left<right){
            while(left<right&&arr[right]>=tmp){
                right--;
            }
            arr[left]=arr[right];
         while(left<right&&arr[left]<=tmp){
             left++;
         }
         arr[right]=arr[left];
        }
        arr[left]=tmp;
        return left;
    }
    //归并排序
    public void MergeSort(int[]arr,int start,int end){
        if(start>=end){
            return;
        }
        int mid=(start+end)/2;
        MergeSort(arr,start,mid);
        MergeSort(arr,mid+1,end);
        merge(arr,start,mid,end);
    }
    public void merge(int[]arr,int start,int mid,int end){
        int s1=start;
        int e1=mid;
        int s2=mid+1;
        int e2=end;
        int[]tmp=new int[end-start+1];
        int i=0;
        while(s1<=e1&&s2<=e2){
            if(arr[s1]<arr[s2]){
                tmp[i++]=arr[s1++];
            }else{
                tmp[i++]=arr[s2++];
            }
        }
        while(s1<=e1){
            tmp[i++]=arr[s1++];
        }
        while(s2<=e2){
            tmp[i++]=arr[s2++];
        }
        for(int j=0;j<tmp.length;j++){
            arr[j+start]=tmp[j];
        }
    }

}

class IntCmp implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
    }
}



