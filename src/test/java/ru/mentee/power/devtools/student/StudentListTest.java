package ru.mentee.power.devtools.student;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StudentListTest {

    @Test
    @DisplayName("Должен добавить студента в список, если студент is not null")
    void shouldAddStudentWhenStudentIsNotNull() {
        // given - подготовка данных
        StudentList sl = new StudentList();
        Student student = new Student("Вася", "Киров");

        // when - выполнение действия
        sl.addStudent(student);

        // then - проверка результата с assertJ
        List<Student> students = sl.getStudentsByCity("Киров");
        assertThat(students.getFirst()).isEqualTo(student);
    }

    @Test
    @DisplayName("Не должен добавить студента в список, если студент is null")
    void shouldNotAddStudentWhenStudentIsNull() {
        // given - подготовка данных
        StudentList sl = new StudentList();

        // when - выполнение действия
        sl.addStudent(null);

        // then - проверка результата с assertJ
        List<Student> students = sl.getStudentsByCity("город");
        assertThat(students.isEmpty()).isTrue();
    }
}