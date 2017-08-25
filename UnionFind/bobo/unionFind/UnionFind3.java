package bobo.unionFind;

public class UnionFind3 {
	
	private int[] parent;
	private int[] sz; //sz[i]��ʾ��iΪ���ļ����е�Ԫ�ظ���
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
	
	//��Ԫ���ٵĸ�Ԫ�ز���Ԫ�ؽ��ٵĸ�Ԫ��
	//������ȫ׼ȷ �ж����ĸ߶� ����Rank�Ż����Խ���������
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
