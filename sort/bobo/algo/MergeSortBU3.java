package bobo.algo;

/**
 * ����2 �Զ����º��Ե����ϵĹ鲢����ıȽ�
 * @author ASUS
 *
 */
public class MergeSortBU3 {
	// ���ǵ��㷨�಻��������κ�ʵ��
    private MergeSortBU3(){}
    
    // ��arr[l...mid]��arr[mid+1...r]�����ֽ��й鲢
    // ����auxΪ���merge��������Ҫ�ĸ����ռ�
    private static void merge(Comparable[] arr, Comparable[] aux, int l, int mid, int r) {
    	
        System.arraycopy(arr, l, aux, l, r-l+1);
        
        // ��ʼ����iָ����벿�ֵ���ʼ����λ��l��jָ���Ұ벿����ʼ����λ��mid+1
        int i = l, j = mid+1;
        for( int k = l ; k <= r; k ++ ){

            if( i > mid ){  // �����벿��Ԫ���Ѿ�ȫ���������
                arr[k] = aux[j]; j ++;
            }
            else if( j > r ){   // ����Ұ벿��Ԫ���Ѿ�ȫ���������
                arr[k] = aux[i]; i ++;
            }
            else if( aux[i].compareTo(aux[j]) < 0 ){  // ��벿����ָԪ�� < �Ұ벿����ָԪ��
                arr[k] = aux[i]; i ++;
            }
            else{  // ��벿����ָԪ�� >= �Ұ벿����ָԪ��
                arr[k] = aux[j]; j ++;
            }
        }
    }   
    
    public static void sort(Comparable[] arr){

        int n = arr.length;

        // ����С����, ʹ�ò��������Ż�
        for( int i = 0 ; i < n ; i += 16 )
            InsertionSort.sort(arr, i, Math.min(i+15, n-1) );

        Comparable[] aux = new Comparable[n];
        for( int sz = 16; sz < n ; sz += sz )
            for( int i = 0 ; i < n - sz ; i += sz+sz )
                // ����arr[mid] <= arr[mid+1]�����,������merge
                if( arr[i+sz-1].compareTo(arr[i+sz]) > 0 )
                    merge(arr, aux, i, i+sz-1, Math.min(i+sz+sz-1,n-1) );

    }   
    
    

    // ���� MergeSort BU 2
    public static void main(String[] args) {

        // Merge Sort BU 3 Ҳ��һ��O(nlogn)���Ӷȵ��㷨����Ȼֻʹ������forѭ��
        // ���ԣ�Merge Sort BU 3 Ҳ������1��֮�����ɴ���100��������������
        // ע�⣺��Ҫ���׸���ѭ���������ж��㷨�ĸ��Ӷȣ�Merge Sort BU 3 ����һ������
        // �����ⲿ�����壬�Ƽ����ҵġ���ת�㷨���ԡ��γ̣��ڶ��£��������еĸ��Ӷȷ���������
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("bobo.algo.MergeSortBU3", arr);

        return;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
