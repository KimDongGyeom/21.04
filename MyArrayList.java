// 04.01.(��)����.
package dddd;

import java.util.*;

public class MyArrayList<T> {
	private Object[] arr;
	private int capacity = 10;
	private int size = 0; // size: �迭�� ��
	
	public MyArrayList(){
		arr = new Integer[capacity];
	}
	
	private void increaseCapacity() {
		//  �޼ҵ� add �� ��ġ�� �ڵ�!
		capacity = capacity + capacity/2;
		Object[] tmp = new Object[capacity];
		for (int i = 0; i < size; i++) {
			tmp[i] =arr[i];
		}
		arr = tmp;
	}
	
	public void add(T value) { // capacity : �뷮
		// ���� �뷮���� �߰��Ǵ� ���� ������ �� ������
		if (size >= capacity) {
			increaseCapacity();
		}
		arr[size++] = value;
	}
	
	public void add(int idx, T value) {
		// �뷮�� �̹� �� �������� �뷮�� 50% �ø���,
		// �Ʒ��ڵ带 �����Ѵ�.
		if (size == capacity) {
			increaseCapacity();
		}
		
		// �� �ڿ� �ִ� ���Һ��� ���������� �� ĭ�� �δ�.
		for (int i = size-1; i >= idx; i--) {
			arr[i+1] = arr[i];
		}
		// idx �ڸ��� value�� �ִ´�
		arr[idx] = value;
		size++;
	}
	
	public void remove() {
		if (size > 0) size--;
	}
	
	public void remove(int idx) { // �ϼ��ؼ� �����
		
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
			if ((i+1) % 10 == 0) result += "\n"; // n�� ���� �ڵ� �� �ٲ�.
		}
		result += arr[size-1]; // �迭�� ���������� ","���Ÿ� ����.
		result += "]";
		return result;
	}
	
	public static void main(String[] args) {
//		ArrayList<Integer>list = new ArrayList<>(); // auto Boxing
//		MyArrayList3 list = new MyArrayList3();
//		
//		for (int i = 0; i < 100; i++) { // ArrayList�̱� ������ �ڵ����� ũ�� ����.
//			list.add(i);
//		}
//		
//		list.get(100);
		
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
//		System.out.println(list);
		
//		list.add(3, 100); // �迭�� ���̿� �߰� (�߰��� index��ȣ, ��)
//		System.out.println(list);
		
//		�迭 ������ ���� ����/�߰�/���� �Ұ�� CPU�� ��뷮�� ������.
		
//		list.remove(3); // index 3���ڸ��� ���� ������ �� ��� ���� ������ ���.
//		list.remove(Integer.valueOf(100)); // "100"�� ���� ������ �� ��� ���� ������ ���.
//		System.out.println(list);
		
		MyArrayList<String> list2 = new MyArrayList<>();
		list2.add("ȫ�浿");
		list2.add("�ƽ���");
		
		list2.add(1, "������");
		
		
		
		MyArrayList<Student> list3 = new MyArrayList<>();
		list3.add(new Student("ȫ�浿", 123));
		list3.add(new Student("������", 124));
		list3.add(new Student("�̸���", 125));
		
		System.out.println(list3);
	}
		
}
