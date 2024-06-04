package com.learning.ticketing.feedback;

import com.learning.ticketing.common.BaseEntity;
import com.learning.ticketing.ticket.Ticket;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
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
public class Feedback extends BaseEntity {

    private Double note;
    private String comment;

    @OneToOne(mappedBy = "feedback")
    private Ticket ticket;
}
