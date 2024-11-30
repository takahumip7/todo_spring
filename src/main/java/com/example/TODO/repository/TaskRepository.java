package com.example.TODO.repository;

import com.example.TODO.entity.Task;
import com.example.TODO.mapper.TaskMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * タスク情報にアクセスするためのリポジトリクラスです。
 */
@Repository
public class TaskRepository {

    private final TaskMapper taskMapper;

    /**
     * コンストラクタ
     *
     * @param taskMapper タスクデータへのマッパー
     */
    public TaskRepository(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    /**
     * 全てのタスクを取得します。
     *
     * @return タスクのリスト
     */
    public List<Task> findAll() {
        return taskMapper.findAll();
    }

    /**
     * タスクを保存します。
     *
     * @param task 保存するタスク
     */
    public void save(Task task) {
        taskMapper.save(task);
    }
}
