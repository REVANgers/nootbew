package me.powerticket.toonbew.webtoon.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class TotalToonDto {
    private Long id;
    private String name;
    private String thumbnail;
    private Integer dayOfWeek;
    private Boolean isUpdated;
}
