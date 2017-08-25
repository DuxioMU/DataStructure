package bobo.algo;
/**
 * 不使用用一个额外的最大堆,直接在原数组上进行原地的堆排序
 * @author ASUS
 *
 */
public class HeapSort {
	
	
	private HeapSort(){}
	
	public static void sort(Comparable arr[]){
		
		int n = arr.length;
		//注意,此时我们的堆是从0开始索引的
		//从(最后一个元素的索引-1)/2开始
		//最后一个元素的索引=n-1;
		for(int i = (n-1-1)/2;i>=0;i--)
			shiftDown2(arr,n,i);
		
		for(int i= n-1;i>0;i--){
			swap(arr,0,i);
			shiftDown2(arr,i,0);
		}
	}
	
	//原始的shifDown过程
	@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
	private void shiftDown(Comparable[] arr, int n,int k){
		
		while(2*k+1 < n){
			int j=2*k+1;
			if(j+1<n && arr[j+1].compareTo(arr[j])>0)
				j++;
			
			if(arr[k].compareTo(arr[j])>=0) break;
			
			swap(arr,k,j);
			k=j;
		}
	}
	//优化的shiftDown过程,使用赋值的方式取代不断的swap,
	//该优化思想和我们之前对插入的排序进行的优化的思想是一致的.
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void shiftDown2(Comparable[] arr,int n,int k){
		
		Comparable  e = arr[k];
		while(2*k+1<n){
			int j=2*k+1;
			if(j+1<n&& arr[j+1].compareTo(arr[j])>0)
				j++;
			if(e.compareTo(arr[j])>= 0)
				break;
			arr[k] = arr[j];
			k=j;
		}
		arr[k] = e;
	}
	
	private static void swap(Object[] arr,int i,int j){
		Object temp = arr[i];
		arr[i]  = arr[j];
		arr[j] =temp;
	}
	
	
	   // 测试 HeapSort
    public static void main(String[] args) {

        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("bobo.algo.HeapSort", arr);

        return;
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
