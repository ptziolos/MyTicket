package com.learning.ticketing.ticket;

import com.learning.ticketing.common.BaseEntity;
import com.learning.ticketing.feedback.Feedback;
import com.learning.ticketing.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ticket extends BaseEntity {

    private String subject;
    private String description;
    private String image;
    private Priority priority;
    private Status status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "feedback_id")
    private Feedback feedback;

    @ManyToOne
    @JoinColumn(name="petitioner_id")
    private User petitioner;

    @ManyToOne
    @JoinColumn(name="receiver_id")
    private User receiver;



}
