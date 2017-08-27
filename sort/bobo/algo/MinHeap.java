package bobo.algo;

/**
 * 在堆中的有关操作中,需要比较堆中元素的大小,所以Item需要extends Comparable
 * @author Administrator
 *
 * @param <Item>
 */
public class MinHeap <Item extends Comparable>{
	
	protected Item[] data; //节点在堆中节点的位置 n 2n+1 2n+2
	protected int count;	//节点个数
	protected  int capacity;	//堆的容量
	
	// 构造函数,构造一个空堆,可容纳capacity个元素
	public  MinHeap(int capacity) {
		data = (Item[]) new Comparable[capacity + 1];
		count = 0;
		this.capacity = capacity;
	}
	
	//构造函数,通过给定数组创建一个最小堆
	//该构造堆的过程,时间复杂对为O(n);
	public MinHeap(Item arr[]) {
		
		int  n = arr.length;
		
		data = (Item[])new Comparable[n + 1];
		capacity = n;
		
		for(int i = 0 ; i < n ; i ++ )
			data[i+1] = arr[i];
		count = n;
		
		for(int i = count/2 ;i >= 1 ; i --)
			shiftDown(i);
	}
	
	public  int size() {
		return count;
	}
	
	public boolean isEmpty() {
		return count == 0;
	}
	
	public void insert (Item item) {
		assert count+1 <= capacity;
		data[count+1] = item;
		count ++;
		shiftUp(count);
	}
	
	public Item extractMin() {
		assert count > 0;
		Item ret = data[1];
		
		swap(1 ,count);
		count --;
		shiftDown(1);
		
		return ret;
	}
	
	//*******************
	//***核心函数
	//*******************
	private void shiftDown(int k) {
		
		while(2*k <= count	) {
			int j = 2*k;//在此轮循环中,data[k]和data[j] 交换位置
			if(j+1 <= count && data[j+1].compareTo(data[j] )< 0 )
				j ++;
			//data[j] 是data[2*k] 和data[2*k+1]中的最小值
			if (data[k].compareTo(data[j])<=0) break;
			swap(k,j);
			k = j;
		}
	}
	
	private void shiftUp(int k) {
		
		while(k > 1 && data[k/2].compareTo(data[k] )< 0){
			swap(k,k/2);
			k/=2;
		}
	}
	
	private void swap(int k ,int j) {
		Item  t = data[k];
		data[k] = data[j];
		data[j] = t;
	}
	

    // 测试 MinHeap
    public static void main(String[] args) {

        MinHeap<Integer> minHeap = new MinHeap<Integer>(100);
        int N = 100; // 堆中元素个数
        int M = 100; // 堆中元素取值范围[0, M)
        for( int i = 0 ; i < N ; i ++ )
            minHeap.insert( new Integer((int)(Math.random() * M)) );

        Integer[] arr = new Integer[N];
        // 将minheap中的数据逐渐使用extractMin取出来
        // 取出来的顺序应该是按照从小到大的顺序取出来的
        for( int i = 0 ; i < N ; i ++ ){
            arr[i] = minHeap.extractMin();
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // 确保arr数组是从小到大排列的
        for( int i = 1 ; i < N ; i ++ )
            assert arr[i-1] <= arr[i];
    }
	
}
