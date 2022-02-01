package pro.sky.java.course2.examinerservice.serviceimpl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.exeption.QuestionExistException;
import pro.sky.java.course2.examinerservice.exeption.QuestionNotExistException;
import pro.sky.java.course2.examinerservice.service.QuestionService;

import java.util.*;
import java.util.Collection;

@Service
public class JavaQuestionService implements QuestionService {
    public final Map<String, Question> examQuestion;
    protected int count = 0;
    /**
     * массив хэш значенийдля вопросов
     * простейшая проверка на дубликаты вопросов
     * отсечь варианты, отличающиеся знаками препинания
     */
    protected Set<Integer> hashForChecking;

    public JavaQuestionService() {
        this.examQuestion = new HashMap<>();
        this.hashForChecking = new HashSet<>();
    }

    @Override
    public int getCount() {
        return count;
    }


    private int getRandom(int count) {
        int min = 1;
        return (int) (Math.random() * (count - min) + min);
    }

    /**
     * добавление нового вопрос
     * первое - получить хэш вопроса
     * второе - проверить массив текущих хэш
     * сохранить или отклонить сохранение
     * счетчик текущего количества - увеличить
     */
    @Override
    public Question add(String question, String answer) {
        if (collectHash(question)) {
            Question item = new Question(question, answer);
            examQuestion.put(item.getQuestion(), item);
            count++;
            return item;
        }
        throw new QuestionExistException();
    }

    @Override
    public Question add(Question question) {
        if (collectHash(question.getQuestion())) {
            examQuestion.put(question.getQuestion(), question);
            count++;
            return question;
        }
        throw new QuestionExistException();
    }

    @Override
    public Question remove(Question question) {
        if (examQuestion.containsKey(question.getQuestion())) {
            return examQuestion.remove(question.getQuestion());
        }
        throw new QuestionNotExistException();
    }

    @Override
    public Collection<Question> getAll() {
        return examQuestion.values();
    }

    /**
     * исключение отработает если вообще нет вопросов - нечего отдавать
     * или если будет ошибка возвращения рандомного числа
     */
    @Override
    public Question getRandomQuestion() {
        int index = 1; // итерации прохода по MAP
        int intRandom = getRandom(count); // случайное число
        for (Question item : examQuestion.values()) {
            if (index == intRandom) {
                return item;
            }
            index += 1;
        }
        throw new QuestionNotExistException();
    }

    private boolean collectHash(String question) {
        int hashValue = getStringHash(question);
        if (hashForChecking.contains(hashValue)) {
            return false;
        }
        hashForChecking.add(getStringHash(question));
        return true;
    }

    private int getStringHash(String string) {
        String[] listFromString = string.split(" ,.");
        for (String item : listFromString) {
            item.toLowerCase();
            item.replace(" ", "");
        }
        String newString = Arrays.toString(listFromString);
        return newString.hashCode();
    }
}
