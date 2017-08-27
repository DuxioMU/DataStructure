package bobo.graph.minSpanTrees;

import java.util.ArrayList;
import java.util.Vector;

//稠密图---邻接矩阵
@SuppressWarnings("rawtypes")
public class DenseWeightedGraph <Weight extends Number & Comparable>
		implements WeightedGraph{
	
	private int n,m;//节点,边数
	private boolean directed;//是否为有向图
	private	 Edge<Weight>[][] g; //图的具体数据
	
	public DenseWeightedGraph(int n ,boolean directed) {
		this.n = n;
		this.m = 0;
		this.directed = directed;
		//g初始化为 n* n 的布尔型矩阵,每个g[i][j] 均未空,表示没有任何边
		//false为boolean型变量的默认值
		g = new Edge[n][n];
		for(int i = 0 ; i < n ; i ++)
			for(int j = 0; j < n ; j ++)
				g[i][j] = null;
	}
	
	public int V() {
		return n;
	}
	public int E() {
		return m;
	}
	//1.��ͼ�����һ����
	public void addEdge(Edge e) {
		
		assert e.v() >= 0 && e.v() < n;
		assert e.w() >= 0 && e.w() < n;
		
		if(hasEdge( e.v(), e.w()))
			return;
		
		g[e.v()][e.w()] = new Edge<Weight>(e);
		
		if(e.v() != e.w() && !directed)//����ͼ
			g[e.w()][e.v()] = new Edge(e.w(),e.v(),e.wt());
		m ++;
	}
	//��֤ͼ���Ƿ��д�v��w�ı�
	public boolean hasEdge(int v,int w){
		assert v >= 0 && v < n ;
		assert w >= 0 && w < n ;
		return g[v][w] != null;
	}
	
	//3.��ʾͼ��Ϣ
    public void show(){

        for( int i = 0 ; i < n ; i ++ ){
            for( int j = 0 ; j < n ; j ++ )
            	if(g[i][j] != null)
            		System.out.print(g[i][j].wt()+"\t");
            	else
            		System.out.print("NULL\t");
            System.out.println();
        }
    }
	//2.返回图中一个顶点的所有临边
    // 由于java使用引用机制,返回一个Vector不会带来额外开销
	public Iterable<Edge<Weight>> adj(int v ){
		assert v >= 0 && v < n;
		Vector<Edge<Weight>> adjv = new Vector<Edge<Weight>>();
		for(int i = 0 ;i < n ; i ++)
			if( g[v][i] != null)
				adjv.add(g[v][i]);
		return adjv;
	}

	
	
}
