package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Post {
    private int id;
    private String content;

    @NonNull
    private String title;

    @NonNull
    private String status;

    @NonNull
    private Boolean published;

    @NonNull
    private Publisher publisher;
}

