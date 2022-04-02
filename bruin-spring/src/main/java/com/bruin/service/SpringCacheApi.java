package com.bruin.service;

import com.bruin.model.Book;

/**
 * @author xiongwenwen
 * @since 2022/3/29 10:00 下午
 */
public interface SpringCacheApi {

    Book getByIsbn(String isbn);

    void save(Book book);

    void remove(String isbn);

    Book mixture(String isbn);
}