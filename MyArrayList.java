// 04.01.(목)수업.
package dddd;

import java.util.*;

public class MyArrayList<T> {
	private Object[] arr;
	private int capacity = 10;
	private int size = 0; // size: 배열의 수
	
	public MyArrayList(){
		arr = new Integer[capacity];
	}
	
	private void increaseCapacity() {
		//  메소드 add 와 곂치는 코드!
		capacity = capacity + capacity/2;
		Object[] tmp = new Object[capacity];
		for (int i = 0; i < size; i++) {
			tmp[i] =arr[i];
		}
		arr = tmp;
	}
	
	public void add(T value) { // capacity : 용량
		// 현재 용량으로 추가되는 값을 수용할 수 있으면
		if (size >= capacity) {
			increaseCapacity();
		}
		arr[size++] = value;
	}
	
	public void add(int idx, T value) {
		// 용량이 이미 꽉 차있으면 용량을 50% 늘리고,
		// 아래코드를 실행한다.
		if (size == capacity) {
			increaseCapacity();
		}
		
		// 맨 뒤에 있는 원소부터 오른쪽으로 한 칸씩 민다.
		for (int i = size-1; i >= idx; i--) {
			arr[i+1] = arr[i];
		}
		// idx 자리에 value를 넣는다
		arr[idx] = value;
		size++;
	}
	
	public void remove() {
		if (size > 0) size--;
	}
	
	public void remove(int idx) { // 완성해서 깃허브
		
	}
	
	
	public T get(int idx) {
		return (T)arr[idx];
	}
	
	public int size() {
		return size;
	}
	
	@Override
	public String toString() {
		if (size ==0) return"[]";
		String result = "[";
		for (int i = 0; i < size-1; i++) {
			result += arr[i] + ",";
			if ((i+1) % 10 == 0) result += "\n"; // n개 이후 자동 줄 바꿈.
		}
		result += arr[size-1]; // 배열의 마지막이후 ","제거를 위함.
		result += "]";
		return result;
	}
	
	public static void main(String[] args) {
//		ArrayList<Integer>list = new ArrayList<>(); // auto Boxing
//		MyArrayList3 list = new MyArrayList3();
//		
//		for (int i = 0; i < 100; i++) { // ArrayList이기 때문에 자동으로 크기 조절.
//			list.add(i);
//		}
//		
//		list.get(100);
		
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
//		System.out.println(list);
		
//		list.add(3, 100); // 배열의 사이에 추가 (추가할 index번호, 값)
//		System.out.println(list);
		
//		배열 사이의 값을 수정/추가/삭제 할경우 CPU의 사용량이 증가함.
		
//		list.remove(3); // index 3번자리의 값을 삭제한 후 모든 값을 앞으로 당김.
//		list.remove(Integer.valueOf(100)); // "100"의 값을 삭제한 후 모든 값을 앞으로 당김.
//		System.out.println(list);
		
		MyArrayList<String> list2 = new MyArrayList<>();
		list2.add("홍길동");
		list2.add("아쉽네");
		
		list2.add(1, "성춘향");
		
		
		
		MyArrayList<Student> list3 = new MyArrayList<>();
		list3.add(new Student("홍길동", 123));
		list3.add(new Student("일지매", 124));
		list3.add(new Student("이몽룡", 125));
		
		System.out.println(list3);
	}
		
}
