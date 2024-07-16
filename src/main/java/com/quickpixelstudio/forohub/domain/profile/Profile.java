package com.quickpixelstudio.forohub.domain.profile;

import com.quickpixelstudio.forohub.domain.answer.Answer;
import com.quickpixelstudio.forohub.domain.profile.dto.ProfileUpdateDTO;
import com.quickpixelstudio.forohub.domain.topic.Topic;
import com.quickpixelstudio.forohub.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "profiles")
@Entity(name = "Profile")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private Boolean active;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User user;
    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
    private List<Topic> topicList;
    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
    private List<Answer> answerList;

    public void updateData(ProfileUpdateDTO profileUpdateDTO){
        if(profileUpdateDTO.name() != null) {
            this.name = profileUpdateDTO.name();
        }
        if(profileUpdateDTO.email() != null){
            this.email = profileUpdateDTO.email();
        }
    }
    public void disableProfile(){
        this.active = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Topic> getTopicList() {
        return topicList;
    }

    public void setTopicList(List<Topic> topicList) {
        this.topicList = topicList;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }
}