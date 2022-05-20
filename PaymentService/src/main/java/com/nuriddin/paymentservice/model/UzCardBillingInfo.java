package com.nuriddin.paymentservice.model;


import com.nuriddin.paymentservice.model.template.AbsLongEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
 
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class UzCardBillingInfo extends AbsLongEntity {

    UUID userId;

    @Column(nullable = false, unique = true)
    String cardNumber;

    @Column(nullable = false)
    LocalDate expirationDate;

}
    