package practice;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static TodoList todoList = new TodoList();

    public static void main(String[] args) {
        System.out.println("LIST - выводит дела с их порядковыми номерами\n" +
                "ADD - добавляет дело\n" +
                "EDIT - заменяет дело " + "указанным номером; если указан несуществующий индекс, ничего не делать\n" +
                "DELETE - удаляет дело; если указан несуществующий индекс - ничего не делать\n" + "EXIT - выход");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("EXIT")) {
                break;
            }

            if (input.equals("LIST")) {
                todoList.getTodos();
            }

            //Добавляем задачу в конец списка (не указываем индекс)
            if (input.matches("ADD\\s\\D.+")) {
                todoList.add((input.replaceAll("ADD", "")).trim());
            }
            //Добавляем задачу в определенное место (указываем индекс)
            if (input.matches("ADD\\s\\d+.+")) {
                Pattern addIndexPattern = Pattern.compile("ADD\\s\\d+");

                //Ищем "ADD" [Номер]
                Matcher matcher = addIndexPattern.matcher(input);
                matcher.find();
                int indexAdd = Integer.parseInt(matcher.group().replaceAll("ADD", "").trim());

                //Обрезаем ADD, возвращаем индекс
                todoList.add(indexAdd, input.replaceAll("^ADD\\s\\d+", "").trim());
            }

            //Изменяем задачу через EDIT
            if (input.matches("EDIT\\s\\d+.+")) {
                Pattern editIndexPattern = Pattern.compile("EDIT\\s\\d+"); //Ищем "EDIT" [Номер]
                Matcher matcher = editIndexPattern.matcher(input);
                matcher.find();
                int indexEdit = Integer.parseInt(matcher.group().replaceAll("EDIT", "").trim());

                //Обрезаем EDIT, возвращаем индекс
                todoList.edit(indexEdit, input.replaceAll("^EDIT\\s\\d+", "").trim());
            }

            //Удаляем задачу под определенным индексом, если такой задачи нет - ничего не делаем
            if (input.matches("DELETE\\s\\d+")) {
                Pattern editIndexPattern = Pattern.compile("DELETE\\s\\d+"); //Ищем "DELETE" [Номер]
                Matcher matcher = editIndexPattern.matcher(input);
                matcher.find();
                int indexDel = Integer.parseInt(matcher.group().replaceAll("DELETE", "").trim());
                //Обрезаем строку с DELETE, извлекаем индекс
                todoList.delete(indexDel);
            }
        }
    }
}

