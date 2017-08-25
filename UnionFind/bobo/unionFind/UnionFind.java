package bobo.unionFind;

public class UnionFind {
	
	private int count;
	private int[] id;
	UnionFind(int n){
		this.count = n;
		id = new int[n];
		for(int i = 0; i < n; i++) {
			id[i]=i;
		}
	}
	
	public int find(int p) {
		assert(p>=0 && p < count);
		return id[p];
	}
	
	//判断两个数是否在同一个集合
	public boolean isConnected(int p,int q) {
		return find(p) == find(q);
	}
	
	//将整数q合并到整数p所在的集合
	void unionElements(int p ,int q) {
		
		int pID = find(p);
		int qID = find(q);
		if(pID == qID)
			return ;
		
		for(int i = 0;i<count; i++)
			if(id[i] == pID)
				id[i] =qID;
	}
	
	
	
}
