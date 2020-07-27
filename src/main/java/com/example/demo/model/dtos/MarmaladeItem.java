package com.example.demo.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MarmaladeItem {
    private long id;
    @NotEmpty
    private String taste;
    private String shape;
    private String provider;
}
