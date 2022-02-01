package pro.sky.java.course2.examinerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.examinerservice.service.ExaminerService;
import pro.sky.java.course2.examinerservice.serviceimpl.ExaminerServiceImpl;

import java.util.Collection;

/**
 * контроллер
 */
@RestController
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerServiceImpl examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping(value = "/get", params = {"amount"})
    Collection<String> getQuestion(@RequestParam(name = "amount") int value) {
        return examinerService.getQuestion(value);
    }
}
