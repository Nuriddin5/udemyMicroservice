package com.nuriddin.paymentservice.model;


import com.nuriddin.paymentservice.model.template.AbsLongEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
 
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class PayType extends AbsLongEntity {

    @Column(nullable = false, unique = true)
    String name;

//    @OneToOne
    UUID logo;
}
    