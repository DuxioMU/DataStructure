package bobo.unionFind;

public class UnionFind4 {
	
	private int[] parent;
	private int[] rank; //rank[i]表示以i为根的集合中的所表示的树的层数
	private int count;
	
	public UnionFind4(int count) {
		parent = new int[count];
		rank = new int[count];
		this.count = count;
		for(int i = 0; i < count; i ++){
			parent[i] = i;
			rank[i] = 1;
		}
	}
	
	int find(int p) {
		assert(p >= 0 && p < count);
		while(p != parent[p])
			p = parent[p];
		return p;
	}
	
	boolean isConnected(int p,int q) {
		return find(p) == find(q);
	}
	
	//将元素少的根元素并到元素较少的根元素
	//并不完全准确 判断树的高度 基于Rank优化可以解决这个问题
	void unionElements(int p ,int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		
		if(pRoot == qRoot)
			return;
		
		if(rank[pRoot] < rank[qRoot]) {
			parent[pRoot] = qRoot;
		}else if(rank[pRoot] > rank[qRoot]) {
			parent[qRoot] = rank[pRoot];
		}else {
			parent[qRoot] = pRoot;
			rank[pRoot] ++;
		}
	}
}
