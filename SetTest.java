package dddd;

import java.util.*;

public class SetTest {
	public static void main(String[] args) {
//		test1();
		test2();
	}
	public static void test1() {
		/*
		 set1 = {2, 3, 4, 5, 6, 8, 9, 10} set2 = {1, 3, 5, 7, 9}
		 ������: set1.addAll(set2) = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
		 ������: retainAll(set2) = {3, 5, 9}
		 ������ = set1 - set2 : set1.removeAll(set2) => {2, 4, 6, 8, 10}
		 set2 - set1 : set2.removeAll(set1)=> {1, 7}
		 */
		// Generic Ŭ���� ��ü�� ���� �� Ÿ�� �Ķ���ʹ�
		// ������Ʈ�� Ÿ���� �� �� ����. ��üŸ�Ը� �� �� �ִ�.

		// HashSet, LinkedHashSet, TreeSet
		// LinkedHashSet: �Է� ������� ����
		// TreeSet: ���� ���� ���ĵ� ������ ����
		Set<Integer> set1 = new HashSet<>();
		// {2, 3, 4, 5, 6, 8, 9, 10}
		/*
		 * set1.add(2);
		 * set1.add(3);
		 */
		// �迭�� Collection��ü�� ������ִ� �޼ҵ尡 �ִ�.
//		List<Integer> list = Arrays.asList(2, 3, 4, 5, 6, 8, 9, 10);
		List<Integer> list = Arrays.asList(10, 9, 5234, 8, 6, 5, 4, 3, 2);
		set1.addAll(list);
		
		set1.add(2); set1.add(3); set1.add(4); set1.add(5);
		set1.add(6); set1.add(8); set1.add(9); set1.add(10);
		
		// {1, 3, 5, 7, 9}
		Set<Integer> set2 = new HashSet<>();
		List<Integer> list2 = Arrays.asList(1, 3, 5, 7, 9);
		set2.addAll(list2);
		
		System.out.println("set1: " + set1);
		System.out.println("set2: " + set2);
		Set<Integer> unionSet = new HashSet<>(set1);
		unionSet.addAll(set2);
		System.out.println("set1 ������ set2: " + set1);
		
		// ������
		Set<Integer> intersectionset = new HashSet<>(set1);
		intersectionset.retainAll(set2);
		// {3, 5, 9}
		System.out.println("set1 ������ set2: " + intersectionset );
		
		// �ܾ��� �� �ܿ�ܾ�� �ܿ��� ���� �ܾ �������� �̿��Ͽ� ��� �� �ִ�!!!!!
		// ������ 
		Set<Integer> diffset = new HashSet<>(set1);
		diffset.removeAll(set2);
		// {2, 4, 6, 8, 10}
		System.out.println("set1 ������ set2: " + diffset );
		
//		for (int i = 0; i < diffset.size(); i++) {
//			diffset.get(i)
//		}
		
		System.out.println("#################");
//		for (Integer val : diffset) {
//			// val ���� ������ ó������..
//			System.out.println(val);
//		}
		
//		Iterator<Integer> iter = diffset.iterator();
		Iterator<Integer> iter = set1.iterator();
		while(iter.hasNext()) {
			Integer val = iter.next();
			// val ������ ó��..
			System.out.println(val);
			
		}
		System.out.println("#################");
		
		Set<Integer> diffset1 = new HashSet<>(set2);
		diffset1.removeAll(set1);
		// {1, 7}
		System.out.println("set2 ������ set1: " + diffset1 );
	}
	
	public static void test2() {
		List<Integer> list = Arrays.asList(10, 9, 5234, 8, 6, 5, 4, 3, 2);
		//Set<Integer> set1 = new LinkedHashSet<>(); // �Է� ������� ���
		MyComparator mc = new MyComparator();
//		Set<Integer> set1 = new TreeSet<>(); // ���� ������� ���
		Set<Integer> set1 = new TreeSet<>(mc); // ���� ������� ���
		set1.addAll(list);
		Iterator<Integer> iter = set1.iterator();
		//�Էµ� ������� �������� Ȯ��
		// �Ǵ� ���� ������� �������� Ȯ��
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
class MyComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer n1, Integer n2) {
		// �տ� ���ڷ� ���޵� ���� ũ�� ���
		// ������ 0
		// �ڿ� ���ڷ� ���޵� ���� ũ�� ����
		return n2 - n1;
	}
	
	
}