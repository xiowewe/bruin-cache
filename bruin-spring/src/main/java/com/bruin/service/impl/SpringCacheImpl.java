package com.bruin.service.impl;

import com.bruin.model.Book;
import com.bruin.service.SpringCacheApi;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author xiongwenwen
 * @since 2022/3/29 10:08 下午
 */
@Service
public class SpringCacheImpl implements SpringCacheApi {

    @Override
    @Cacheable(value = "books", key = "#root.method.name + #isbn", condition = "#isbn.length() > 0")
    public Book getByIsbn(String isbn) {
        simulateSlowService();
        return new Book(isbn, "Some book");
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
