package bobo.algo;

import java.util.Arrays;

import org.junit.Test;

public class Main2 {
	
	 // �Ƚ� Merge Sort, ���� Quick Sort ������ Heap Sort ������Ч��
    // ע��, �⼸�������㷨���� O(nlogn) ����������㷨
	@Test
    public void main15( ) {

        int N = 1000000;

        // ����1 һ���Բ���
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


        // ����2 ���Խ������������
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


        // ����3 ���Դ��ڰ���������ͬԪ�ص�����
        System.out.println("Test for random array, size = " + N + " , random range [0,10]");

        arr1 = SortTestHelper.generateRandomArray(N, 0, 10);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);
        arr4 = Arrays.copyOf(arr1, arr1.length);
        arr5 = Arrays.copyOf(arr1, arr1.length);
        arr6 = Arrays.copyOf(arr1, arr1.length);
        arr7 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("bobo.algo.MergeSort", arr1);
        // ���������, ��ͨ��QuickSort�˻�ΪO(n^2)���㷨, ��������
        //SortTestHelper.testSort("bobo.algo.QuickSort", arr2);
        SortTestHelper.testSort("bobo.algo.QuickSort2Ways", arr3);
        SortTestHelper.testSort("bobo.algo.QuickSort3Ways", arr4);
        SortTestHelper.testSort("bobo.algo.HeapSort1", arr5);
        SortTestHelper.testSort("bobo.algo.HeapSort2", arr6);
        SortTestHelper.testSort("bobo.algo.HeapSort", arr7);


        return;
    }
	
	 // �Ƚ� Shell Sort �� Merge Sort �� ���� Quick Sort ������Ч��
    // ʹ�ø���ѧ�ıȽϷ�ʽ, ÿ�αȽ϶����ж�β�������, ȡƽ��ֵ
    // ���Կ���, Shell Sort��Ȼ���ڸ߼�������ʽ, ����Ȼ�Ƿǳ��о�������һ�������㷨
    // �������ѵ�ʱ����ȫ�ڿ������̵ķ�Χ��, Զ����O(n^2)�������㷨, ���������ϴ��ʱ���޷�����
    // ͬʱ, Shell Sortʵ�ּ�, ֻʹ��ѭ���ķ�ʽ�����������, ����Ҫʵ�ֵݹ�, ��ռ��ϵͳռ�ռ�, Ҳ�����������
    // ����, ����㷨ʵ����ʹ�õĻ���������ʵ�ָ��ӵ������㷨, ��������Ŀ���̵Ĳ��Խ׶�, ��ȫ������ʱʹ��Shell Sort��������������:)
	@Test
    public  void main13() {

        // ����T����������, ÿ�����������������СΪn
        int T = 100;
        int N = 1000000;

        // �Ƚ� Shell Sort �� Merge Sort �� ���� Quick Sort ������Ч��
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
	  // �Ƚ� Merge Sort �� Merge Sort BU ������Ч��
    // ʹ�ø���ѧ�ıȽϷ�ʽ, ÿ�αȽ϶����ж�β�������, ȡƽ��ֵ
    // ͬʱ�Ƚ����Ż��Ͳ��Ż��������
    // ������˵, Merge Sort BU �� Merge Sort ��һЩ�����Ż���, ���ߵ����ܲ�಻����
    // ��������������ϸ����, ���Կ��γ̵��ʴ�:
    // http://coding.imooc.com/learn/questiondetail/3208.html
	@Test
    public void main12() {

        // ����T����������, ÿ�����������������СΪn
        int T = 100;
        int N = 1000000;

        // �Ƚ� Merge Sort �� Merge Sort BU �����㷨�ڲ��Ż�������µ�����Ч��
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


        // �Ƚ� Merge Sort �� Merge Sort BU �����㷨�ں��Ż�������µ�����Ч��
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

	// �Ƚ�Merge Sort��Merge Sort 3������Ч��
    // Merge Sort 3 ֻ������һ�θ����ռ�, ֮����������ռ��Բ�����ʽ���ݸ���ɹ鲢����������Ӻ���
    // ���Կ��� Merge Sort 3���������� Merge Sort
	@Test
    public void main11() {

        int N = 1000000;

        // ����1 һ���Բ���
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        
        SortTestHelper.testSort("bobo.algo.MergeSort", arr1);
        SortTestHelper.testSort("bobo.algo.MergeSort3", arr2);

        System.out.println();


        // ����2 ���Խ������������
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
