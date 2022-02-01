package pro.sky.java.course2.examinerservice.examinerservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.examinerservice.exeption.BadRequestException;
import pro.sky.java.course2.examinerservice.service.QuestionService;
import pro.sky.java.course2.examinerservice.serviceimpl.ExaminerServiceImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static pro.sky.java.course2.examinerservice.constant.JavaQuestionConstant.*;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    private QuestionService questionServiceMock;

    @InjectMocks
    private ExaminerServiceImpl out;

    @BeforeEach
    public void setUp() {
        questionServiceMock.add(QUESTION_1, ANSWER_1);
        questionServiceMock.add(QUESTION_2, ANSWER_2);
    }

    /**
     * тест, когда коллекцию заполняем случайным объектом
     */
    @Test
    void getQuestionTest() {
        when(questionServiceMock.getCount()).thenReturn(2);
        when(questionServiceMock.getRandomQuestion()).thenReturn(QUESTION_WAS_ADDED_1);
        assertEquals(out.getQuestion(1), QUESTIONS_COLLECTION);
    }

    /**
     * тест, когда выводим всю коллекцию, так как введен запрос равный размеру
     */
    @Test
    void getAllQuestionTest() {
        when(questionServiceMock.getCount()).thenReturn(1);
        when(questionServiceMock.getAll()).thenReturn(QUESTIONS_COLLECTION);
        assertEquals(out.getQuestion(1), QUESTIONS_COLLECTION);
    }


    @Test
    void getBedRequestTest() {
        assertThrows(BadRequestException.class, () -> out.getQuestion(5));
    }
}

