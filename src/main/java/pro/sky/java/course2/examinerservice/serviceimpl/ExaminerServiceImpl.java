package pro.sky.java.course2.examinerservice.serviceimpl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.exeption.BadRequestException;
import pro.sky.java.course2.examinerservice.service.ExaminerService;
import pro.sky.java.course2.examinerservice.service.QuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Реализовать ExaminerServiceImpl
 * Его задача: создать коллекцию и заполнить её
 * с помощью вызова getRandomQuestion у QuestionService случайными вопросами.
 */
@Service
public class ExaminerServiceImpl implements ExaminerService {
    public QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<String> getQuestion(int amount) {
        Set<String> examCollection = new HashSet<>();
        if (checkAmount(amount)) {
            throw new BadRequestException();
        }
        while (examCollection.size() < amount) {
            examCollection.add(questionService.getRandomQuestion());
        }
        return examCollection;
    }

    protected boolean checkAmount(int amount) {
        return amount == 0 || amount > questionService.getCount();
    }
}

