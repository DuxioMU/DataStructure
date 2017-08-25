package bobo.unionFind;

public class UnionFind4 {
	
	private int[] parent;
	private int[] rank; //rank[i]��ʾ��iΪ���ļ����е�����ʾ�����Ĳ���
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
	
	//��Ԫ���ٵĸ�Ԫ�ز���Ԫ�ؽ��ٵĸ�Ԫ��
	//������ȫ׼ȷ �ж����ĸ߶� ����Rank�Ż����Խ���������
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
