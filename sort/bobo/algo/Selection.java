package bobo.algo;
/**
 * ����5 �����������kС���󣩵�ֵ
 * @author ASUS
 *
 */
public class Selection {
	
	//���ǵ��㷨�಻��������κ�ʵ��
	//����p,ʹ��arr[1...p-1]<arr[p] ;arr[p+1...r]>arr[p]
	//partition ����,�Ϳ��ŵ�partition һ��
	//˼��:˫·���ź���·���ŵ�˼���ܲ�������Selection�㷨��?
	private static int partition(Comparable[] arr,int l,int r){
		
		//�����arr[l..r]�ķ�Χ��,ѡ��һ����ֵ��Ϊ�궨��pivot
		swap(arr,l,(int)(Math.random()*(r-l+1)+l));
		
		Comparable v = arr[l];
		
		int j = l;//arr[l+1...j]<v ;arr[j+1...i)>v
		for(int i=l+1;i<=r;i++){
			if(arr[i].compareTo(v)<0){
				j++;
				swap(arr,j,i);
			}
		}
		swap(arr,l,j);
		return j;
	}
	//���nums[l...r]��Χ���kС����
	private static Comparable solve(Comparable[] nums,int l,int r,int k){
		if(l==r)
			return nums[l];
		//partition֮��,nums[p]����ȷλ�þ�������p��
		int p = partition(nums,l,r);
		
		if(k==p)//���k==p,ֱ�ӷ���nums[p]
			return nums[p];
		else if(k<p) //���k<p ,ֻ��Ҫ��nums[l..p-1]���ҵ���kСԪ�ؼ���
			return solve(nums,l,p-1,k);
		else//���k>p,����Ҫ��nums[p+1..r]���ҵ���kСԪ��
			return  solve(nums,p+1,r,k);
	}
	//Ѱ��nums�����е�kС��Ԫ��
	 public static Comparable solve(Comparable nums[], int n, int k) {

	        assert k >= 0 && k < n;
	        return solve(nums, 0, n - 1, k);
	    }


    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    // ���� Selection
    public static void main(String[] args) {

        // ����һ����СΪn, ����0...n-1��n��Ԫ�ص��������arr
        int N = 10000;
        Integer[] arr = TestHelper.generateOrderedArray(N);
        TestHelper.shuffleArray(arr);

        // ��֤selection�㷨, ��arr�������iСԪ��, Ӧ��Ϊi
        for( int i = 0 ; i < N ; i ++ ){
            System.out.println(solve(arr, N, i));
            System.out.println("test " + i + " complete.");
        }

    }
}
