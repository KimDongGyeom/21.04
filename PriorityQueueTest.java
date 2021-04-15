package dddd;

import java.util.*;

public class PriorityQueueTest {
	public static void main(String[] args) {
//		test1();
		MyQueue queue = new MyQueue();
		queue.offer(new Task("작업1", 3));
		queue.offer(new Task("작업2", 2));
		queue.offer(new Task("작업3", 5));
		queue.offer(new Task("작업4", 1));
		queue.offer(new Task("작업5", 4));
		// 작업4, 작업2, 작업1, 작업5, 작업3
		for ( int i = 0; i < 5; i++) System.out.println(queue.poll());
		
	}
	
	private static void test1() {
		/*
		 * 우선순위 큐 객체를 생항하고
		 * Task 인스턴스를 삽입, 인출 해보자.
		 */
		Queue<Task> queue = new PriorityQueue<>(new TaskComparator());
		// 비교하는 방법이 필요하고, 방법을 알려주어야한다.
		// 방법: 1.컴페러터 / 2.Task에서 비교가능한 객체로 생성!!
		
		// 우선순위 큐: 기본적으로 오름차순으로 인출된다.
		queue.offer(new Task("작업1", 3));
		queue.offer(new Task("작업2", 2));
		queue.offer(new Task("작업3", 5));
		queue.offer(new Task("작업4", 1));
		queue.offer(new Task("작업5", 4));
		// (오름차순) 작업4, 작업2, 작업1, 작업5, 작업3 순대로 인출
		// * (-1):(내림차순) 작업3, 작업5, 작업1, 작업2, 작업4 
		
		while(queue.isEmpty() == false) {
			Task task = queue.poll();
			
			System.out.println(task);
		}
	}
}

// Task 인스턴스를 비교가능한 객체로 생성하기 위해 Comparable 인터페이스를 구현
class Task implements Comparable<Task> { 
	String desc; // 설명
	int priority = 5; // 이 작업의 우선순위
	
	// Object 클래스에 정의된 toString 메소드를 재정의하는 것
	@Override
	public String toString() {
		return "[desc:" + desc + ", priority:" + priority +"]";
		
	}
	public Task(String desc, int priority) {
		this.desc = desc;
		this.priority = priority;
	}
	
// class 생성에서 <Task>를 적지않으면 "오브젝트와 비교"
//	@Override
//	public int compareTo(Object o) { return 0; }

	@Override
	public int compareTo(Task o) {
		// 이 객체의 값이 크면 양수, 같으면 0, 적으면 음수를 반환. 오름차순/내림차순
//		return (this.priority - o.priority) * (-1);
		return (this.priority - o.priority);
	}
}

class TaskComparator implements Comparator<Task> {

	@Override
	public int compare(Task o1, Task o2) {
//		return o1.priority - o2.priority;
		return (-1) * (o1.priority - o2.priority);
	}
}

// 번외

class MyQueue {
	Task[] tasks = new Task[10]; // 배열 10개 생성
	int idx = 0;
	int pidx = 0;
	
	public void offer(Task value) {
		tasks[idx++] = value;
		// 새로운 객체가 들어올 때마다 선택정렬로 sorting한다
		for (int i = idx - 1; i >= 0; i--) {
			int max = i; // 가장 마지막 원소가 최대값이 가정.
			for (int j = 0; j < i-1; J++) {
				if (tasks[j].compareTo(tasks[max]) > 0 ) {
					max = j;
				}
			}
			//max, i를 swap
			task tmp = tasks[max];
			tasks[max] = tasks[i];
			tasks[i] = tmp;
		}
	}
	
	public Task poll() {
		return tasks[pidx++];
	}
}



