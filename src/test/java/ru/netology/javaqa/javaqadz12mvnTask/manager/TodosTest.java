package ru.netology.javaqa.javaqadz12mvnTask.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSomeTasksFromDifferentType() {
        SimpleTask simpleTask = new SimpleTask(8, "Оплата за продукты");

        String[] subtasks = {"продукты", "коммуналка", "интернет"};
        Epic epic = new Epic(60, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения - продукты",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.search("продукты");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindOneTaskFromDifferentType() {
        SimpleTask simpleTask = new SimpleTask(8, "Оплата за продукты");

        String[] subtasks = {"продукты", "коммуналка", "интернет"};
        Epic epic = new Epic(60, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения - продукты",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("Выкатка");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindTasksFromDifferentType() {
        SimpleTask simpleTask = new SimpleTask(8, "Оплата за продукты");

        String[] subtasks = {"продукты", "коммуналка", "интернет"};
        Epic epic = new Epic(60, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения - продукты",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("сотовая связь");
        Assertions.assertArrayEquals(expected, actual);
    }
}
