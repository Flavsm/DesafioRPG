package com.avanade.desafio.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
//import jakarta.persistence.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table( name = "HERO" )
@Entity
public class Hero implements Serializable {
//public class Hero {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "ID", nullable = false)
    private Long id;
    @Column( name = "NAME", nullable = false)
    private String name;
    @Column( name = "HEALTH", nullable = false)
    private Integer health;
    @Column( name = "STRENGTH", nullable = false)
    private Integer strength;
    @Column( name = "DEFENSE", nullable = false)
    private Integer defense;
    @Column( name = "AGILITY", nullable = false)
    private Integer agility;
    @Column( name = "DICE_QUANTITY", nullable = false)
    private Integer diceQuantity;
    @Column( name = "DICE_FACES", nullable = false)
    private Integer diceFaces;
//    @Column( name = "CREATED_AT", nullable = false)
//    private LocalDateTime createdAt;

//    @Id
//    @GeneratedValue( strategy = GenerationType.AUTO)
//    private Long id;
//    private String name;
//    private Integer health;
//    private Integer strength;
//    private Integer defense;
//    private Integer agility;
//    private Integer diceQuantity;
//    private Integer diceFaces;
}

