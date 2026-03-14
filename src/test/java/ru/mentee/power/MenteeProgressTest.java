package ru.mentee.power;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class MenteeProgressTest {
    @Test
    void shouldFormatSummary_whenProgressCreated() {
        MenteeProgress progress = new MenteeProgress("Вася", 1, 7);
        String result = progress.summary();
        assertThat(result).isEqualTo("Sprint 1 → Вася: planned 7 h");
    }

    @Test
    void shouldDetectReadiness_whenHoursAboveThreshold() {
        MenteeProgress progress = new MenteeProgress("Андрей", 1, 4);
        assertThat(progress.readyForSprint()).isTrue();
    }

    @Test
    void shouldDetectLackOfReadiness_whenHoursBelowThreshold() {
        MenteeProgress progress = new MenteeProgress("Кирилл", 1, 2);
        assertThat(progress.readyForSprint()).isFalse();
    }
}