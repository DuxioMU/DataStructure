package bobo.unionFind;

public class UnionFind {
	
	private int count;
	private int[] id;
	public UnionFind(int n){
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
	
	//�ж��������Ƿ���ͬһ������
	public boolean isConnected(int p,int q) {
		return find(p) == find(q);
	}
	
	//������q�ϲ�������p���ڵļ���
	public void unionElements(int p ,int q) {
		
		int pID = find(p);
		int qID = find(q);
		if(pID == qID)
			return ;
		
		for(int i = 0;i<count; i++)
			if(id[i] == pID)
				id[i] =qID;
	}
	
	
	
}
