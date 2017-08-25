package bobo.algo;

import java.util.Arrays;

import org.junit.Test;
/**
 * ���ڲ��Ը������򷽷� ������
 * @author ASUS
 *
 */
public class Main {
	
	
	
	// �Ƚ�Merge Sort��˫·�����������·�������������㷨������Ч��
    // ���ڰ����д����ظ����ݵ�����, ��·�����о޴������
    // ����һ���Ե��������ͽ������������, ��·���ŵ�Ч����Ȼ�������ŵ�, �������ڷǳ����Խ��ܵķ�Χ��
    // ���, ��һЩ������, ��·������Ĭ�ϵ����Կ⺯����ʹ�õ������㷨������Java:)
	@Test
    public void main10() {

        int N = 1000000;

        // ����1 һ���Բ���
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("bobo.algo.MergeSort", arr1);
        SortTestHelper.testSort("bobo.algo.QuickSort2Ways", arr2);
        SortTestHelper.testSort("bobo.algo.QuickSort3Ways", arr3);

        System.out.println();


        // ����2 ���Խ������������
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


        // ����3 ���Դ��ڰ���������ͬԪ�ص�����
        System.out.println("Test for random array, size = " + N + " , random range [0,10]");

        arr1 = SortTestHelper.generateRandomArray(N, 0, 10);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("bobo.algo.MergeSort", arr1);
        SortTestHelper.testSort("bobo.algo.QuickSort2Ways", arr2);
        SortTestHelper.testSort("bobo.algo.QuickSort3Ways", arr3);
        
        return;
    }
	
	 // �Ƚ�Merge Sort��Quick Sort 2 Ways���������㷨������Ч��
	@Test
    public  void main9() {

        int N = 1000000;

        // ����1 һ���Բ���
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("bobo.algo.MergeSort2", arr1);
        SortTestHelper.testSort("bobo.algo.QuickSort2Ways", arr2);

        System.out.println();


        // ����2 ���Խ������������
        // ˫·���������㷨Ҳ�������ɴ���������������
        int swapTimes = 100;
        assert swapTimes >= 0;

        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("bobo.algo.MergeSort2", arr1);
        SortTestHelper.testSort("bobo.algo.QuickSort2Ways", arr2);

        System.out.println();


        // ����3 ���Դ��ڰ���������ͬԪ�ص�����
        // ʹ��˫���������, ���ǵĿ��������㷨�������ɵĴ����������Ԫ�ص�����
        System.out.println("Test for random array, size = " + N + " , random range [0,10]");

        arr1 = SortTestHelper.generateRandomArray(N, 0, 10);
        arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("bobo.algo.MergeSort2", arr1);
        SortTestHelper.testSort("bobo.algo.QuickSort2Ways", arr2);


        return;
    }
    // �Ƚ�Merge Sort��Quick Sort���������㷨������Ч��
    // ���������㷨��Ȼ����O(nlogn)�����, ����Quick Sort�㷨�г�����������
    // Quick SortҪ��Merge Sort��, ��ʹ���Ƕ�Merge Sort�������Ż�
	@Test
    public  void main8() {

        int N = 1000000;

        // ����1 һ���Բ���
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("bobo.algo.MergeSort2", arr1);
        SortTestHelper.testSort("bobo.algo.QuickSort2", arr2);

        System.out.println();


        // ����2 ���Խ������������
        // ���������ѡ��궨��Ĳ����, ���ǵĿ�������������ɴ���������������
        // ���Ƕ��ڽ������������, ��Ч�ʱ��Ż���Ĺ鲢����Ҫ��, ����ȫ�����̷�Χ��
        // ˼��һ��Ϊʲô���ڽ������������, ���ŵ����ܱ��Ż���Ĺ鲢�����? :)
        int swapTimes = 100;
        assert swapTimes >= 0;

        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("bobo.algo.MergeSort2", arr1);
        SortTestHelper.testSort("bobo.algo.QuickSort2", arr2);

        System.out.println();


        // ����3 ���Դ��ڰ���������ͬԪ�ص�����
        // ����ʱ, ���ں��д�����ͬԪ�ص�����, ���ǵĿ��������㷨�ٴ��˻�����O(n^2)������㷨
        // ˼��һ��Ϊʲô�����������, �����˻�����O(n^2)���㷨? :)
        System.out.println("Test for random array, size = " + N + " , random range [0,10]");

        arr1 = SortTestHelper.generateRandomArray(N, 0, 10);
        arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("bobo.algo.MergeSort2", arr1);
        SortTestHelper.testSort("bobo.algo.QuickSort2", arr2);


        return;
    }
    // �Ƚ�Merge Sort��Quick Sort���������㷨������Ч��
    // ���������㷨��Ȼ����O(nlogn)�����, ����Quick Sort�㷨�г�����������
    // Quick SortҪ��Merge Sort��, ��ʹ���Ƕ�Merge Sort�������Ż�
	@Test
    public void main7() {

        int N = 1000000;

        // ����1 һ���Բ���
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("bobo.algo.MergeSort2", arr1);
        SortTestHelper.testSort("bobo.algo.QuickSort", arr2);

        System.out.println();


        // ����2 ���Խ������������
        // ���Ƕ��ڽ������������, ���ǵĿ��������㷨�˻�����O(n^2)������㷨
        // ˼��һ��Ϊʲô���ڽ������������, �����˻�����O(n^2)���㷨? :)
        int swapTimes = 100;
        assert swapTimes >= 0;

        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("bobo.algo.MergeSort2", arr1);
        SortTestHelper.testSort("bobo.algo.QuickSort", arr2);

        
        return;
    }
    // �Ƚ�Merge Sort��Merge Sort Bottom Up���������㷨������Ч��
    // �������, �����㷨��Ч���ǲ��ġ��������������ϸ����, �Ե����ϵĹ鲢�������ʤһ�
    // ����ϸ�Ĳ���, ���Բο��γ̵��������: http://coding.imooc.com/learn/questiondetail/3208.html
    // ���½ڵĴ����Ҳ���������ϸ�Ĳ��Դ���
	@Test
    public void main6() {

        int N = 1000000;

        // ����1 һ�����
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("bobo.algo.MergeSort", arr1);
        SortTestHelper.testSort("bobo.algo.MergeSortBU", arr2);

        System.out.println();


        // ����2 ���Խ������������
        int swapTimes = 10;
        assert swapTimes >= 0;

        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("bobo.algo.MergeSort", arr1);
        SortTestHelper.testSort("bobo.algo.MergeSortBU", arr2);

        return;
    }
	
