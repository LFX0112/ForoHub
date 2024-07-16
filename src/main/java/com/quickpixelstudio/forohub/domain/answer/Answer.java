package com.quickpixelstudio.forohub.domain.answer;

import com.quickpixelstudio.forohub.domain.answer.dto.AnswerUpdateDTO;
import com.quickpixelstudio.forohub.domain.profile.Profile;
import com.quickpixelstudio.forohub.domain.topic.Topic;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "answers")
@Entity(name = "Answer")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private LocalDateTime creation_date;
    private Boolean solution;
    private Boolean active;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_author")
    private Profile profile;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_topic")
    private Topic topic;

    public void updateAnswer(AnswerUpdateDTO answerUpdateDTO){
        if(answerUpdateDTO.solution()){
            this.solution = answerUpdateDTO.solution();
        }
        if(answerUpdateDTO.message() != null){
            this.message = answerUpdateDTO.message();
        }
    }

    public void disableAnswer(){
        this.active = false;
    }
}