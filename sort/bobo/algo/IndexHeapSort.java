package bobo.algo;

/**
 * ʹ����������ѽ��ж�����,����֤���ǵ���������ѵ���ȷ��
 * ��������ѵ���Ҫ���ò�����������,��������ʹ������ֻ��Ϊ����֤���ǵ����������ʵ�ֵ���ȷ��
 * �ں�����ͼ����,��������С�������㷨,�������·���㷨���Ƕ���Ҫʹ�������ѽ����Ż�.
 * @author ASUS
 *
 */
public class IndexHeapSort {
	
	private IndexHeapSort(){}
	
	public static void sort(Comparable[] arr){
		
		int n = arr.length;
		
		IndexMaxHeap<Comparable>indexMaxHeap = new IndexMaxHeap<Comparable>(n);
		
		for(int i=0;i<n;i++)
			indexMaxHeap.insert(i, arr[i]);
		
		for(int i = n-1;i>=0 ;i--)
			arr[i] = indexMaxHeap.extractMax();
		
	}
		
	public static void main(String[] args){
		int N = 1000000;
		Integer[] arr= SortTestHelper.generateRandomArray(N, 0, 10000000);
		SortTestHelper.testSort("bobo.algo.IndexHeapSort", arr);
		
		return;
	}
	
	
}