    // �Ƚ�InsertionSort��MergeSort��MergeSort2���������㷨������Ч��
    // �������, MergeSort����������, ���ڽ��������������������, ������2����ϸע��
	@Test
    public void main5() {

        int N = 50000;

        // ����1 һ�����
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("bobo.algo.InsertionSort", arr1);
        SortTestHelper.testSort("bobo.algo.MergeSort", arr2);
        SortTestHelper.testSort("bobo.algo.MergeSort2", arr3);
        
        System.out.println();


        // ����2 ���Խ������������
        // ���ڽ������������, ����Խ����, InsertionSort��ʱ������Խ������O(n)
        // ���Կ��Գ���, ��swapTimes�Ƚϴ�ʱ, MergeSort����
        // ���ǵ�swapTimesС��һ���̶�, InsertionSort��ñ�MergeSort��
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
	 // �Ƚ�SelectionSort, InsertionSort��BubbleSort��ShellSort���������㷨������Ч��
    // ShellSort�������������㷨���������ŵ������㷨
    public void main4() {

        int N = 20000;

        // ����1 һ�����
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


        // ����2 ���Խ������������
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
	 // �Ƚ�SelectionSort, InsertionSort��BubbleSort���������㷨������Ч��
    public  void main3() {

        int N = 20000;

        // ����1 һ�����
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("bobo.algo.SelectionSort", arr1);
        SortTestHelper.testSort("bobo.algo.InsertionSort", arr2);
        SortTestHelper.testSort("bobo.algo.BubbleSort", arr3);

        System.out.println();


        // ����2 ���Խ������������
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
	// �Ƚ�SelectionSort��InsertionSort���������㷨������Ч��
    // �Ż��󣬲��������ѡ�����������Ժ�
    // ����������ǿ�����飬��������ԶԶ����ѡ������
	@Test
    public  void main2() {

        int N = 20000;

        // ����1 һ�����
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("bobo.algo.SelectionSort", arr1);
        SortTestHelper.testSort("bobo.algo.InsertionSort", arr2);

        System.out.println();


        // ����2 �����Ը�ǿ�Ĳ���(�����ظ�)
        System.out.println("Test for more ordered random array, size = " + N + " , random range [0,3]");

        arr1 = SortTestHelper.generateRandomArray(N, 0, 3);
        arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("bobo.algo.SelectionSort", arr1);
        SortTestHelper.testSort("bobo.algo.InsertionSort", arr2);

        System.out.println();


        // ����3 ���Խ������������
        int swapTimes = 100;
        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("bobo.algo.SelectionSort", arr1);
        SortTestHelper.testSort("bobo.algo.InsertionSort", arr2);

        return;
    }
	
	
	
	
	  // �Ƚ�SelectionSort��InsertionSort���������㷨������Ч��
    // ��ʱ�����������ѡ�����������Ե�
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
