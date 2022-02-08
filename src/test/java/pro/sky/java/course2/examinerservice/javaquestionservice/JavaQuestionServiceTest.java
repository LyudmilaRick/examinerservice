package pro.sky.java.course2.examinerservice.javaquestionservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.java.course2.examinerservice.exeption.QuestionExistException;
import pro.sky.java.course2.examinerservice.exeption.QuestionNotExistException;
import pro.sky.java.course2.examinerservice.serviceimpl.JavaQuestionService;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.java.course2.examinerservice.constant.JavaQuestionConstant.*;

public class JavaQuestionServiceTest {
    private final JavaQuestionService out = new JavaQuestionService();

    @Test
    void shouldAddWasCorrect() {
        assertEquals(out.add(QUESTION_3, ANSWER_3), QUESTION_WAS_ADDED_3);
    }
    @Test
    void shouldExistAddWasCorrect() {
            out.add(QUESTION_1, ANSWER_1);
            out.add(QUESTION_2, ANSWER_2);
        assertThrows(QuestionExistException.class, () -> out.add(QUESTION_1, ANSWER_1));
    }
    @Test
    void shouldRemoveWasCorrect() {
        out.add(QUESTION_2, ANSWER_2);
        assertEquals(out.remove(QUESTION_WAS_ADDED_2), QUESTION_WAS_ADDED_2 );
    }
    @Test
    void shouldRemoveNotExistWasCorrect() {
        out.add(QUESTION_2, ANSWER_2);
        assertThrows(QuestionNotExistException.class, () -> out.remove(QUESTION_WAS_ADDED_3));
    }
    @Test
    public void shouldGetAllWasCorrect() {
        out.add(QUESTION_1, ANSWER_1);
        out.add(QUESTION_2, ANSWER_2);
        assertTrue(QUESTIONS_COLLECTION_LIST.containsAll(out.getAll()));
    }
}

