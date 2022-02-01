package pro.sky.java.course2.examinerservice.constant;

import pro.sky.java.course2.examinerservice.domain.Question;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JavaQuestionConstant {
    public static final String QUESTION_1 = "Полиморфизм";
    public static final String QUESTION_2 = "Инкапсуляция";
    public static final String QUESTION_3 = "Наследование";
    public static final String ANSWER_1 = " это свойство, позволяющее " +
            "с помощью одного интерфейса обращаться к общему классу действий";
    public static final String ANSWER_2 = " разграничение доступа к данным и возможностям классов и объектов";
    public static final String ANSWER_3 = " это процесс, в ходе которого один объект приобретает свойства другого объекта";

    public static final Question QUESTION_WAS_ADDED_3 = new Question(
            "Наследование", " это процесс, в ходе которого один объект приобретает свойства другого объекта");
    public static final Question QUESTION_WAS_ADDED_2 = new Question(
            "Инкапсуляция", " разграничение доступа к данным и возможностям классов и объектов");

    public static final Collection<Question> QUESTIONS_FACTORY = List.of(
            new Question("Полиморфизм", " это свойство, позволяющее " +
                    "с помощью одного интерфейса обращаться к общему классу действий"),
            new Question("Инкапсуляция", " разграничение доступа к данным и возможностям классов и объектов")
    );

    public static final Collection<String> QUESTIONS_COLLECTION = Set.of("Полиморфизм");

    public static final Map<String, Question> ALL_QUESTION = Map.ofEntries(
            Map.entry("Полиморфизм", new Question("Полиморфизм", "  это свойство, позволяющее " +
                    "с помощью одного интерфейса обращаться к общему классу действий")),
            Map.entry("Инкапсуляция", new Question("Инкапсуляция", " разграничение доступа к данным и возможностям классов и объектов")),
            Map.entry("Наследование", new Question("Наследование", " это процесс, в ходе которого один объект приобретает свойства другого объекта")));

}
