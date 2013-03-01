package ru.artyomkomarov;

import java.util.Scanner;

public class ApplicationQueue {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Все вводится через консоль, команды такие же как и в интерфейсе
		//Можно использовать String[] args, и парсить ввод, вводить размер массива не требуется, он расширяется
		System.out.println("Введите название класса CircleQueue или ArrayQueue"); // 2 реализации
		String nameOfClass = "";
		nameOfClass = sc.next();
		Object qq = null;
		try {
			Class c = Class.forName("ru.artyomkomarov." + nameOfClass); // Загружаем реализацию по названию класса
			qq = c.newInstance(); // Создаем экземпляр класса
		} catch (Exception e) {
			e.printStackTrace(); //Используем конструкцию try/catch для отлова исключений
		}
		 
		QueueInterface q = (QueueInterface) qq; //С помощью интерфейса подключаем нашу реализацию очереди
		System.out.println("Введите количество запросов к очереди");
		int n = sc.nextInt();
		System.out.println("Вводите запросы");
		for(int i = 0; i < n; i++) { //В цикле обрабатываем запросы 
			String str, s = sc.next();
			if(s.equals("add")) {
				str = sc.next();
				q.add(str); //Добавление в очередь
			}
			if(s.equals("poll")) {
				System.out.println(q.poll().toString()); //Первый элемент + извлечь
			}
			if(s.equals("first")) {
				System.out.println(q.first().toString()); //Первый элемент
			}
			if(s.equals("contains")) {
				System.out.println(q.contains()); //Пуста ли очередь
			}
		}

	}
}
