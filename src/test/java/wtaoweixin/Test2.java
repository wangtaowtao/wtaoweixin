package wtaoweixin;

import java.util.Arrays;

import com.test.Util;

public class Test2 {

	//冒泡排序
	public static int[] bobboSort(int[] array) {
		for (int i = 0; i < array.length-1; i++) {
			for (int j = 0; j < array.length-1-i; j++) {
				if(array[j]>array[j+1]) {
					int temp =array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		return array;
	}
	//选择排序
	public static int[] selectSort(int[] array) {
		for (int i = 0; i < array.length-1; i++) {
			//找出每一次遍历中最小的值索引是minIndex,默认是当次遍历的值下标
			int minIndex = i;
			//从i的下一个开始做比较
			for (int j = i+1; j < array.length; j++) {
				//更新minIndex值
				if(array[minIndex] > array[j])
					minIndex = j;
			}
			//交换
			int temp = array[i];
			array[i] = array[minIndex];
			array[minIndex]  = temp;
		}
		return array;
	}
	
	//插入排序
	public static int[] insertSort (int[] array) {
		for (int i = 1; i < array.length; i++) {
			int t = array[i];
			int j;
			for (j = i; j > 0 ; j--) {
				if(t < array[j-1]) {
					array[j] = array[j-1];
				}else {
					break;
				}
			}
			array[j] = t;
			
		}
		return array;
	}
	
	
	public static void main(String[] args) {
		int[] array = Util.generatorArray(10, 20);
		System.out.println("原数组"+Arrays.toString(array));
		//int[] bobboSort = bobboSort(array);
		//selectSort(array);
		insertSort(array);
		System.out.println(Arrays.toString(array));
		
	}
}

