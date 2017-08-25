package bobo.algo;

import java.util.Arrays;

import org.junit.Test;

public class Main2 {
	
	 // 比较 Merge Sort, 三种 Quick Sort 和三种 Heap Sort 的性能效率
    // 注意, 这几种排序算法都是 O(nlogn) 级别的排序算法
	@Test
    public void main15( ) {

        int N = 1000000;

        // 测试1 一般性测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr4 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr5 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr6 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr7 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("bobo.algo.MergeSort", arr1);
        SortTestHelper.testSort("bobo.algo.QuickSort2", arr2);
        SortTestHelper.testSort("bobo.algo.QuickSort2Ways", arr3);
        SortTestHelper.testSort("bobo.algo.QuickSort3Ways", arr4);
        SortTestHelper.testSort("bobo.algo.HeapSort1", arr5);
        SortTestHelper.testSort("bobo.algo.HeapSort2", arr6);
        SortTestHelper.testSort("bobo.algo.HeapSort", arr7);

        System.out.println();


        // 测试2 测试近乎有序的数组
        int swapTimes = 100;
        assert swapTimes >= 0;

        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);
        arr4 = Arrays.copyOf(arr1, arr1.length);
        arr5 = Arrays.copyOf(arr1, arr1.length);
        arr6 = Arrays.copyOf(arr1, arr1.length);
        arr7 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("bobo.algo.MergeSort", arr1);
        SortTestHelper.testSort("bobo.algo.QuickSort2", arr2);
        SortTestHelper.testSort("bobo.algo.QuickSort2Ways", arr3);
        SortTestHelper.testSort("bobo.algo.QuickSort3Ways", arr4);
        SortTestHelper.testSort("bobo.algo.HeapSort1", arr5);
        SortTestHelper.testSort("bobo.algo.HeapSort2", arr6);
        SortTestHelper.testSort("bobo.algo.HeapSort", arr7);

        System.out.println();


        // 测试3 测试存在包含大量相同元素的数组
        System.out.println("Test for random array, size = " + N + " , random range [0,10]");

