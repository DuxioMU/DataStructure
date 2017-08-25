package bobo.algo;

import java.util.Arrays;

import org.junit.Test;
/**
 * 用于测试个种排序方法 的性能
 * @author ASUS
 *
 */
public class Main {
	
	
	
	// 比较Merge Sort和双路快速排序和三路快排三种排序算法的性能效率
    // 对于包含有大量重复数据的数组, 三路快排有巨大的优势
    // 对于一般性的随机数组和近乎有序的数组, 三路快排的效率虽然不是最优的, 但是是在非常可以接受的范围里
    // 因此, 在一些语言中, 三路快排是默认的语言库函数中使用的排序算法。比如Java:)
	@Test
    public void main10() {

        int N = 1000000;

        // 测试1 一般性测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("bobo.algo.MergeSort", arr1);
        SortTestHelper.testSort("bobo.algo.QuickSort2Ways", arr2);
        SortTestHelper.testSort("bobo.algo.QuickSort3Ways", arr3);

        System.out.println();


        // 测试2 测试近乎有序的数组
        int swapTimes = 100;
        assert swapTimes >= 0;

        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("bobo.algo.MergeSort", arr1);
        SortTestHelper.testSort("bobo.algo.QuickSort2Ways", arr2);
        SortTestHelper.testSort("bobo.algo.QuickSort3Ways", arr3);

        System.out.println();


        // 测试3 测试存在包含大量相同元素的数组
        System.out.println("Test for random array, size = " + N + " , random range [0,10]");

        arr1 = SortTestHelper.generateRandomArray(N, 0, 10);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("bobo.algo.MergeSort", arr1);
        SortTestHelper.testSort("bobo.algo.QuickSort2Ways", arr2);
        SortTestHelper.testSort("bobo.algo.QuickSort3Ways", arr3);
        
        return;
    }
	
	 // 比较Merge Sort和Quick Sort 2 Ways两种排序算法的性能效率
	@Test
    public  void main9() {

        int N = 1000000;

        // 测试1 一般性测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("bobo.algo.MergeSort2", arr1);
        SortTestHelper.testSort("bobo.algo.QuickSort2Ways", arr2);

        System.out.println();


        // 测试2 测试近乎有序的数组
        // 双路快速排序算法也可以轻松处理近乎有序的数组
        int swapTimes = 100;
        assert swapTimes >= 0;

        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("bobo.algo.MergeSort2", arr1);
        SortTestHelper.testSort("bobo.algo.QuickSort2Ways", arr2);

        System.out.println();


        // 测试3 测试存在包含大量相同元素的数组
        // 使用双快速排序后, 我们的快速排序算法可以轻松的处理包含大量元素的数组
        System.out.println("Test for random array, size = " + N + " , random range [0,10]");

        arr1 = SortTestHelper.generateRandomArray(N, 0, 10);
        arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("bobo.algo.MergeSort2", arr1);
        SortTestHelper.testSort("bobo.algo.QuickSort2Ways", arr2);


        return;
    }
    // 比较Merge Sort和Quick Sort两种排序算法的性能效率
    // 两种排序算法虽然都是O(nlogn)级别的, 但是Quick Sort算法有常数级的优势
    // Quick Sort要比Merge Sort快, 即使我们对Merge Sort进行了优化
	@Test
    public  void main8() {

        int N = 1000000;

        // 测试1 一般性测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("bobo.algo.MergeSort2", arr1);
        SortTestHelper.testSort("bobo.algo.QuickSort2", arr2);

        System.out.println();


        // 测试2 测试近乎有序的数组
        // 加入了随机选择标定点的步骤后, 我们的快速排序可以轻松处理近乎有序的数组
        // 但是对于近乎有序的数组, 其效率比优化后的归并排序要低, 但完全再容忍范围里
        // 思考一下为什么对于近乎有序的数组, 快排的性能比优化后的归并排序低? :)
        int swapTimes = 100;
        assert swapTimes >= 0;

        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("bobo.algo.MergeSort2", arr1);
        SortTestHelper.testSort("bobo.algo.QuickSort2", arr2);

        System.out.println();


        // 测试3 测试存在包含大量相同元素的数组
        // 但此时, 对于含有大量相同元素的数组, 我们的快速排序算法再次退化成了O(n^2)级别的算法
        // 思考一下为什么在这种情况下, 快排退化成了O(n^2)的算法? :)
        System.out.println("Test for random array, size = " + N + " , random range [0,10]");

        arr1 = SortTestHelper.generateRandomArray(N, 0, 10);
        arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("bobo.algo.MergeSort2", arr1);
        SortTestHelper.testSort("bobo.algo.QuickSort2", arr2);


        return;
    }
    // 比较Merge Sort和Quick Sort两种排序算法的性能效率
    // 两种排序算法虽然都是O(nlogn)级别的, 但是Quick Sort算法有常数级的优势
    // Quick Sort要比Merge Sort快, 即使我们对Merge Sort进行了优化
	@Test
    public void main7() {

        int N = 1000000;

        // 测试1 一般性测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("bobo.algo.MergeSort2", arr1);
        SortTestHelper.testSort("bobo.algo.QuickSort", arr2);

        System.out.println();


        // 测试2 测试近乎有序的数组
        // 但是对于近乎有序的数组, 我们的快速排序算法退化成了O(n^2)级别的算法
        // 思考一下为什么对于近乎有序的数组, 快排退化成了O(n^2)的算法? :)
        int swapTimes = 100;
        assert swapTimes >= 0;

        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("bobo.algo.MergeSort2", arr1);
        SortTestHelper.testSort("bobo.algo.QuickSort", arr2);

        
        return;
    }
    // 比较Merge Sort和Merge Sort Bottom Up两种排序算法的性能效率
    // 整体而言, 两种算法的效率是差不多的。但是如果进行仔细测试, 自底向上的归并排序会略胜一筹。
    // 更详细的测试, 可以参考课程的这个问题: http://coding.imooc.com/learn/questiondetail/3208.html
    // 本章节的代码仓也会给出更详细的测试代码
	@Test
    public void main6() {

        int N = 1000000;

        // 测试1 一般测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("bobo.algo.MergeSort", arr1);
        SortTestHelper.testSort("bobo.algo.MergeSortBU", arr2);

        System.out.println();


        // 测试2 测试近乎有序的数组
        int swapTimes = 10;
        assert swapTimes >= 0;

        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("bobo.algo.MergeSort", arr1);
        SortTestHelper.testSort("bobo.algo.MergeSortBU", arr2);

        return;
    }
	
