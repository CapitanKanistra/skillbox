package practice;

import java.util.ArrayList;

public class TodoList {
    ArrayList<String> todoList = new ArrayList<>();

    public void add(String todo) {
        // TODO: добавьте переданное дело в конец списка
        this.todoList.add(todo);
        System.out.println("Задача " + "\"" + todo + "\"" + " добавлена под номером " + this.todoList.indexOf(todo));
    }

    public void add(int index, String todo) {
        // TODO: добавьте дело на указаный индекс,
        //  проверьте возможность добавления
        if (index > this.todoList.size()) {
            index = this.todoList.size();
            System.out.println("Заданный индекс превышает размер ArrayList, данная задача будет находиться " +
                    "в конце списка");
        }
        this.todoList.add(index, todo);
        System.out.println("Задача " + (index) + " добавленна");
    }

    public void edit(int index, String todo) {
        // TODO: заменить дело на index переданным todo индекс,
        //  проверьте возможность изменения
        if (index > this.todoList.size()) {
            System.out.println("Задачи с таким индексом не существует :( \nВзгляните на список задач:");
            getTodos();
        } else {
            this.todoList.set(index, todo);
            System.out.println("Задача " + (index) + " заменена");
        }
    }

    public void delete(int index) {
        // TODO: удалить дело находящееся по переданному индексу,
        //  проверьте возможность удаления дела
        if (index >= this.todoList.size()) {
            System.out.println("Задачи с таким индексом не существует :( \nВзгляните на список задач:");
            getTodos();
        } else {
            this.todoList.remove(index);
            System.out.println("Задача " + (index) + " удалена");
        }
    }

    public ArrayList<String> getTodos() {
        // TODO: вернуть список дел
        for (int i = 0; i < todoList.size(); i++) {
            System.out.println(i + ". " + todoList.get(i));
        }
        return todoList;
    }

}

