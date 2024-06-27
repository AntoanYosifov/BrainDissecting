package com.antdevrealm.BrainDissecting.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {
//    Admin:
//    Full access to all website functionalities.
//    Can add, edit, or delete articles.
//    Manage user roles and permissions.
//    Oversee site moderation and user interactions.
//
//    Editor:
//    Can add and edit articles.
//    Review and approve articles submitted by contributors.
//    Ensure the quality and accuracy of published content.

//    Contributor:
//    Can submit articles for review.
//    Access to tools for creating and formatting articles.
//    Limited access to editing once articles are published.
//
//    Moderator:
//    Oversee user comments and discussions.
//    Ensure that discussions are respectful and on-topic.
//    Have the ability to delete inappropriate comments and ban users if necessary.

    //    Registered User:
//    Can read articles and post comments.
//    Access to special features like saving favorite articles or subscribing to updates.
//    Can participate in discussions and forums.
//
//    Guest:
//    Limited access to website content.
//    Can read public articles but cannot comment or participate in discussions.
//    Encouraged to register for full access to the site’s features.
    @Column(nullable = false, unique = true)
    private String name;
    @OneToMany(mappedBy = "role")
    private Set<User> users;

    public Role() {
    }

    public String getName() {
        return name;
    }

    public Role setName(String name) {
        this.name = name;
        return this;
    }
}