    // 比较InsertionSort和MergeSort和MergeSort2两种排序算法的性能效率
    // 整体而言, MergeSort的性能最优, 对于近乎有序的数组的特殊情况, 见测试2的详细注释
	@Test
    public void main5() {

        int N = 50000;

        // 测试1 一般测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("bobo.algo.InsertionSort", arr1);
        SortTestHelper.testSort("bobo.algo.MergeSort", arr2);
        SortTestHelper.testSort("bobo.algo.MergeSort2", arr3);
        
        System.out.println();


        // 测试2 测试近乎有序的数组
        // 对于近乎有序的数组, 数组越有序, InsertionSort的时间性能越趋近于O(n)
        // 所以可以尝试, 当swapTimes比较大时, MergeSort更快
        // 但是当swapTimes小到一定程度, InsertionSort变得比MergeSort快
        int swapTimes = 10;
        assert swapTimes >= 0;

        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("bobo.algo.InsertionSort", arr1);
        SortTestHelper.testSort("bobo.algo.MergeSort", arr2);
        SortTestHelper.testSort("bobo.algo.MergeSort2", arr3);

        return;
    }
	
	@Test
	 // 比较SelectionSort, InsertionSort和BubbleSort和ShellSort四种排序算法的性能效率
    // ShellSort是这四种排序算法中性能最优的排序算法
    public void main4() {

        int N = 20000;

        // 测试1 一般测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr4 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("bobo.algo.SelectionSort", arr1);
        SortTestHelper.testSort("bobo.algo.InsertionSort", arr2);
        SortTestHelper.testSort("bobo.algo.BubbleSort", arr3);
        SortTestHelper.testSort("bobo.algo.ShellSort", arr4);

        System.out.println();


        // 测试2 测试近乎有序的数组
        int swapTimes = 100;
        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);
        arr4 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("bobo.algo.SelectionSort", arr1);
        SortTestHelper.testSort("bobo.algo.InsertionSort", arr2);
        SortTestHelper.testSort("bobo.algo.BubbleSort", arr3);
        SortTestHelper.testSort("bobo.algo.ShellSort", arr4);

        return;
    }
	
	@Test
	 // 比较SelectionSort, InsertionSort和BubbleSort三种排序算法的性能效率
    public  void main3() {

        int N = 20000;

        // 测试1 一般测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("bobo.algo.SelectionSort", arr1);
        SortTestHelper.testSort("bobo.algo.InsertionSort", arr2);
        SortTestHelper.testSort("bobo.algo.BubbleSort", arr3);

        System.out.println();


        // 测试2 测试近乎有序的数组
        int swapTimes = 100;
        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("bobo.algo.SelectionSort", arr1);
        SortTestHelper.testSort("bobo.algo.InsertionSort", arr2);
        SortTestHelper.testSort("bobo.algo.BubbleSort", arr3);

        return;
    }
	// 比较SelectionSort和InsertionSort两种排序算法的性能效率
    // 优化后，插入排序比选择排序性能略好
    // 对于有序性强的数组，插入排序远远优于选择排序
	@Test
    public  void main2() {

        int N = 20000;

        // 测试1 一般测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("bobo.algo.SelectionSort", arr1);
        SortTestHelper.testSort("bobo.algo.InsertionSort", arr2);

        System.out.println();


        // 测试2 有序性更强的测试(大量重复)
        System.out.println("Test for more ordered random array, size = " + N + " , random range [0,3]");

        arr1 = SortTestHelper.generateRandomArray(N, 0, 3);
        arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("bobo.algo.SelectionSort", arr1);
        SortTestHelper.testSort("bobo.algo.InsertionSort", arr2);

        System.out.println();


        // 测试3 测试近乎有序的数组
        int swapTimes = 100;
        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("bobo.algo.SelectionSort", arr1);
        SortTestHelper.testSort("bobo.algo.InsertionSort", arr2);

        return;
    }
	
	
	
	
	  // 比较SelectionSort和InsertionSort两种排序算法的性能效率
    // 此时，插入排序比选择排序性能略低
	@Test
    public  void main1() {

        int N = 20000;
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("bobo.algo.SelectionSort", arr1);
        SortTestHelper.testSort("bobo.algo.InsertionSort", arr2);

        return;
    }
}
