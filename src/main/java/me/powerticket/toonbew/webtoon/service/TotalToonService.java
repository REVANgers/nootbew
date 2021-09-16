package me.powerticket.toonbew.webtoon.service;

import lombok.RequiredArgsConstructor;
import me.powerticket.toonbew.common.ErrorInfo;
import me.powerticket.toonbew.common.exception.NotFoundException;
import me.powerticket.toonbew.webtoon.dto.TotalToonDto;
import me.powerticket.toonbew.webtoon.dto.TotalToonPostDto;
import me.powerticket.toonbew.webtoon.entity.TotalToon;
import me.powerticket.toonbew.webtoon.repository.TotalToonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TotalToonService {

    @Autowired
    private final TotalToonRepository repository;

    public TotalToon create(TotalToonPostDto totalToonPostDto) {
        TotalToon totalToon = TotalToon.builder()
                .name(totalToonPostDto.getName())
                .thumbnail(totalToonPostDto.getThumbnail())
                .dayOfWeek(totalToonPostDto.getDayOfWeek())
                .build();
        return repository.save(totalToon);
    }

    public List<TotalToon> readAllActivated() {
//        JPA 문법 확인하여 WHERE query 조회로 변경 필요
        return repository.findByActivatedTrue();
//        return repository.findAll().stream().filter(TotalToon::getActivated).collect(Collectors.toList());
    }

    public void updateDateById(Long id) {
        Optional<TotalToon> optionalTotalToon = repository.findById(id);
        optionalTotalToon.ifPresentOrElse(totalToon -> {
            totalToon.setUpdatedAt(LocalDateTime.now());
            repository.save(totalToon);
        }, () -> {
            throw new NotFoundException(ErrorInfo.TOTAL_TOON_NOT_FOUND.getErrorCode(), ErrorInfo.TOTAL_TOON_NOT_FOUND.getErrorMessage());
        });
    }

    public void deactivateById(Long id) {
        Optional<TotalToon> optionalTotalToon = repository.findById(id);
        optionalTotalToon.ifPresentOrElse(totalToon -> {
            totalToon.setActivated(false);
            repository.save(totalToon);
        }, () -> {
            throw new NotFoundException(ErrorInfo.TOTAL_TOON_NOT_FOUND.getErrorCode(), ErrorInfo.TOTAL_TOON_NOT_FOUND.getErrorMessage());
        });
    }
}
