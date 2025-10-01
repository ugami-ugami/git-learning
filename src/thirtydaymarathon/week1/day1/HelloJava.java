
// День 1: Установка JDK, IntelliJ IDEA – Компиляция, запуск – HelloJava.java

package thirtydaymarathon.week1.day1;

public class HelloJava {
    public static void main (String[] args) { //Точка входа в программу, у автотестов будет точка входа через @Test
        System.out.println("Hello, Java!"); // Временный способ вывода. В реальных тестах и проектах - логгеры
    }
}

/*
✅ Хорошие практики
Каждый день — в отдельном пакете (day01, day02…)
Классы называй по смыслу: HelloWorld, EmailValidator, UserInputParser и т.д.
Никаких Test1, Temp, Class1 — они не объясняют, зачем существует код.
*/