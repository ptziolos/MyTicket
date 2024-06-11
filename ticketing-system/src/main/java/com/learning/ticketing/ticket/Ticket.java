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
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@SequenceGenerator(name = "idGenerator", sequenceName = "ticket_sequence", initialValue = 1, allocationSize = 1)
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

    @CreatedBy
    @Column(nullable = false, updatable = false)
    private Integer createdBy;

    @LastModifiedBy
    @Column(insertable = false)
    private Integer lastModifiedBy;

}
