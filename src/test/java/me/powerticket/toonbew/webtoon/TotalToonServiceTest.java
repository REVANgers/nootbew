package me.powerticket.toonbew.webtoon;

import me.powerticket.toonbew.webtoon.dto.TotalToonPostDto;
import me.powerticket.toonbew.webtoon.entity.TotalToon;
import me.powerticket.toonbew.webtoon.repository.TotalToonMemoryRepository;
import me.powerticket.toonbew.webtoon.service.TotalToonService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TotalToonServiceTest {

    private final TotalToonMemoryRepository totalToonMemoryRepository = new TotalToonMemoryRepository();
    private final TotalToonService totalToonService = new TotalToonService(totalToonMemoryRepository);

    @AfterEach
    void tearDown() {
        totalToonMemoryRepository.clearStore();
    }

    Long createTotalToon() {
        TotalToon totalToon = totalToonService.create(new TotalToonPostDto());
        return totalToon.getId();
    }

    @Test
    void readAll_create0() {
        //given
        //nothing

        //when
        int size = totalToonService.readAllActivated().size();

        //then
        assertThat(size).isEqualTo(0);
    }

    @Test
    void readAll_create1() {
        //given
        createTotalToon();

        //when
        int size = totalToonService.readAllActivated().size();

        //then
        assertThat(size).isEqualTo(1);
    }

    @Test
    void readAll_create2() {
        //given
        createTotalToon();
        createTotalToon();

        //when
        int size = totalToonService.readAllActivated().size();

        //then
        assertThat(size).isEqualTo(2);
    }

    @Test
    void updateDate_init() throws InterruptedException {
        //given
        createTotalToon();
        Thread.sleep(10);
        createTotalToon();

        //when
        List<TotalToon> totalToons = totalToonService.readAllActivated();
        LocalDateTime updatedAt0 = totalToons.get(0).getUpdatedAt();
        LocalDateTime updatedAt1 = totalToons.get(1).getUpdatedAt();

        //then
        assertThat(updatedAt0.compareTo(updatedAt1)).isEqualTo(-1);
    }

    @Test
    void updateDate_update() throws InterruptedException {
        //given
        Long totalToonId = createTotalToon();
        Thread.sleep(10);
        createTotalToon();

        //when
        Thread.sleep(10);
        totalToonService.updateDateById(totalToonId);

        List<TotalToon> totalToons = totalToonService.readAllActivated();
        LocalDateTime updatedAt0 = totalToons.get(0).getUpdatedAt();
        LocalDateTime updatedAt1 = totalToons.get(1).getUpdatedAt();

        //then
        assertThat(updatedAt0.compareTo(updatedAt1)).isEqualTo(1);
    }

    @Test
    void deactivateById() {
        //given
        Long totalToonId = createTotalToon();

        //when
        totalToonService.deactivateById(totalToonId);

        //then
        assertThat(totalToonService.readAllActivated().size()).isEqualTo(0);
    }
}