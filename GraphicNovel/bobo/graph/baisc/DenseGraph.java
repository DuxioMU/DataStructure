package bobo.graph.baisc;

import java.util.ArrayList;
import java.util.Vector;

//����ͼ-�ڽӾ���
@SuppressWarnings("rawtypes")
public class DenseGraph implements Graph{
	
	private int n,m;//节点,边数
	private boolean directed;//是否为有向图
	private	boolean[][] g;
	
	public DenseGraph(int n ,boolean directed) {
		this.n = n;
		this.m = 0;
		this.directed = directed;
		g = new boolean[n][n];
	}
	
	public int V() {
		return n;
	}
	public int E() {
		return m;
	}
	//1.��ͼ�����һ����
	public void addEdge(int v ,int w) {
		
		assert v >= 0 && v < n;
		assert w >= 0 && w < n;
		
		if(hasEdge( v, w))
			return;
		
		g[v][w] = true;
		
		if(!directed)//����ͼ
			g[w][v] = true;
		m ++;
	}
	//��֤ͼ���Ƿ��д�v��w�ı�
	public boolean hasEdge(int v,int w){
		assert v >= 0 && v < n ;
		assert w >= 0 && w < n ;
		return g[v][w];
	}
	
	//3.��ʾͼ��Ϣ
    public void show(){

        for( int i = 0 ; i < n ; i ++ ){
            for( int j = 0 ; j < n ; j ++ )
                System.out.print(g[i][j]+"\t");
            System.out.println();
        }
    }
	//2.����ͼ��һ������������ٱ�
	//����javaʹ�õ����û���,����һ��Vector����������⿪��
	public Iterable<Integer> adj(int v ){
		assert v >= 0 && v < n;
		Vector<Integer> adjv = new Vector<Integer>();
		for(int i = 0 ;i < n ; i ++)
			if( g[v][i])
				adjv.add(i);
		return adjv;
	}
	
	
}
