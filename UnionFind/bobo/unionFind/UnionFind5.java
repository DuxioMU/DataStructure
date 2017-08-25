package bobo.unionFind;

/**
 * find(int p)����
 * ·��ѹ���Ż�
 * @author ASUS
 *
 */
public class UnionFind5 {
	
	private int[] parent;
	private int[] rank; //rank[i]��ʾ��iΪ���ļ����е�����ʾ�����Ĳ���
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

    // ���ҹ���, ����Ԫ��p����Ӧ�ļ��ϱ��
    // O(h)���Ӷ�, hΪ���ĸ߶�
	int find(int p) {
		assert(p >= 0 && p < count);
		while(p != parent[p]) {
			//·��ѹ��,���p�ĸ��׽ڵ㲻����p
			//����p�ĸ��ڵ�ָ�� ָ��p�ĸ��ڵ�ĸ��ڵ�
			parent[p] = parent[parent[p]];
			p = parent[p];
		}
		return p;
		//�ڶ��� ·��ѹ�� ʱ��ȵ�һ���Գ�
		/*if( p != parent[p])
			parent[p] = find(parent[p]);
		return parent[p];*/
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
