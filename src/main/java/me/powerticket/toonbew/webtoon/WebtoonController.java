package me.powerticket.toonbew.webtoon;

import lombok.RequiredArgsConstructor;
import me.powerticket.toonbew.common.dto.ResponseDto;
import me.powerticket.toonbew.webtoon.dto.TotalToonPostDto;
import me.powerticket.toonbew.webtoon.entity.TotalToon;
import me.powerticket.toonbew.webtoon.service.TotalToonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/webtoon")
public class WebtoonController {

    @Autowired
    private final TotalToonService totalToonService;

    @GetMapping
    public ResponseDto<List<TotalToon>> getAllWebtoons() {
        List<TotalToon> totalToons = totalToonService.readAllActivated();
        return ResponseDto.<List<TotalToon>>builder()
                .data(totalToons)
                .build();
    }

    @PostMapping
    public void createTest(@RequestBody TotalToonPostDto totalToonPostDto) {
        totalToonService.create(totalToonPostDto);
    }

    @PatchMapping("/{id}/update")
    public void updateTest(@PathVariable("id") Long id) {
        totalToonService.updateDateById(id);
    }

    @PatchMapping("/{id}/deactivate")
    public void deactivateTest(@PathVariable("id") Long id) {
        totalToonService.deactivateById(id);
    }
}
