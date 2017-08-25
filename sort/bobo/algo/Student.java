package bobo.algo;

import java.util.*;

public class Student implements Comparable<Student> {

    private String name;
    private int score;

    public Student(String name, int score){
        this.name = name;
        this.score = score;
    }

    // ����Student��compareTo����
    // ���������ȣ��������ֵ���ĸ������
    // ����������ȣ�������ߵĿ�ǰ
    @Override
    public int compareTo(Student that) {

        if( this.score == that.score )
            return this.name.compareTo(that.name);

        if( this.score < that.score )
            return 1;
        else if( this.score > that.score )
            return -1;
        else // this.score == that.score
            return 0;
    }

    // ����Studentʵ���Ĵ�ӡ�����ʽ
    @Override
    public String toString() {
        return "Student: " + this.name + " " + Integer.toString( this.score );
    }
}