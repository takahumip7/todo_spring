package com.example.TODO.mapper;

import com.example.TODO.entity.Task;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * タスクエンティティにアクセスするための MyBatis マッパーインターフェースです。
 */
@Mapper
public interface TaskMapper {

    /**
     * 全てのタスクを取得します。
     *
     * @return タスクのリスト
     */
    List<Task> findAll();

    /**
     * タスクを保存します。
     *
     * @param task 保存するタスク
     */
    void save(Task task);
}
