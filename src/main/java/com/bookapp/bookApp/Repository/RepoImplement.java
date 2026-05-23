/*
package com.bookapp.bookApp.Repository;

import com.bookapp.bookApp.entity.BookEntry;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class RepoImplement implements BookEntryRepository {

    @Override
    public <S extends BookEntry> S insert(S entity) {
        return null;
    }

    @Override
    public <S extends BookEntry> List<S> insert(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public <S extends BookEntry> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends BookEntry> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends BookEntry> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends BookEntry> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends BookEntry> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends BookEntry> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends BookEntry, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends BookEntry> S save(S entity) {
        return null;
    }

    @Override
    public <S extends BookEntry> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<BookEntry> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public List<BookEntry> findAll() {
        return List.of();
    }

    @Override
    public List<BookEntry> findAllById(Iterable<String> strings) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(BookEntry entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends BookEntry> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<BookEntry> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<BookEntry> findAll(Pageable pageable) {
        return null;
    }
}
*/
