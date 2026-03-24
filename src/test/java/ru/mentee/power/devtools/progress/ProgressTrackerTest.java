package ru.mentee.power.devtools.progress;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Тестирование ProgressTracker")
class ProgressLoopTest {
    @Test
    @DisplayName("Должен корректно вычислить суммарный прогресс когда передан массив mentee")
    void shouldCalculateTotalProgress_whenMultipleMentees() {
        // given - подготовка данных
        ProgressTracker tracker = new ProgressTracker();
        Mentee[] mentees = {
            new Mentee("Иван", "Москва", "Backend разработка", 5, 12),
            new Mentee("Мария", "Санкт-Петербург", "Fullstack", 8, 12),
            new Mentee("Пётр", "Казань", "Java Backend", 12, 12)
        };

        // when - выполнение действия
        String result = tracker.calculateTotalProgress(mentees);

        // then - проверка результата с assertJ
        assertThat(result)
            .contains("пройдено 25 из 36 уроков")
            .contains("осталось 11 уроков");
    }

    @Test
    @DisplayName("Должен корректно обработать массив когда все mentee завершили курс")
    void shouldCalculateTotalProgress_whenAllMenteesCompleted() {
        // given
        ProgressTracker tracker = new ProgressTracker();
        Mentee[] mentees = {
                new Mentee("Иван", "Москва", "Backend", 12, 12),
                new Mentee("Мария", "СПб", "Fullstack", 12, 12)
        };

        // when
        String result = tracker.calculateTotalProgress(mentees);

        // then
        assertThat(result)
                .contains("пройдено 24 из 24 уроков")
                .contains("осталось 0 уроков");
    }

    @Test
    @DisplayName("Должен выбросить исключение когда completedLessons больше totalLessons")
    void shouldThrowException_whenCompletedGreaterThanTotal() {
        assertThatThrownBy(() -> new Mentee("Андрей", "Пенза", "Frontend", 20, 15))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("Некорректные значения прогресса");
    }

    @Test
    @DisplayName("Должен выбросить исключение когда completedLessons и totalLessons отрицательные")
    void shouldThrowException_whenCompletedNegativeAndTotalNegative() {
        assertThatThrownBy(() -> new Mentee("Андрей", "Пенза", "Frontend", -5, -8))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Некорректные значения прогресса");
    }

    @Test
    @DisplayName("Не должен выбросить исключение, когда данные корректны")
    void shouldNotThrowException_whenValidData() {
        assertThatCode(() -> new Mentee("Кирилл", "Смоленск", "QA", 6, 10))
            .doesNotThrowAnyException();
    }
}