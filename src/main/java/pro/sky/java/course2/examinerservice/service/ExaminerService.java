package pro.sky.java.course2.examinerservice.service;

import pro.sky.java.course2.examinerservice.domain.Question;

import java.util.Collection;
import java.util.Set;

/**
 * сервис студента
 * получить экзаменационные вопросы
 */
public interface ExaminerService {
    Collection<Question> getQuestion(int amount);
}
