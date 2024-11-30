package com.example.TODO.controller;

import com.example.TODO.entity.Task;
import com.example.TODO.form.TaskForm;
import com.example.TODO.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * Webアプリケーションのタスク関連機能を担当するControllerクラスです。
 * タスクの一覧表示、登録、変更などの機能が含まれています。
 *
 */
@Controller
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    /**
     * タスクの一覧を表示するメソッドです。
     *
     * @param model タスク一覧をViewに渡すためのSpringのModelオブジェクト
     * @return "task/index" - タスク一覧表示用のHTMLテンプレートのパス
     */
    @RequestMapping(value = "/task/list", method = RequestMethod.GET)
    public String showTask(Model model){

        //タスクの一覧を取得
        List<Task> taskList = taskService.findAll();
        model.addAttribute("taskList", taskList);
        return "task/index";
    }

    /**
     * タスクの新規登録画面を表示するメソッドです。
     *
     * @param model タスク一覧をViewに渡すためのSpringのModelオブジェクト
     * @return "task/edit" - タスク新規登録画面のHTMLテンプレートのパス
     */
    @GetMapping(value = "/task/add")
    public String showForm(Model model){
        //タスクフォームを作成
        TaskForm taskForm = new TaskForm();

        model.addAttribute("taskForm", taskForm);
        return "task/edit";
    }

    /**
     * タスクの確認画面を表示するメソッドです。
     *
     * @param taskForm タスクのフォームデータ
     * @param bindingResult バリデーション結果を保持するオブジェクト
     * @param model タスク一覧をViewに渡すためのSpringのModelオブジェクト
     * @return "task/confirm" - タスク確認画面のHTMLテンプレートのパス
     */
    @GetMapping(value = "/task/confirm")
    public String showConfirmForm(@Validated TaskForm taskForm, BindingResult bindingResult, Model model){
        //バリデーションチェックがある場合は変更画面に戻る
        if(bindingResult.hasErrors()){
            return "task/edit";
        }

        model.addAttribute("taskForm", taskForm);
        return "task/confirm";
    }

    /**
     * タスクを保存するメソッドです。
     *
     * @param taskForm タスクのフォームデータ
     * @param bindingResult バリデーション結果を保持するオブジェクト
     * @param redirectAttributes リダイレクト時に属性を渡すためのSpringのRedirectAttributesオブジェクト
     * @param model タスク一覧をViewに渡すためのSpringのModelオブジェクト
     * @return "redirect:/task/complete" - タスク確認画面へのリダイレクト
     */
    @PostMapping(value = "/task/save")
    public String saveTask(@Validated TaskForm taskForm, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){

        //バリデーションチェック
        if (bindingResult.hasErrors()){
            //バリデーションエラーがある場合は変更画面に遷移
            return "task/edit";
        }

        //保存処理
        String completeMessage = taskService.save(taskForm);

        //redirect先に値を渡す
        redirectAttributes.addFlashAttribute("completeMessage", completeMessage);

        return "redirect:/task/complete";
    }

    /**
     * タスク完了画面を表示するメソッドです。
     *
     * @return "task/complete" - タスク完了画面のHTMLテンプレートのパス
     */
    @GetMapping("/task/complete")
    public String showCompletePage(){
        return "task/complete";
    }
}
