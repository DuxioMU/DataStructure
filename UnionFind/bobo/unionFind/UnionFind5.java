package bobo.unionFind;

/**
 * find(int p)过程
 * 路径压缩优化
 * @author ASUS
 *
 */
public class UnionFind5 {
	
	private int[] parent;
	private int[] rank; //rank[i]表示以i为根的集合中的所表示的树的层数
	private int count;
	
	public UnionFind5(int count) {
		parent = new int[count];
		rank = new int[count];
		this.count = count;
		for(int i = 0; i < count; i ++){
			parent[i] = i;
			rank[i] = 1;
		}
	}

    // 查找过程, 查找元素p所对应的集合编号
    // O(h)复杂度, h为树的高度
	int find(int p) {
		assert(p >= 0 && p < count);
		while(p != parent[p]) {
			//路径压缩,如果p的父亲节点不等于p
			//则让p的父节点指针 指向p的父节点的父节点
			parent[p] = parent[parent[p]];
			p = parent[p];
		}
		return p;
		//第二版 路径压缩 时间比第一版稍长
		/*if( p != parent[p])
			parent[p] = find(parent[p]);
		return parent[p];*/
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
