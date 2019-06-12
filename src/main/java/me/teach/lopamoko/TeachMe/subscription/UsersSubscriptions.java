package me.teach.lopamoko.TeachMe.subscription;

import lombok.Getter;
import lombok.Setter;
import me.teach.lopamoko.TeachMe.user.UserModel;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@SequenceGenerator(name = "USERS_SUBSCRIPTIONS_SEQ", allocationSize = 1)
@Table(name = "USERS_SUBSCRIPTION")
public class UsersSubscriptions {
    @Id
    @Column(name = "USER_SUBSCRIPTION_ID")
    @GeneratedValue(generator = "USERS_SUBSCRIPTIONS_SEQ")
    private Long userSubscriptionId;

    @ManyToOne
    @JoinColumn(name = "SUBSCRIPTION_ID")
    private Subscription subscription;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private UserModel user;

    @Column(name = "DATE_FROM")
    private Date dateFrom;

    @Column(name = "DATE_TO")
    private Date dateTo;
}
