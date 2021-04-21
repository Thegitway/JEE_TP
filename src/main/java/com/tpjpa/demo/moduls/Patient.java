package com.tpjpa.demo.moduls;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="Patients")
public
class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(length = 25)
    private String nom;
    @Temporal(TemporalType.TIMESTAMP)
    private Date birth;
    private double score;
    private boolean isSick;

}