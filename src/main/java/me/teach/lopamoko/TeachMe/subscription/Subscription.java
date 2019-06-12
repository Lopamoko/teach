package me.teach.lopamoko.TeachMe.subscription;

import lombok.Getter;
import lombok.Setter;
import me.teach.lopamoko.TeachMe.user.UserModel;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@SequenceGenerator(name = "SUBSCRIPTION_SEQ", allocationSize = 1)
@Table(name = "SUBSCRIPTION")
public class Subscription {

    @Id
    @GeneratedValue(generator = "SUBSCRIPTION_SEQ")
    @Column(name = "SUBSCRIPTION_ID")
    private Long subscriptionId;

    @Column(name = "SUBSCRIPTION_NAME")
    private String subscriptionName;

    @OneToMany(mappedBy = "subscription")
    private Set<UsersSubscriptions> users = new HashSet<>();

}
