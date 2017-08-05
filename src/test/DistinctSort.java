package test;



/*
 * 对src数组进行排序，并且去重，元素不能为Integer.MIN_VALUE
 */

public class DistinctSort {
	private int[] src = {2, 4, 8, 2, 3, 5, 9, 8, 4};
	
	
	private int indexOfcurrentMinValue;  //当前最小元素的索引
	private int last = Integer.MIN_VALUE;  //第一次排序遍历是最小元素值为Integer.MIN_VALUEֵ
	
	/**
	 * 获得src数组从i索引处开始，最小元素的索引，且保证该索引对应元素值大于last
	 */
	private int findCurrentMinElementIndex(int i){
		int j = 0;
		int temp = 0;
		for(j = i; j<src.length; j++){
			if(src[j]>last){
				temp = j;
				break;
			}
		}
		//当j等于src数组的长度时，表示排序结束
		if(j == src.length)
			return -1;
		//寻找当前遍历大于last且最小的元素的索引
		for(int k = j; k<src.length; k++){
			if(src[k]>last && src[k]<src[temp]){
				temp = k;
			}							
		}
		return temp;
	}
	public void sortAndDeleteRepeatedValue(){
		int i;
		for(i = 0; i<src.length; i++){
			indexOfcurrentMinValue = findCurrentMinElementIndex(i);
			//当indexOfcurrentMinValue值为-1，表示排序结束
			if(indexOfcurrentMinValue == -1)
				break;
			swap(i, indexOfcurrentMinValue);
			last = src[i];
		}
		//打印src数组从0到i-1索引处的值，即src前i个元素
		printArray(i);
		
	}
	/**
	 * 打印src数组从0到i-1索引处的值，即src前i个元素
	 */
	private void printArray(int i){
		if(src.length == 0){
			System.out.println("[]");
		}else if(src.length == 1){
			System.out.println("[" + src[0] +"]");			
		}else{
			System.out.print("[");
			for(int j = 0; j<i-1; j++)
				System.out.print(src[j] +", ");
			System.out.println(src[i-1] + "]");
		}
	}
	
	/**
	 * 交换
	 */
	private void swap(int i, int j){
		int temp = src[i];
		src[i] = src[j];
		src[j] = temp;
	}
	

	public static void main(String[] args) {
		new DistinctSort().sortAndDeleteRepeatedValue();
	}

}
