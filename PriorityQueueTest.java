package dddd;

import java.util.*;

public class PriorityQueueTest {
	public static void main(String[] args) {
//		test1();
		MyQueue queue = new MyQueue();
		queue.offer(new Task("�۾�1", 3));
		queue.offer(new Task("�۾�2", 2));
		queue.offer(new Task("�۾�3", 5));
		queue.offer(new Task("�۾�4", 1));
		queue.offer(new Task("�۾�5", 4));
		// �۾�4, �۾�2, �۾�1, �۾�5, �۾�3
		for ( int i = 0; i < 5; i++) System.out.println(queue.poll());
		
	}
	
	private static void test1() {
		/*
		 * �켱���� ť ��ü�� �����ϰ�
		 * Task �ν��Ͻ��� ����, ���� �غ���.
		 */
		Queue<Task> queue = new PriorityQueue<>(new TaskComparator());
		// ���ϴ� ����� �ʿ��ϰ�, ����� �˷��־���Ѵ�.
		// ���: 1.���䷯�� / 2.Task���� �񱳰����� ��ü�� ����!!
		
		// �켱���� ť: �⺻������ ������������ ����ȴ�.
		queue.offer(new Task("�۾�1", 3));
		queue.offer(new Task("�۾�2", 2));
		queue.offer(new Task("�۾�3", 5));
		queue.offer(new Task("�۾�4", 1));
		queue.offer(new Task("�۾�5", 4));
		// (��������) �۾�4, �۾�2, �۾�1, �۾�5, �۾�3 ����� ����
		// * (-1):(��������) �۾�3, �۾�5, �۾�1, �۾�2, �۾�4 
		
		while(queue.isEmpty() == false) {
			Task task = queue.poll();
			
			System.out.println(task);
		}
	}
}

// Task �ν��Ͻ��� �񱳰����� ��ü�� �����ϱ� ���� Comparable �������̽��� ����
class Task implements Comparable<Task> { 
	String desc; // ����
	int priority = 5; // �� �۾��� �켱����
	
	// Object Ŭ������ ���ǵ� toString �޼ҵ带 �������ϴ� ��
	@Override
	public String toString() {
		return "[desc:" + desc + ", priority:" + priority +"]";
		
	}
	public Task(String desc, int priority) {
		this.desc = desc;
		this.priority = priority;
	}
	
// class �������� <Task>�� ���������� "������Ʈ�� ��"
//	@Override
//	public int compareTo(Object o) { return 0; }

	@Override
	public int compareTo(Task o) {
		// �� ��ü�� ���� ũ�� ���, ������ 0, ������ ������ ��ȯ. ��������/��������
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

// ����

class MyQueue {
	Task[] tasks = new Task[10]; // �迭 10�� ����
	int idx = 0;
	int pidx = 0;
	
	public void offer(Task value) {
		tasks[idx++] = value;
		// ���ο� ��ü�� ���� ������ �������ķ� sorting�Ѵ�
		for (int i = idx - 1; i >= 0; i--) {
			int max = i; // ���� ������ ���Ұ� �ִ밪�� ����.
			for (int j = 0; j < i-1; J++) {
				if (tasks[j].compareTo(tasks[max]) > 0 ) {
					max = j;
				}
			}
			//max, i�� swap
			task tmp = tasks[max];
			tasks[max] = tasks[i];
			tasks[i] = tmp;
		}
	}
	
	public Task poll() {
		return tasks[pidx++];
	}
}



