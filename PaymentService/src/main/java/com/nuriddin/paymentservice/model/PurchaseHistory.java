package com.nuriddin.paymentservice.model;


import com.nuriddin.paymentservice.model.enums.PaymentStatus;
import com.nuriddin.paymentservice.model.template.AbsLongEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
 
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class PurchaseHistory extends AbsLongEntity {

    double totalAmount;

    @ManyToMany
    @JoinTable(
            name = "payment_histories_courses",
            joinColumns = @JoinColumn(name = "purchase_history_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    @ToString.Exclude
    List<Course> courseList;
    // TODO: 20.05.2022 in openfeinght


    @Enumerated(EnumType.STRING)
    PaymentStatus paymentStatus;

    boolean idRefunded;

    String stripePaymentIntent;
}
    