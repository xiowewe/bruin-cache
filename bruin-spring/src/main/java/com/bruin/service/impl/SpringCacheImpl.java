package com.bruin.service.impl;

import com.bruin.model.Book;
import com.bruin.service.SpringCacheApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

/**
 * @author xiongwenwen
 * @since 2022/3/29 10:08 下午
 */
@Service
@Slf4j
public class SpringCacheImpl implements SpringCacheApi {

    @Override
    @Cacheable(value = "books", key = "#root.method.name + ':' + #isbn", condition = "#isbn.length() > 0")
    public Book getByIsbn(String isbn) {
        log.info("no cache----->");
        simulateSlowService();
        return new Book(isbn, "Some book");
    }

    @Override
    @CachePut(value = "books", key = "#root.method.name + ':' + #book.name", condition = "#book.name.length() > 0")
    public void save(Book book) {

    }

    @Override
    @CacheEvict(value = "books", key = "'save:' + #isbn", condition = "#isbn.length() > 0")
    public void remove(String isbn) {

    }

    @Override
    @Caching(
            cacheable = {
                    @Cacheable(value = "books", key = "#root.method.name + ':' + #isbn")
            },
            put = {
                    @CachePut(value = "books", key = "#root.method.name + ':' + #isbn"),
                    @CachePut(value = "books1", key = "#root.method.name + ':' + #isbn")
            }
    )
    public Book mixture(String isbn) {
        log.info("no cache----->");
        return new Book(isbn, isbn + "test");
    }

    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
