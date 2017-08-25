package bobo.algo;

import java.util.Arrays;

//���������
public class IndexMaxHeap<Item extends Comparable> {
	
	protected Item[] data;		//����������е�����
	protected int[] indexes;	//����������е����� ,indexes[x]=i ��ʾ����i��x��λ��
	protected int[] reverse;	//����������еķ�������,reverse[i] = x ��ʾ����i��x��λ��
	protected int count;
	protected int capacity;
	
	//���캯��,����һ���ն�,������capacity��Ԫ��
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
	//������������в���һ���µ�Ԫ��,�µ�Ԫ�ص�����Ϊi,Ԫ��Ϊitem
	//�����i���û������Ǵ�0��ʼ��
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
	//�������������ȡ���Ѷ�Ԫ��,�������������洢���������
	public Item extractMax(){
		assert count>0;
		
		Item ret = data[indexes[1]];
		swapIndexes(1,count);
		reverse[indexes[count]]=0;
		count--;
		shiftDown(1);
		
		return ret;
	}
	//�������������ȡ���Ѷ�Ԫ�ص�����
	public int extractMaxIndex(){
		assert count > 0;
		
		int ret = indexes[1]-1;
		swapIndexes(1 ,count);
		reverse[indexes[count]]=0;
		count --;
		shiftDown(1);
		return ret;
	}
	
	//��ȡ����������еĶѶ�Ԫ��
	public Item getMax(){
		assert contain(1);
		return data[indexes[1]];
	}
	//��ȡ����������еĶѶ�Ԫ������
	public int getMaxIndex(){
		assert (contain(1));
		return indexes[1]-1;
	}
	
	//�鿴����i���ڵ�λ���Ƿ����Ԫ��
	boolean contain(int i){
		assert i+1 >= 1 && i+1<=capacity;
		return reverse[i+1]!=0;
	}
	
	//��ȡ���������������Ϊi��Ԫ��
	public Item getItem(int i){
		assert i+1>0 && i+1<=capacity;
		return data[i+1];
	}
	
	//�����������������Ϊi ��Ԫ���޸�ΪnewItem
	public void change(int i,Item newItem){
		
		assert(contain(i));
		i++;
		data[i] = newItem;
		//�ҵ�indexes[j] = i ,j��ʾdata[i] �ڶ��е�λ��
		//֮��shiftUp(j),��shiftDown(j)
//		for(int j=1;j<=count;j++){
//			if(indexes[j] == i){
//				shiftUp(j);
//				shiftDown(j);
//				return;
//			}
//		}
		
		//����reveerse֮��
		//���ǿ��Էǳ��򵥵�ͨ��reverseֱ������i��indexes�е�λ��
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
	
	//�����������е�����i��j
	//�������˷�������reverse����
	//indexes���鷢���˸ı��Ժ�,��Ӧ�ľ���Ҫά��reverse����
	@SuppressWarnings("unused")
	private void swapIndexes(int i,int j){
		int t  = indexes[i];
		indexes[i] = indexes[j];
		indexes[j] = t;
		//�����indexes�Ѿ�������λ����
		reverse[indexes[i]] =i;
		reverse[indexes[j]] =j;
		
	}
	
	
	//�����������е���������index
	//ע��:�������������в���Ԫ���Ժ�,������extract������Ч
	public boolean testIndexes(){
		
		int[] copyIndexes = new int[count+1];
		
		for(int i = 0; i<=count;i++)
			copyIndexes[i] = indexes[i];
		
		copyIndexes[0] = 0;
		Arrays.sort(copyIndexes);
		
		//�ڶ��������е��������������,Ӧ��������l ...count ���count������
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
	
	
	   // ���� IndexMaxHeap
    public static void main(String[] args) {

        int N = 1000000;
        IndexMaxHeap<Integer> indexMaxHeap = new IndexMaxHeap<Integer>(N);
        for( int i = 0 ; i < N ; i ++ )
            indexMaxHeap.insert( i , (int)(Math.random()*N) );
        assert indexMaxHeap.testIndexes();
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
