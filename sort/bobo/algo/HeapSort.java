package bobo.algo;
/**
 * ��ʹ����һ�����������,ֱ����ԭ�����Ͻ���ԭ�صĶ�����
 * @author ASUS
 *
 */
public class HeapSort {
	
	
	private HeapSort(){}
	
	public static void sort(Comparable arr[]){
		
		int n = arr.length;
		//ע��,��ʱ���ǵĶ��Ǵ�0��ʼ������
		//��(���һ��Ԫ�ص�����-1)/2��ʼ
		//���һ��Ԫ�ص�����=n-1;
		for(int i = (n-1-1)/2;i>=0;i--)
			shiftDown2(arr,n,i);
		
		for(int i= n-1;i>0;i--){
			swap(arr,0,i);
			shiftDown2(arr,i,0);
		}
	}
	
	//ԭʼ��shifDown����
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
	//�Ż���shiftDown����,ʹ�ø�ֵ�ķ�ʽȡ�����ϵ�swap,
	//���Ż�˼�������֮ǰ�Բ����������е��Ż���˼����һ�µ�.
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
	
	
	   // ���� HeapSort
    public static void main(String[] args) {

        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("bobo.algo.HeapSort", arr);

        return;
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
