package ru.artyomkomarov;

import java.util.Scanner;

public class ApplicationQueue {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("������� �������� ������ CircleQueue ��� ArrayQueue");
		String nameOfClass = "";
		nameOfClass = sc.next();
		Object qq = null;
		try {
			Class c = Class.forName("ru.artyomkomarov." + nameOfClass);
			qq = c.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		QueueInterface q = (QueueInterface) qq;
		System.out.println("������� ���������� �������� � �������");
		int n = sc.nextInt();
		System.out.println("������� �������");
		for(int i = 0; i < n; i++) {
			String str, s = sc.next();
			if(s.equals("add")) {
				str = sc.next();
				q.add(str);
			}
			if(s.equals("poll")) {
				System.out.println(q.poll().toString());
			}
			if(s.equals("first")) {
				System.out.println(q.first().toString());
			}
			if(s.equals("contains")) {
				System.out.println(q.contains());
			}
		}

	}
}
