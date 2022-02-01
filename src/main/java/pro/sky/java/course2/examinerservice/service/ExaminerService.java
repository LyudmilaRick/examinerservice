package pro.sky.java.course2.examinerservice.service;

import java.util.Collection;

/**
 * сервис студента
 * получить экзаменационные вопросы
 */
public interface ExaminerService {
    Collection<String> getQuestion(int amount);
}
