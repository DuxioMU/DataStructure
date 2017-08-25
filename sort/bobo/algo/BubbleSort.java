package bobo.algo;

public class BubbleSort {

	//
	private BubbleSort(){}
	
	public static void sort(Comparable arr[] ){
		
		int n = arr.length;
		boolean swappend = false;
		//int newn ; //������,����ʹ��newn�����Ż�,��ʵ���Ż�Ч���ϲ�
		do{
			swappend = false;
			//newn=0;
			for(int i=1 ; i < n; i++){
				if(arr[i-1].compareTo(arr[i])>0){
					swap(arr,i-1,i);
					swappend = true;
					
					//���Լ�¼���һ�εĽ���λ��,�ڴ�֮���Ԫ������һ��ɨ���о�������
					//ʵ���Ż�Ч���ϲ�,��Ϊ������newn����µı���
					//newn = n;
				}
			}
			//n = newn;
			
			//�Ż�, ÿһ��Bubble Sort ��������Ԫ�ط���������λ��
			//����ϵ��������,����Ԫ�ؿ��Բ��ٿ���
			//������,newn���Ż�������Ż��ĸ��Ӱ汾,Ӧ�ø���Ч
			//ʵ��,ʹ�����ּ��Ż�,ʱ�����ܸ���.
			n --;
		}while(swappend);
		
		
		
	}
	  private static void swap(Object[] arr, int i, int j) {
	        Object t = arr[i];
	        arr[i] = arr[j];
	        arr[j] = t;
	  }
	  
	  // ����InsertionSort
	    public static void main(String[] args) {

	        int N = 20000;
	        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
	        SortTestHelper.testSort("bobo.algo.BubbleSort", arr);

	        return;
	    }
}
