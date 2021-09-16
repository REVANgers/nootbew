package me.powerticket.toonbew.webtoon.repository;

import me.powerticket.toonbew.webtoon.entity.TotalToon;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

class TotalToonMemoryRepositoryTest {

    private final TotalToonMemoryRepository repository = new TotalToonMemoryRepository();

    @AfterEach
    void tearDown() {
        repository.clearStore();
    }

    @Test
    void save_findById_delete() {
        TotalToon totalToon = TotalToon.builder()
                .name("name")
                .thumbnail("http://thumbnail_url")
                .dayOfWeek(Calendar.MONDAY)
                .updatedAt(LocalDateTime.now())
                .build();

        TotalToon save = repository.save(totalToon);
        repository.findById(save.getId()).ifPresentOrElse(totalToon1 -> assertThat(totalToon1).isEqualTo(save),
                () -> fail("repository.findById(save.getId()) is null")

        );

        repository.delete(save);
        assertThat(repository.findById(save.getId())).isEqualTo(Optional.empty());

    }
}