        arr1 = SortTestHelper.generateRandomArray(N, 0, 10);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);
        arr4 = Arrays.copyOf(arr1, arr1.length);
        arr5 = Arrays.copyOf(arr1, arr1.length);
        arr6 = Arrays.copyOf(arr1, arr1.length);
        arr7 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("bobo.algo.MergeSort", arr1);
        // 这种情况下, 普通的QuickSort退化为O(n^2)的算法, 不做测试
        //SortTestHelper.testSort("bobo.algo.QuickSort", arr2);
        SortTestHelper.testSort("bobo.algo.QuickSort2Ways", arr3);
        SortTestHelper.testSort("bobo.algo.QuickSort3Ways", arr4);
        SortTestHelper.testSort("bobo.algo.HeapSort1", arr5);
        SortTestHelper.testSort("bobo.algo.HeapSort2", arr6);
        SortTestHelper.testSort("bobo.algo.HeapSort", arr7);


        return;
    }
	
	 // 比较 Shell Sort 和 Merge Sort 和 三种 Quick Sort 的性能效率
    // 使用更科学的比较方式, 每次比较都运行多次测试用例, 取平均值
    // 可以看出, Shell Sort虽然慢于高级的排序方式, 但仍然是非常有竞争力的一种排序算法
    // 其所花费的时间完全在可以容忍的范围内, 远不像O(n^2)的排序算法, 在数据量较大的时候无法忍受
    // 同时, Shell Sort实现简单, 只使用循环的方式解决排序问题, 不需要实现递归, 不占用系统占空间, 也不依赖随机数
    // 所以, 如果算法实现所使用的环境不利于实现复杂的排序算法, 或者在项目工程的测试阶段, 完全可以暂时使用Shell Sort来进行排序任务:)
	@Test
    public  void main13() {

        // 测试T个测试用例, 每个测试用例的数组大小为n
        int T = 100;
        int N = 1000000;

        // 比较 Shell Sort 和 Merge Sort 和 三种 Quick Sort 的性能效率
        long time1 = 0, time2 = 0, time3 = 0, time4 = 0, time5 = 0;
        for( int i = 0 ; i < T ; i ++ ) {
            Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
            Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
            Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
            Integer[] arr4 = Arrays.copyOf(arr1, arr1.length);
            Integer[] arr5 = Arrays.copyOf(arr1, arr1.length);

            time1 += SortTestHelper.testSort2("bobo.algo.ShellSort", arr1);
            time2 += SortTestHelper.testSort2("bobo.algo.MergeSort", arr2);
            time3 += SortTestHelper.testSort2("bobo.algo.QuickSort", arr3);
            time4 += SortTestHelper.testSort2("bobo.algo.QuickSort2Ways", arr4);
            time5 += SortTestHelper.testSort2("bobo.algo.QuickSort3Ways", arr5);
        }
        System.out.println("Sorting " + N + " elements " + T + " times. Calculate the average run time.");
        System.out.println("Shell Sort        Average Run Time: " + time1/T + " ms");
        System.out.println("Merge Sort        Average Run Time: " + time2/T + " ms");
        System.out.println("Quick Sort        Average Run Time: " + time3/T + " ms");
        System.out.println("Quick Sort 2 Ways Average Run Time: " + time4/T + " ms");
        System.out.println("Quick Sort 3 Ways Average Run Time: " + time5/T + " ms");


        return;
    }
	  // 比较 Merge Sort 和 Merge Sort BU 的性能效率
    // 使用更科学的比较方式, 每次比较都运行多次测试用例, 取平均值
    // 同时比较了优化和不优化两种情况
    // 总体来说, Merge Sort BU 比 Merge Sort 快一些。但优化后, 二者的性能差距不明显
    // 对于这个问题更详细分析, 可以看课程的问答:
    // http://coding.imooc.com/learn/questiondetail/3208.html
	@Test
    public void main12() {

        // 测试T个测试用例, 每个测试用例的数组大小为n
        int T = 100;
        int N = 1000000;

        // 比较 Merge Sort 和 Merge Sort BU 两种算法在不优化的情况下的性能效率
        long time1 = 0, time2 = 0;
        for( int i = 0 ; i < T ; i ++ ) {
            Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
            Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);

            time1 += SortTestHelper.testSort2("bobo.algo.MergeSort", arr1);
            time2 += SortTestHelper.testSort2("bobo.algo.MergeSortBU", arr2);
        }
        System.out.println("Without Any Optimization:");
        System.out.println("Merge Sort    Average Run Time: " + time1/T + " ms");
        System.out.println("Merge Sort BU Average Run Time: " + time2/T + " ms");
        System.out.println();


        // 比较 Merge Sort 和 Merge Sort BU 两种算法在含优化的情况下的性能效率
        time1 = 0; time2 = 0;
        for( int i = 0 ; i < T ; i ++ ) {
            Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
            Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);

            time1 += SortTestHelper.testSort2("bobo.algo.MergeSort3", arr1);
            time2 += SortTestHelper.testSort2("bobo.algo.MergeSortBU3", arr2);
        }
        System.out.println("With Optimization:");
        System.out.println("Merge Sort    Average Run Time: " + time1/T + " ms");
        System.out.println("Merge Sort BU Average Run Time: " + time2/T + " ms");


        return;
    }	

	// 比较Merge Sort和Merge Sort 3的性能效率
    // Merge Sort 3 只开辟了一次辅助空间, 之后将这个辅助空间以参数形式传递给完成归并排序的其他子函数
    // 可以看出 Merge Sort 3的性能优于 Merge Sort
	@Test
    public void main11() {

        int N = 1000000;

        // 测试1 一般性测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        
        SortTestHelper.testSort("bobo.algo.MergeSort", arr1);
        SortTestHelper.testSort("bobo.algo.MergeSort3", arr2);

        System.out.println();


        // 测试2 测试近乎有序的数组
        int swapTimes = 100;
        assert swapTimes >= 0;

        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("bobo.algo.MergeSort", arr1);
        SortTestHelper.testSort("bobo.algo.MergeSort3", arr2);

        System.out.println();
        return;
    }
}
