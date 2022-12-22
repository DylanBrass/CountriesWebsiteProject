package com.example.countryproject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name="questions")
@Getter
@Setter
@NoArgsConstructor
public class Question {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @Column(name="question", nullable = false)
    public String Question;
    @Column(name="answer", nullable = false)
    public String Answer;

    @Column(name="fake_answer_one", nullable = false)
    public String FakeAnswerOne;
    @Column(name="fake_answer_two", nullable = false)
    public String FakeAnswerTwo;
    @Column(name="fake_answer_three", nullable = false)
    public String FakeAnswerThree;

    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="country_id")
    private Country country;
}
