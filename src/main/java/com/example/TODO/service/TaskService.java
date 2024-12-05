package com.example.TODO.service;

import com.example.TODO.entity.Task;
import com.example.TODO.form.TaskForm;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * タスク関連のサービスを提供するインターフェースです。
 */
public interface TaskService {

    /**
     * すべてのタスクを取得します。
     *
     * @return タスクのリスト
     */
    List<Task> findAll();

    /**
     * タスクを保存します。
     *
     * @param taskForm タスクのフォームデータ
     * @return 保存完了メッセージ
     */
    String save(TaskForm taskForm);

    /**
     * 指定されたタスクIDに対応するタスクを取得します。
     *
     * @param taskId タスクID
     * @return タスクのフォームデータ
     */
    TaskForm getTask(int taskId);

    /**
     * タスクのフォームデータをタスクエンティティに変換します。
     *
     * @param taskForm タスクのフォームデータ
     * @return タスクエンティティ
     */
    Task convertToTask(TaskForm taskForm);

    /**
     * タスクエンティティをタスクのフォームデータに変換します。
     *
     * @param task タスクエンティティ
     * @return タスクのフォームデータ
     */
    TaskForm convertToTaskForm(Task task);
}
