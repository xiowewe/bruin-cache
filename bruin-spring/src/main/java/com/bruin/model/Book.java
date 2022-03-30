package com.bruin.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xiongwenwen
 * @since 2022/3/29 10:03 下午
 */
@Data
@AllArgsConstructor
public class Book implements Serializable {
    private String name;
    private String desc;
}
