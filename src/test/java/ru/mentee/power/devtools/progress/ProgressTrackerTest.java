package ru.mentee.power.devtools.progress;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тестирование ProgressTracker")
class ProgressTrackerTest {
    @Test
    @DisplayName("Должен корректно вычислить суммарный прогресс когда передан массив mentee")
    void shouldCalculateTotalProgressWhenMultipleMentees() {
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
    void shouldCalculateTotalProgressWhenAllMenteesCompleted() {
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
    void shouldThrowExceptionWhenCompletedGreaterThanTotal() {
        assertThatThrownBy(() -> new Mentee("Андрей", "Пенза", "Frontend", 20, 15))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Некорректные значения прогресса");
    }

    @Test
    @DisplayName("Должен выбросить исключение когда completedLessons и totalLessons отрицательные")
    void shouldThrowExceptionWhenCompletedNegativeAndTotalNegative() {
        assertThatThrownBy(() -> new Mentee("Андрей", "Пенза", "DevOps", -5, -8))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Некорректные значения прогресса");
    }

    @Test
    @DisplayName("Должен выбросить исключение когда totalLessons неположительное")
    void shouldThrowExceptionWhenTotalLessonsLessOrEqualZero() {
        assertThatThrownBy(() -> new Mentee("Вадим", "Сморгонь", "Frontend", 8, -5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Некорректные значения прогресса");
    }

    @Test
    @DisplayName("Не должен выбросить исключение, когда данные корректны")
    void shouldNotThrowExceptionWhenValidData() {
        assertThatCode(() -> new Mentee("Кирилл", "Смоленск", "QA", 6, 10))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("Должен вернуть сообщение, что массив пустой")
    void shouldReturnMessageWhenMenteesArrayIsNull() {
        // given - подготовка данных
        ProgressTracker tracker = new ProgressTracker();

        // when - выполнение действия
        String result = tracker.calculateTotalProgress(null);

        // then - проверка результата с assertJ
        assertThat(result).isEqualTo("Массив пустой");
    }

    @Test
    @DisplayName("Должен вернуть сообщение, что массив пустой")
    void shouldReturnMessageWhenMenteesArrayIsEmpty() {
        // given - подготовка данных
        ProgressTracker tracker = new ProgressTracker();
        Mentee[] mentees = {};

        // when - выполнение действия
        String result = tracker.calculateTotalProgress(mentees);

        // then - проверка результата с assertJ
        assertThat(result).isEqualTo("Массив пустой");
    }
}