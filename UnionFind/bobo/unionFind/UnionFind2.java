package bobo.unionFind;

public class UnionFind2 {
	
	private int[] parent;
	private int count;
	
	public UnionFind2(int count) {
		parent = new int[count];
		this.count = count;
		for(int i = 0; i < count ; i ++)
			parent[i] = i;
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
	
	void unionElements(int p, int q) {
		
		int pRoot = find(p);
		int qRoot = find(q);
		
		if(pRoot == qRoot) 
			return;
		
		parent[pRoot] = qRoot;
	}
	
	
	
	
}
