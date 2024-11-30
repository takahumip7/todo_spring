package com.example.TODO.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * タスクエンティティクラス
 */
@Getter
@Setter
public class Task {

    /**
     * タスクID（自動インクリメントされる一意の識別子）。
     */
    private int taskId;

    /**
     * タスクのタイトル。
     */
    private String title;

    /**
     * タスクの説明。
     */
    private String description;

    /**
     * タスクの締め切り日時。
     */
    private LocalDateTime deadline;

    /**
     * タスクのステータス（例: 1 - 未着手, 2 - 作業中, 3 - 完了）。
     */
    private int status;

    /**
     * ユーザーID（タスクを所有するユーザーの識別子）。
     */
    private Integer userId;

    /**
     * タスクの作成日時（デフォルトは現在の日時）。
     */
    private LocalDateTime createdAt;

    /**
     * タスクの更新日時（更新時に現在の日時に自動設定）。
     */
    private LocalDateTime updatedAt;

    /**
     * 削除フラグ（タスクが削除されたかどうかを示す）。
     */
    private Boolean deleteFlg;
}
