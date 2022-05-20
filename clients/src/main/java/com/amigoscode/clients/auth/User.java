package com.amigoscode.clients.auth;


// t.me/superJavaDeveloper 15.04.2022;


import com.amigoscode.clients.template.AbsUUIDEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@FieldDefaults(level = AccessLevel.PRIVATE)

public class User extends AbsUUIDEntity {


    @Column(nullable = false)
    String fullName;

    @Column(nullable = false, unique = true, name = "username")
    String username;

    @Column(nullable = false)
    String password;


    String headLine;

    String biography;

    Integer avgRating;

    Integer numberOfReviews;

    Integer numberOfStudents;


    String phoneNumber;

    UUID attachmentForProfilePhoto;

    @ManyToMany
//    @JoinTable(
//            name = "users_roles",
//            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<UserRole> roles;

    @Override
    public String toString() {
        return "User{" +
               "fullName='" + fullName + '\'' +
               ", username='" + username + '\'' +
               ", password='" + password + '\'' +
               ", headLine='" + headLine + '\'' +
               ", biography='" + biography + '\'' +
               ", avgRating=" + avgRating +
               ", numberOfReviews=" + numberOfReviews +
               ", numberOfStudents=" + numberOfStudents +
               ", phoneNumber='" + phoneNumber + '\'' +
               ", attachmentForProfilePhoto='" + attachmentForProfilePhoto + '\'' +
               '}';
    }
//    @OneToMany(mappedBy = "user", orphanRemoval = true)
//    @ToString.Exclude
//    List<CourseRate> courseRates;
//
//    @OneToMany(mappedBy = "user", orphanRemoval = true)
//    @ToString.Exclude
//    List<LessonStatusForUser> lessonStatusForUsers;


    public User(String fullName, String username, String password) {
        this.fullName = fullName;
        this.username = username;
        this.password = password;
    }

    public User(String fullName, String username, String password, List<UserRole> roles) {
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return getId() != null && Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
