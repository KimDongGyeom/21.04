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
		 합집합: set1.addAll(set2) = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
		 교집합: retainAll(set2) = {3, 5, 9}
		 차집합 = set1 - set2 : set1.removeAll(set2) => {2, 4, 6, 8, 10}
		 set2 - set1 : set2.removeAll(set1)=> {1, 7}
		 */
		// Generic 클래스 객체를 생성 시 타입 파라미터는
		// 프리미트브 타입을 줄 수 없다. 객체타입만 줄 수 있다.

		// HashSet, LinkedHashSet, TreeSet
		// LinkedHashSet: 입력 순서대로 인출
		// TreeSet: 값에 따라 정렬된 순서로 인출
		Set<Integer> set1 = new HashSet<>();
		// {2, 3, 4, 5, 6, 8, 9, 10}
		/*
		 * set1.add(2);
		 * set1.add(3);
		 */
		// 배열을 Collection객체로 만들어주는 메소드가 있다.
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
		System.out.println("set1 합집합 set2: " + set1);
		
		// 교집합
		Set<Integer> intersectionset = new HashSet<>(set1);
		intersectionset.retainAll(set2);
		// {3, 5, 9}
		System.out.println("set1 교집합 set2: " + intersectionset );
		
		// 단어장 중 외운단어와 외우지 못한 단어를 차집합을 이용하여 골라낼 수 있다!!!!!
		// 차집합 
		Set<Integer> diffset = new HashSet<>(set1);
		diffset.removeAll(set2);
		// {2, 4, 6, 8, 10}
		System.out.println("set1 차집합 set2: " + diffset );
		
//		for (int i = 0; i < diffset.size(); i++) {
//			diffset.get(i)
//		}
		
		System.out.println("#################");
//		for (Integer val : diffset) {
//			// val 값을 적절히 처리해줌..
//			System.out.println(val);
//		}
		
//		Iterator<Integer> iter = diffset.iterator();
		Iterator<Integer> iter = set1.iterator();
		while(iter.hasNext()) {
			Integer val = iter.next();
			// val 적절히 처리..
			System.out.println(val);
			
		}
		System.out.println("#################");
		
		Set<Integer> diffset1 = new HashSet<>(set2);
		diffset1.removeAll(set1);
		// {1, 7}
		System.out.println("set2 차집합 set1: " + diffset1 );
	}
	
	public static void test2() {
		List<Integer> list = Arrays.asList(10, 9, 5234, 8, 6, 5, 4, 3, 2);
		//Set<Integer> set1 = new LinkedHashSet<>(); // 입력 순서대로 출력
		MyComparator mc = new MyComparator();
//		Set<Integer> set1 = new TreeSet<>(); // 값의 순서대로 출력
		Set<Integer> set1 = new TreeSet<>(mc); // 값의 순서대로 출력
		set1.addAll(list);
		Iterator<Integer> iter = set1.iterator();
		//입력된 순서대로 나오는지 확인
		// 또는 값의 순서대로 나오는지 확인
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
class MyComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer n1, Integer n2) {
		// 앞에 인자로 전달된 놈이 크면 양수
		// 같으면 0
		// 뒤에 인자로 전달된 놈이 크면 음수
		return n2 - n1;
	}
	
	
}