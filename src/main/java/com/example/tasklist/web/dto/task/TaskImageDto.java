package com.example.tasklist.web.dto.task;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class TaskImageDto {

    @NotNull
    private MultipartFile file;
}