package bobo.algo;
/**
 * 归并排序的另外一个优化，在merge外申请aux空间
 * @author ASUS
 * 在 mergeSort3中, 我们一次性申请aux空间,
 * 并将这个辅助空间以参数形式传递给完成归并排序的各个子函数
 */
public class MergeSort3 {

	
	
	//递归使用归并排序,对arr[l....r]的范围进行排序
	//其中aux为完成merge过程中所需要的辅助空间
	private static void merge(Comparable[] arr,Comparable[] aux, int l,int mid,int r){
		
		System.arraycopy(arr, l, aux, l, r-l+1);
		
		//初始化,i指向左半部分的起始索引位置l;指向有半部分起始索引位置mid+1;
		int i = l,j = mid+1;
		for(int k=l;k<=r;k++){
			
			if(i>mid){
				arr[k] = aux[j] ;j++;
			}else if(j>r){
				arr[k] = aux[i]; i++;
			}else if(aux[i].compareTo(arr[j])<0){
				arr[k] = aux[i];i++;
			}else{//左半部分所指元素> = 有半部分所指元素
				arr[k] = aux[j] ;j++;
			}
		}
	}

    // 递归使用归并排序,对arr[l...r]的范围进行排序
    // 其中aux为完成merge过程所需要的辅助空间
    private static void sort(Comparable[] arr, Comparable[] aux, int l, int r) {

        // 对于小规模数组, 使用插入排序
        if( r - l <= 15 ){
            InsertionSort.sort(arr, l, r);
            return;
        }

        int mid = (l+r)/2;
        sort(arr, aux, l, mid);
        sort(arr, aux, mid + 1, r);
        // 对于arr[mid] <= arr[mid+1]的情况,不进行merge
        // 对于近乎有序的数组非常有效,但是对于一般情况,有一定的性能损失
        if( arr[mid].compareTo(arr[mid+1]) > 0 )
            merge(arr, aux, l, mid, r);
    }
	
    public static void sort(Comparable[] arr){
    	
        int n = arr.length;
        Comparable[] aux = new Comparable[n];
        sort(arr, aux, 0, n-1);
    }

    // 测试 MergeSort2
    public static void main(String[] args) {

        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("bobo.algo.MergeSort2", arr);

        return;
    }
	
}
