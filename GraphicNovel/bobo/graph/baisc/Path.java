package bobo.graph.baisc;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;


//深度优先遍历的过程中存储路径
public class Path {
	
	private Graph G; //图引用
	private int s;		//起始点
	private boolean[] visited; //记录dfs的过程中节点是否被访问
	private int[] from;	//记录路径,from[i]表示查找的路径上i的上一个节点
	
	//1.构造函数 ,寻路算法,寻找图graph从s点到其他点的路径
	public Path(Graph graph,int s) {
		//算法初始化
		this.G = graph;
		assert s >= 0 && s < G.V();
		
		visited = new boolean[G.V()];
		from = new  int[G.V()];
		for( int i = 0 ; i < G.V() ; i++) {
			visited[i] =false;
			from[i] = -1;
		}
		this.s = s;
		
		//寻路算法
		dfs(s);
	}
	
	//2.深度优先遍历
	public void dfs(int v) {
		
		visited[v] = true;
		
		for(int i: G.adj(v)) {//遍历节点v 的临边(相连节点)i
			if(!visited[i]) {
				from[i] = v;  //记录i节点的上一个节点
				dfs(i);
			}
		}
	}
	//查询从s点到w点是否有路径
	boolean hasPath(int w) {
		assert w >= 0 && w < G.V();
		return visited[w];
	}
	//查询从s点到w点的路径,存入vec中
	Vector<Integer> path(int w ) {
		
		assert hasPath(w);
		
		Stack<Integer> s = new Stack<Integer>();
		//通过from数组逆序查找到从s到w的路径,存放到栈中
		
		int p = w;
		while( p != -1 ) {
			s.push(p);
			p = from[p];
		}
		
		//从栈中依次取出元素,获得顺序从s到w的路径
		Vector<Integer> res = new Vector<Integer>(); 
		while( !s.isEmpty()) 
			res.add(s.pop());
		return res;
	}
	//打印出从点s到w点的路径
	void showPath(int w) {
		
		assert hasPath(w);
		
		Vector<Integer> vec = path(w);
		for(int i = 0 ; i < vec.size(); i ++) {
			System.out.print(vec.elementAt(i));
			if(i == vec.size() -1) 
				System.out.println();
			else
				System.out.print("->");
		}	
	}
	
}
