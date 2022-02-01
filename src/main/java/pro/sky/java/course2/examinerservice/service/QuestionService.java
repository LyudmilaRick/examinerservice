package pro.sky.java.course2.examinerservice.service;

import pro.sky.java.course2.examinerservice.domain.Question;

import java.util.Collection;

/**
 * сервис преподавателя
 * возможность добавлять/удалять вопросы+ответы
 * возможно проверить полный список
 */
public interface QuestionService {
    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

    String getRandomQuestion();

    int getCount();
}
