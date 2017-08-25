package bobo.unionFind;

public class UnionFindTestHelper {
	
	//测试第一版的并查集
	public static void testUF1(int n) {
		UnionFind uf = new UnionFind(n);
		
		long startTime = System.currentTimeMillis();
		
		//进行n次操作,每次随机选择两个元素进行合并操作
		for(int i = 0; i < n;i++){
			int a = (int)(Math.random()*n);
			int b = (int)(Math.random()*n);
			uf.unionElements(a, b);
		}
		
		//在进行n次操作,每次随机选择两个元素,插叙他们是否同属一个集合
		for(int i = 0; i < n ; i ++) {
			int a = (int)(Math.random()*n);
			int b = (int)(Math.random()*n);
			uf.isConnected(a, b);
		}
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("UF1," +2*n+"ops,"+(endTime-startTime)+"ms");
	}
	
	public static void testUF2(int n) {
		UnionFind2 uf2 = new UnionFind2(n);
		
		long startTime = System.currentTimeMillis();
		
		//进行n次操作,每次随机选择两个元素进行合并操作
		for(int i = 0; i < n;i++){
			int a = (int)(Math.random()*n);
			int b = (int)(Math.random()*n);
			uf2.unionElements(a, b);
		}
		
		//在进行n次操作,每次随机选择两个元素,插叙他们是否同属一个集合
		for(int i = 0; i < n ; i ++) {
			int a = (int)(Math.random()*n);
			int b = (int)(Math.random()*n);
			uf2.isConnected(a, b);
		}
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("UF2," +2*n+"ops,"+(endTime-startTime)+"ms");
	}
	public static void testUF3(int n) {
		UnionFind3 uf2 = new UnionFind3(n);
		
		long startTime = System.currentTimeMillis();
		
		//进行n次操作,每次随机选择两个元素进行合并操作
		for(int i = 0; i < n;i++){
			int a = (int)(Math.random()*n);
			int b = (int)(Math.random()*n);
			uf2.unionElements(a, b);
		}
		
		//在进行n次操作,每次随机选择两个元素,插叙他们是否同属一个集合
		for(int i = 0; i < n ; i ++) {
			int a = (int)(Math.random()*n);
			int b = (int)(Math.random()*n);
			uf2.isConnected(a, b);
		}
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("UF3," +2*n+"ops,"+(endTime-startTime)+"ms");
	}
	
	public static void testUF4(int n) {
		UnionFind4 uf2 = new UnionFind4(n);
		
		long startTime = System.currentTimeMillis();
		
		//进行n次操作,每次随机选择两个元素进行合并操作
		for(int i = 0; i < n;i++){
			int a = (int)(Math.random()*n);
			int b = (int)(Math.random()*n);
			uf2.unionElements(a, b);
		}
		
		//在进行n次操作,每次随机选择两个元素,插叙他们是否同属一个集合
		for(int i = 0; i < n ; i ++) {
			int a = (int)(Math.random()*n);
			int b = (int)(Math.random()*n);
			uf2.isConnected(a, b);
		}
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("UF4," +2*n+"ops,"+(endTime-startTime)+"ms");
	}
	
	public static void testUF5(int n) {
		UnionFind5 uf2 = new UnionFind5(n);
		
		long startTime = System.currentTimeMillis();
		
		//进行n次操作,每次随机选择两个元素进行合并操作
		for(int i = 0; i < n;i++){
			int a = (int)(Math.random()*n);
			int b = (int)(Math.random()*n);
			uf2.unionElements(a, b);
		}
		
		//在进行n次操作,每次随机选择两个元素,插叙他们是否同属一个集合
		for(int i = 0; i < n ; i ++) {
			int a = (int)(Math.random()*n);
			int b = (int)(Math.random()*n);
			uf2.isConnected(a, b);
		}
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("UF5," +2*n+"ops,"+(endTime-startTime)+"ms");
	}
	
}
