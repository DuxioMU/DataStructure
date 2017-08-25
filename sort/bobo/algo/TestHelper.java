package bobo.algo;

import java.util.*;

public class TestHelper {

    // SortTestHelper����������κ�ʵ��
    private TestHelper(){}

    // ����һ����ȫ���������
    public static Integer[] generateOrderedArray( int n ){

        Integer[] arr = new Integer[n];
        for( int i = 0 ; i < n ; i ++ )
            arr[i] = new Integer(i);

        return arr;
    }

    // ������arr�����
    public static void shuffleArray( Object[] arr ){

        int n = arr.length;
        for( int i = 0 ; i < n ; i ++ ){
            int j = (int)(Math.random() * (n-i)) + i;

            Object t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
    }
}