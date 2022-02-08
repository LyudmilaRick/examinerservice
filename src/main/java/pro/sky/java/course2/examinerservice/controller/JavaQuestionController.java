package pro.sky.java.course2.examinerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.service.QuestionService;

import java.util.Collection;

/**
 * контроллер
 */
@RestController
@RequestMapping("/java")
public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    /**
     * @param question question
     * @param answer   answer
     * @return Question
     * @DisterRU Нет никакого смысла дублировать имя переменной в аннотации.
     * Имеет смысл только в случае отличия имени параметра запроса от имени параметра метода.
     */
    @GetMapping("/add")
    public Question add(@RequestParam String question, @RequestParam String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping("/remove")
    public Question remove(@RequestParam String question, @RequestParam String answer) {
        Question item = new Question(question, answer);
        return questionService.remove(item);
    }

    @GetMapping
    public Collection<Question> getAll() {
        return questionService.getAll();
    }
}
