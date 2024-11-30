package com.example.TODO.form;

import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Getter
@Setter
public class TaskForm {

    //タスクID
    private int taskId;

    //タイトルは1文字以上100文字以下
    @NotBlank
    @Size(min = 1, max = 100)
    private String title;

    //説明は最大200文字
    @Size(max = 200)
    private String description;

    //デッドラインは必須項目
    @NotNull
    private LocalDateTime deadline;

    //ステータスは1から3の範囲
    @Min(value = 0)
    @Max(value = 3)
    private int status;

    //更新日時
    private LocalDateTime updatedAt;

}
