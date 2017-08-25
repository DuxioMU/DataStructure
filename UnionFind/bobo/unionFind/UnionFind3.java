package bobo.unionFind;

public class UnionFind3 {
	
	private int[] parent;
	private int[] sz; //sz[i]表示以i为根的集合中的元素个数
	private int count;
	
	public UnionFind3(int count) {
		parent = new int[count];
		sz = new int[count];
		this.count = count;
		for(int i = 0; i < count; i ++){
			parent[i] = i;
			sz[i] = 1;
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
		
		if(sz[pRoot] < sz[qRoot]) {
			parent[pRoot] = qRoot;
			sz[qRoot] += sz[pRoot];
		}else {
			parent[qRoot] = pRoot;
			sz[pRoot] += sz[qRoot];
		}
	}
}
