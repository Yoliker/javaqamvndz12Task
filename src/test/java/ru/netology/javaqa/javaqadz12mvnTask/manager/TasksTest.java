package ru.netology.javaqa.javaqadz12mvnTask.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    @Test
    public void shouldGetTaskParam() {
        Task task = new Task(88);
        Assertions.assertEquals(88, task.getId());
    }

    @Test
    public void shouldGetSimpleTaskParam() {
        SimpleTask simpleTask = new SimpleTask(9, "Новый заголовок");

        Assertions.assertEquals("Новый заголовок", simpleTask.getTitle());
    }

    @Test
    public void shouldGetEpicParam() {
        String[] subtasks = {"Купить продукты", "Оплатить коммуналку", "Сделать ДЗ"};
        Epic epic = new Epic(9, subtasks);

        Assertions.assertArrayEquals(subtasks, epic.getSubtasks());
    }

    @Test
    public void shouldGetMeetingParams() {

        Meeting meeting = new Meeting(
                120,
                "Решение задачи",
                "Тестирование веб-интерфейсов",
                "Вторник 10.00-12.00");

        Assertions.assertEquals("Решение задачи", meeting.getTopic());
        Assertions.assertEquals("Тестирование веб-интерфейсов", meeting.getProject());
        Assertions.assertEquals("Вторник 10.00-12.00", meeting.getStart());
    }

    @Test
    public void shouldCheckTaskIfFalse() {
        Task task = new Task(60);

        boolean expected = false;
        boolean actual = task.matches("60");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldCheckSimpleTaskIfTrue() {

        SimpleTask simpleTask = new SimpleTask(2, "Подготовить расписание");

        boolean expected = true;
        boolean actual = simpleTask.matches("расписание");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCheckSimpleTaskIfFalse() {

        SimpleTask simpleTask = new SimpleTask(2, "Подготовить расписание");

        boolean expected = false;
        boolean actual = simpleTask.matches("Расписание");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCheckEpicIfTrue() {

        String[] subtasks = {"Купить продукты", "Оплатить коммуналку", "Сделать ДЗ"};

        Epic epic = new Epic(4, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("продукты");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCheckEpicIfFalse() {

        String[] subtasks = {"Купить продукты", "Оплатить коммуналку", "Сделать ДЗ"};

        Epic epic = new Epic(4, subtasks);

        boolean expected = false;
        boolean actual = epic.matches("прокты");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCheckMeetingWithTopicIfTrue() {

        Meeting meeting = new Meeting(55, "Задачи", "Новый проект в августе", "Понедельник в 09.00");

        boolean expected = true;
        boolean actual = meeting.matches("Задачи");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCheckMeetingWithProjectIfTrue() {

        Meeting meeting = new Meeting(55, "Задачи", "Новый проект в августе", "Понедельник в 09.00");

        boolean expected = true;
        boolean actual = meeting.matches("проект");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCheckMeetingIfFalse() {

        Meeting meeting = new Meeting(55, "Задачи", "Новый проект в августе", "Понедельник в 09.00");

        boolean expected = false;
        boolean actual = meeting.matches("09.00");

        Assertions.assertEquals(expected, actual);
    }

}
