package pro.sky.java.course2.examinerservice.serviceimpl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.domain.Question;
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
    private final QuestionService questionService;
    int count;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    /**
     * если запросили 0 или больше чем в наличие - вернем исключение
     * вернем всю коллекцию, если запрошено количество, равное размеру коллекции
     * вернем только неповторяющиеся значения, поэтому накапливаем в Set нужное количество
     */
    private int getCount() {
        return questionService.getCount();
    }

    @Override
    public Collection<Question> getQuestion(int amount) {
        count = getCount();
        Set<Question> examCollection = new HashSet<>();
        if (checkAmount(amount)) {
            throw new BadRequestException();
        }
        if (count == amount) {
            return questionService.getAll();
        }
        while (examCollection.size() < amount) {
            examCollection.add(questionService.getRandomQuestion());
        }
        return examCollection;
    }

    protected boolean checkAmount(int amount) {
        return amount == 0 || amount > count;
    }
}

