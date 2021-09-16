package me.powerticket.toonbew.webtoon.repository;

import me.powerticket.toonbew.webtoon.entity.TotalToon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TotalToonRepository extends JpaRepository<TotalToon, Long> {
    List<TotalToon> findByActivatedTrue();
}
