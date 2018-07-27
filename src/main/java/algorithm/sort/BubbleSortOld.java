package algorithm.sort;

import java.util.Arrays;

public class BubbleSortOld
{
	public static void main(String[] args) {
		int [] array={32,42,1,44,2,41,98,8};
		bubbleSort(array);
		System.out.println(Arrays.toString(array));
	}
	static void bubbleSort(int [] array){
		for(int i=0;i<array.length-1;i++){
			for(int j=0;j<array.length-i-1;j++){
				if(array[j]<array[j+1]){
					int temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
				
			}
		}
	}

}
