package pro.sky.java.course2.examinerservice.examinerservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.exeption.BadRequestException;
import pro.sky.java.course2.examinerservice.exeption.QuestionNotExistException;
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

    @Test
    void getQuestionTest() {
        Mockito.when(questionServiceMock.getCount()).thenReturn(1);
        Mockito.when(questionServiceMock.getRandomQuestion()).thenReturn(QUESTION_1);
        assertEquals(QUESTIONS_COLLECTION, out.getQuestion(1));

    }

    @Test
    void getBedRequestTest() {
        assertThrows(BadRequestException.class, () -> out.getQuestion(5));
    }
}

