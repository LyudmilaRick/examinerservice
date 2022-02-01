package pro.sky.java.course2.examinerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.service.QuestionService;
import pro.sky.java.course2.examinerservice.serviceimpl.JavaQuestionService;

import java.util.Collection;

/**
 * контроллер
 */
@RestController
public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController(JavaQuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    public Question add(@RequestParam(value = "question") String question, @RequestParam(value = "answer") String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping("/remove")
    public Question remove(@RequestParam(value = "question") String question, @RequestParam(value = "answer") String answer) {
        Question item = new Question(question, answer);
        return questionService.remove(item);
    }

    @GetMapping("/")
    public Collection<Question> getAll() {
        return questionService.getAll();
    }
}
