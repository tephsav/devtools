package ru.mentee.power;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

class MenteeProgressTest {
    @Test
    void shouldFormatSummaryWhenProgressCreated() {
        MenteeProgress progress = new MenteeProgress("Вася", 1, 7);
        String result = progress.summary();
        assertThat(result).isEqualTo("Sprint 1 → Вася: planned 7 h");
    }

    @Test
    void shouldDetectReadinessWhenHoursAboveThreshold() {
        MenteeProgress progress = new MenteeProgress("Андрей", 1, 4);
        assertThat(progress.readyForSprint()).isTrue();
    }

    @Test
    void shouldDetectLackOfReadinessWhenHoursBelowThreshold() {
        MenteeProgress progress = new MenteeProgress("Кирилл", 1, 2);
        assertThat(progress.readyForSprint()).isFalse();
    }
}