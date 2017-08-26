package bobo.graph.baisc;

//求图的连通分量
public class Component {
	
	private Graph G;
	private boolean[] visited;//用于标记已遍历节点
	private int ccount;//连通分量个数
	private int[] id; 	//每个节点所对应的连通分量标记(用于测试是否连接)
	
	//1.构造函数,求出无权图的连通分量(节点(临边)数组的表示值相同)
	public Component(Graph graph) {
		//算法初始化
		this.G = graph;
		visited = new boolean[G.V()];
		ccount = 0;
		id = new int[G.V()];
		for(int i = 0 ; i < G.V(); i++) {
			visited[i] = false;
			id[i] = -1;
		}
		
		//求图的连通分量
		for(int i = 0 ; i < G.V(); i ++	) {
			if( !visited[i]) {
				dfs(i);
				ccount ++;
			}
		}
	}
	//2.图的的深度优先遍历
	public void dfs(int v) {
		visited[v] = true;
		id[v] = ccount;
		
		for(int i: G.adj(v)) {//遍历所有临边(相邻节点)i表示相邻节点
			if(!visited[i]) {
				dfs(i);
			}
		}
	}
	//3.插叙点v和点w是否连通
	public boolean isConnection(int v , int w) {
		assert v >= 0 && v < G.V();
		assert w >= 0 && w < G.V();
		return id[v] == id[w];
	}
	
	//返回连通分量个数
	public int count() {
		return ccount;
	}
	
}
