package bobo.algo;

import java.util.Arrays;

/**
 * 面对近乎有序的数组
 * 快速排序退化成了O(n^2)
 * 我们使用随机指定标定点
 * 和对小规模数组,使用插入排序
 * @author ASUS
 *
 */
public class QuickSort2 {
	// 我们的算法类不允许产生任何实例
    private QuickSort2(){}

    // 对arr[l...r]部分进行partition操作
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    private static int partition(Comparable[] arr, int l, int r){

        // 优化1:随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap( arr, l , (int)(Math.random()*(r-l+1))+l );

        Comparable v = arr[l];

        int j = l; // arr[l+1...j] < v ; arr[j+1...i) > v
        for( int i = l + 1 ; i <= r ; i ++ )
            if( arr[i].compareTo(v) < 0 ){
                j ++;
                swap(arr, j, i);
            }

        swap(arr, l, j);

        return j;
    }

    // 递归使用快速排序,对arr[l...r]的范围进行排序
    private static void sort(Comparable[] arr, int l, int r){
    	
        //优化2:对于小规模数组, 使用插入排序
        if( r - l <= 15 ){
            InsertionSort.sort(arr, l, r);
            return;
        }

        int p = partition(arr, l, r);
        sort(arr, l, p-1 );
        sort(arr, p+1, r);
    }

    public static void sort(Comparable[] arr){

        int n = arr.length;
        sort(arr, 0, n-1);
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    // 测试 QuickSort
    public static void main(String[] args) {

        // Quick Sort也是一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("bobo.algo.QuickSort2", arr);
        
        int swapTimes = 100;
        assert swapTimes >= 0;
        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);
        arr = Arrays.copyOf(arr, arr.length);
        SortTestHelper.testSort("bobo.algo.QuickSort2", arr);

        return;
    }
}