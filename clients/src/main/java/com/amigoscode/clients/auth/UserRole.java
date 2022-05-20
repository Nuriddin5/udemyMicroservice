package com.amigoscode.clients.auth;


import com.amigoscode.clients.template.AbsLongEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;

// t.me/superJavaDeveloper 15.04.2022;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity


public class UserRole extends AbsLongEntity {

    @Column(nullable = false, unique = true)
    String roleName;

}
