package com.quickpixelstudio.forohub.domain.topic;

import com.quickpixelstudio.forohub.domain.answer.Answer;
import com.quickpixelstudio.forohub.domain.course.Course;
import com.quickpixelstudio.forohub.domain.profile.Profile;
import com.quickpixelstudio.forohub.domain.topic.dto.TopicUpdateDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "topics")
@Entity(name = "Topic")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;
    private LocalDateTime creation_date;
    private Boolean status;
    private Boolean active;
    @OneToMany(mappedBy = "topic")
    private List<Answer> answerList;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_author")
    private Profile profile;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_course")
    private Course course;

    public void updateData(TopicUpdateDTO topicUpdateDTO){
        if(topicUpdateDTO.status() != null){
            this.status = topicUpdateDTO.status();
        }
        if(topicUpdateDTO.title() != null){
            this.title = topicUpdateDTO.title();
        }
        if(topicUpdateDTO.message() != null){
            this.message = topicUpdateDTO.message();
        }
    }
    public void disableTopic(){
        this.active = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(LocalDateTime creation_date) {
        this.creation_date = creation_date;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}