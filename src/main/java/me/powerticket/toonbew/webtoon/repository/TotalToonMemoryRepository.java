package me.powerticket.toonbew.webtoon.repository;

import me.powerticket.toonbew.webtoon.entity.TotalToon;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.*;
import java.util.stream.Collectors;

public class TotalToonMemoryRepository implements TotalToonRepository {

    private static final Map<Long, TotalToon> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public List<TotalToon> findByActivatedTrue() {
        return store.values().stream().filter(TotalToon::getActivated).collect(Collectors.toList());
    }

    @Override
    public TotalToon save(TotalToon totalToon) {
        totalToon.setId(++sequence);
        store.put(sequence, totalToon);
        return totalToon;
    }

    @Override
    public Optional<TotalToon> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<TotalToon> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void delete(TotalToon totalToon) {
        store.remove(totalToon.getId());
    }

    public void clearStore() {
        store.clear();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public List<TotalToon> findAll(Sort sort) {
        return null;
    }

    @Override
    public List<TotalToon> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public <S extends TotalToon> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends TotalToon> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends TotalToon> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<TotalToon> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public TotalToon getOne(Long aLong) {
        return null;
    }

    @Override
    public TotalToon getById(Long aLong) {
        return null;
    }

    @Override
    public <S extends TotalToon> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends TotalToon> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public Page<TotalToon> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends TotalToon> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends TotalToon> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends TotalToon> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends TotalToon> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends TotalToon> boolean exists(Example<S> example) {
        return false;
    }
}
