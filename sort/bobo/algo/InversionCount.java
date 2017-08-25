package bobo.algo;

import java.util.Arrays;

/**
 * ����4 ��������
 * @author ASUS
 *
 */
public class InversionCount {
	// ���ǵ��㷨�಻��������κ�ʵ��
    private InversionCount(){}
    
    //merge ���������arr[l...mid]��arr[mid+l...r]����Ļ�����,arr[l...r]���������Ը���
    @SuppressWarnings({ "unchecked", "unchecked", "unchecked" })
	private static long merge(Comparable[] arr,int l ,int mid,int r){
    	
    	  Comparable[] aux = Arrays.copyOfRange(arr, l, r+1);

          // ��ʼ���������Ը��� res = 0
          long res = 0L;
          // ��ʼ����iָ����벿�ֵ���ʼ����λ��l��jָ���Ұ벿����ʼ����λ��mid+1
          int i = l, j = mid+1;
          for( int k = l ; k <= r; k ++ ){

              if( i > mid ){  // �����벿��Ԫ���Ѿ�ȫ���������
                  arr[k] = aux[j-l];
                  j ++;
              }
              else if( j > r ){   // ����Ұ벿��Ԫ���Ѿ�ȫ���������
                  arr[k] = aux[i-l];
                  i ++;
              }
              else if( aux[i-l].compareTo(aux[j-l]) <= 0 ){  // ��벿����ָԪ�� <= �Ұ벿����ָԪ��
                  arr[k] = aux[i-l];
                  i ++;
              }
              else{   // �Ұ벿����ָԪ�� < ��벿����ָԪ��
                  arr[k] = aux[j-l];
                  j ++;
                  // ��ʱ, ��Ϊ�Ұ벿��k��ָ��Ԫ��С
                  // ���Ԫ�غ���벿�ֵ�����δ�����Ԫ�ض���������������
                  // ��벿�ִ�ʱδ�����Ԫ�ظ���Ϊ mid - j + 1
                  res += (long)(mid - i + 1);
              }
    	}
    	return res;
    }
    
    //��arr[l...r]��Χ���������Ը���
    //˼��:�鲢������Ż��ɷ����������������㷨?
    private static long solve(Comparable[] arr,int l,int r){
    	if(l >= r)
    		return 0L;
    	
    	int mid =l+(r-l)/2;
    	//���arr[l...mid]��Χ��������
    	long res1 = solve(arr,l,mid);
    	//���arr[mid+1...r]��Χ��������
    	long res2 = solve(arr,mid+1,r);
    	
    	return res1 + res2 + merge(arr,l,mid,r);
    	
    }
    
    @SuppressWarnings("rawtypes")
	private static long solve(Comparable[] arr){
    	int n = arr.length;
    	return solve(arr,0,n-1);
    }
    
    // ���� InversionCount
    public static void main(String[] args) {

        int N = 1000000;

        // ����1: �����������
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        System.out.println("Test Inversion Count for Random Array, n = " + N + " :" + solve(arr) );

        // ����2: ������ȫ���������
        // ���Ӧ��Ϊ0
        arr = SortTestHelper.generateOrderedArray(N);
        System.out.println("Test Inversion Count for Ordered Array, n = " + N + " :" + solve(arr) );

        // ����3: ������ȫ���������
        // ���Ӧ��Ϊ N*(N-1)/2
        arr = SortTestHelper.generateInversedArray(N);
        System.out.println("Test Inversion Count for Inversed Array, n = " + N + " :" + solve(arr) );


        return;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
