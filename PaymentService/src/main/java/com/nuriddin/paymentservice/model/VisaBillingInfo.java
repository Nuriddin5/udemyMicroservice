package com.nuriddin.paymentservice.model;


import com.nuriddin.paymentservice.model.template.AbsLongEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
 
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class VisaBillingInfo extends AbsLongEntity {

    UUID userId;

    @Column(nullable = false)
    String cardHolderName;

    @Column(nullable = false, unique = true)
    String cardNumber;

    @Column(nullable = false)
    LocalDate expirationDate;

    @Column(nullable = false)
    Short cvc;

}
    