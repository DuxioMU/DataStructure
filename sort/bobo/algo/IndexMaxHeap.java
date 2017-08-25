package bobo.algo;

import java.util.Arrays;

//最大索引堆
public class IndexMaxHeap<Item extends Comparable> {
	
	protected Item[] data;		//最大索引堆中的数据
	protected int[] indexes;	//最大索引堆中的索引 ,indexes[x]=i 表示索引i在x的位置
	protected int[] reverse;	//最大索引堆中的反向索引,reverse[i] = x 表示索引i在x的位置
	protected int count;
	protected int capacity;
	
	//构造函数,构造一个空堆,可容纳capacity个元素
	@SuppressWarnings("unchecked")
	public IndexMaxHeap(int capacity){
		data = (Item[])new Comparable[capacity+1];
		indexes = new int[capacity+1];
		reverse = new int[capacity+1];
		for(int i = 0;i<=capacity;i++){
			reverse[i]=0;
		}
		count = 0;
		this.capacity=capacity;
	}
	
	public int size(){
		return capacity;
	}
	
	public boolean isEmpty(){
		return count==0;
	}
	//向最大索引堆中插入一个新的元素,新的元素的索引为i,元素为item
	//传入的i对用户而言是从0开始的
	public void insert(int i,Item item){
		
		assert count+1 <=capacity;
		assert i+1>=1 && i+1<=capacity;
		
		i++;
		data[i] = item;
		
		indexes[count+1] = i;
		reverse[i] = count+1;
		count++;
		
		shiftUp(count);
	}
	//从最大索引堆中取出堆顶元素,即索引堆中所存储的最大数据
	public Item extractMax(){
		assert count>0;
		
		Item ret = data[indexes[1]];
		swapIndexes(1,count);
		reverse[indexes[count]]=0;
		count--;
		shiftDown(1);
		
		return ret;
	}
	//从最大索引堆中取出堆顶元素的索引
	public int extractMaxIndex(){
		assert count > 0;
		
		int ret = indexes[1]-1;
		swapIndexes(1 ,count);
		reverse[indexes[count]]=0;
		count --;
		shiftDown(1);
		return ret;
	}
	
	//获取最大索引堆中的堆顶元素
	public Item getMax(){
		assert contain(1);
		return data[indexes[1]];
	}
	//获取最大索引堆中的堆顶元素索引
	public int getMaxIndex(){
		assert (contain(1));
		return indexes[1]-1;
	}
	
	//查看索引i所在的位置是否存在元素
	boolean contain(int i){
		assert i+1 >= 1 && i+1<=capacity;
		return reverse[i+1]!=0;
	}
	
	//获取最大索引堆中索引为i的元素
	public Item getItem(int i){
		assert i+1>0 && i+1<=capacity;
		return data[i+1];
	}
	
	//将最大索引堆中索引为i 的元素修改为newItem
	public void change(int i,Item newItem){
		
		assert(contain(i));
		i++;
		data[i] = newItem;
		//找到indexes[j] = i ,j表示data[i] 在堆中的位置
		//之后shiftUp(j),在shiftDown(j)
//		for(int j=1;j<=count;j++){
//			if(indexes[j] == i){
//				shiftUp(j);
//				shiftDown(j);
//				return;
//			}
//		}
		
		//有了reveerse之后
		//我们可以非常简单的通过reverse直接索引i在indexes中的位置
		shiftUp(reverse[i]);
		shiftDown(reverse[i]);
	}
	
	
	@SuppressWarnings("unchecked")
	private void shiftDown(int k){
		
		while(2*k<=count){
			int j = 2*k;
			if(j+1<=count && data[indexes[j+1]].compareTo(data[indexes[j]])>0)
				j++;
			if(data[indexes[k]].compareTo(data[indexes[j]])>0)
				break;
			swapIndexes(k,j);
			k=j;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	private void shiftUp(int k){
		
		while(k>1 &&data[indexes[k/2]].compareTo(data[indexes[k]])<0 ){
				swapIndexes(k/2,k);
				k/=2;
		}
	}
	
	//交换索引堆中的索引i和j
	//由于有了反向索引reverse数组
	//indexes数组发生了改变以后,相应的就需要维护reverse数组
	@SuppressWarnings("unused")
	private void swapIndexes(int i,int j){
		int t  = indexes[i];
		indexes[i] = indexes[j];
		indexes[j] = t;
		//下面的indexes已经交换过位置了
		reverse[indexes[i]] =i;
		reverse[indexes[j]] =j;
		
	}
	
	
	//测试索引堆中的索引数组index
	//注意:这个测试再向堆中插入元素以后,不进行extract操作有效
	public boolean testIndexes(){
		
		int[] copyIndexes = new int[count+1];
		
		for(int i = 0; i<=count;i++)
			copyIndexes[i] = indexes[i];
		
		copyIndexes[0] = 0;
		Arrays.sort(copyIndexes);
		
		//在对索引堆中的索引进行排序后,应该正好是l ...count 这个count个索引
		boolean res = true;
		for(int i = 1; i<=count ;i++)
			if(copyIndexes[i-1]+1!=copyIndexes[i]){
				res = false;
				break;
			}
		if(!res){
			System.out.println("Error!");
			return false;
		}
		return true;
	}
	
	
	   // 测试 IndexMaxHeap
    public static void main(String[] args) {

        int N = 1000000;
        IndexMaxHeap<Integer> indexMaxHeap = new IndexMaxHeap<Integer>(N);
        for( int i = 0 ; i < N ; i ++ )
            indexMaxHeap.insert( i , (int)(Math.random()*N) );
        assert indexMaxHeap.testIndexes();
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
