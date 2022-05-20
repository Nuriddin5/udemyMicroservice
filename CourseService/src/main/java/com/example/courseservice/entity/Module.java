package com.example.courseservice.entity;


import com.example.courseservice.entity.template.AbsLongEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

// t.me/superJavaDeveloper 15.04.2022;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
 
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity


public class Module extends AbsLongEntity {

    @Column(nullable = false)
    String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    @ToString.Exclude
    Course course;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Module that = (Module) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
