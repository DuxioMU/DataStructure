package bobo.graph.baisc;

import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;

/**
 * 使用广度优先遍历
 * 求无权图的
 * 一个点s到每个点的最短距离
 * @author Administrator
 *
 */
public class ShortestPath {
	
	private Graph G;
	private int s; //原始点
	private boolean[] visited; //用visited[i]记录i点是否被遍历过
	private int[] from; //记录路径,from[i]表示查找的路径上i的上一个节点.
	private int[] ord;	 //记录路径中节点的次序,ord[i]表示i点到s点的最短路径(层数)
	
	//构造函数,寻路算法,需找图graph从s点到其他点的路径
	public  ShortestPath(Graph graph, int s) {
		
		//算法初始化
		G = graph;
		assert s >= 0 && s < G.V();
		
		visited = new boolean[G.V()];
		from = new int[G.V()];
		ord = new int[G.V()];
		for(int i = 0 ;i < G.V(); i++) {
			visited[i] = false;
			from[i] = -1;
			ord[i] = -1;
		}
		this.s = s;
		
		//无向图最短路径算法,从s开始广度优先遍历整张图
		LinkedList<Integer> q = new LinkedList<Integer>();
		
		q.push(s);
		visited[s] = true;
		ord[s] = 0;
		while(!q.isEmpty()) {
			int v = q.pop();
			for(int i : G.adj(v))
				if( !visited[i]) { //没有遍历过
					q.push(i);
					visited[i] = true;
					from[i] = v ;
					ord[i] = ord[v] + 1;
				}
		}
	}
	
	//查询从s点到w点是否有路径
	public boolean hasPath(int w) {
		assert w >= 0 && w < G.V();
		return visited[w];
	}
	//插叙从s点到w点的路径,路径,存放到vec中
	public Vector<Integer> path(int w){
		
		assert hasPath(w);
		
		Stack<Integer> s = new Stack<Integer>();
		//通过from 数组逆向查找到从s到w的路径,存放到栈中
		int p = w ;
		while( p != -1) {
			s.push(p);
			p = from[p];
		}
		
		//从栈依次取出元素,获得顺序的从s到w的路径
		Vector<Integer> res = new Vector<Integer>();
		while(!s.empty())
			res.add(s.pop());
		return res;
	}
	
	//打印出从s点到w点的路径
	public  void showPath(int w) {
		
		assert hasPath(w);
		
		Vector<Integer> vec = path(w);
		for(int i = 0 ; i < vec.size(); i++) {
			System.out.print(vec.elementAt(i));
			if(i == vec.size()-1)
				System.out.println();
			else 
				System.out.print("->");
		}
	}
	
	//查看从s点到w点的最短路径长度
	//若从s到不可达,返回-1;
	public  int length(int w) {
		 assert w >= 0 && w < G.V();
		 return ord[w];
	}
	
}
