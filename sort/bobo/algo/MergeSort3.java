package bobo.algo;
/**
 * �鲢���������һ���Ż�����merge������aux�ռ�
 * @author ASUS
 * �� mergeSort3��, ����һ��������aux�ռ�,
 * ������������ռ��Բ�����ʽ���ݸ���ɹ鲢����ĸ����Ӻ���
 */
public class MergeSort3 {

	
	
	//�ݹ�ʹ�ù鲢����,��arr[l....r]�ķ�Χ��������
	//����auxΪ���merge����������Ҫ�ĸ����ռ�
	private static void merge(Comparable[] arr,Comparable[] aux, int l,int mid,int r){
		
		System.arraycopy(arr, l, aux, l, r-l+1);
		
		//��ʼ��,iָ����벿�ֵ���ʼ����λ��l;ָ���а벿����ʼ����λ��mid+1;
		int i = l,j = mid+1;
		for(int k=l;k<=r;k++){
			
			if(i>mid){
				arr[k] = aux[j] ;j++;
			}else if(j>r){
				arr[k] = aux[i]; i++;
			}else if(aux[i].compareTo(arr[j])<0){
				arr[k] = aux[i];i++;
			}else{//��벿����ָԪ��> = �а벿����ָԪ��
				arr[k] = aux[j] ;j++;
			}
		}
	}

    // �ݹ�ʹ�ù鲢����,��arr[l...r]�ķ�Χ��������
    // ����auxΪ���merge��������Ҫ�ĸ����ռ�
    private static void sort(Comparable[] arr, Comparable[] aux, int l, int r) {

        // ����С��ģ����, ʹ�ò�������
        if( r - l <= 15 ){
            InsertionSort.sort(arr, l, r);
            return;
        }

        int mid = (l+r)/2;
        sort(arr, aux, l, mid);
        sort(arr, aux, mid + 1, r);
        // ����arr[mid] <= arr[mid+1]�����,������merge
        // ���ڽ������������ǳ���Ч,���Ƕ���һ�����,��һ����������ʧ
        if( arr[mid].compareTo(arr[mid+1]) > 0 )
            merge(arr, aux, l, mid, r);
    }
	
    public static void sort(Comparable[] arr){
    	
        int n = arr.length;
        Comparable[] aux = new Comparable[n];
        sort(arr, aux, 0, n-1);
    }

    // ���� MergeSort2
    public static void main(String[] args) {

        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("bobo.algo.MergeSort2", arr);

        return;
    }
	
}
