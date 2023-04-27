package com.avanade.desafio.model;

//import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PLAYER")
@Entity
public class Player implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "ID", nullable = false)
    private Long id;
    @Column( name = "NAME", nullable = false)
    private String name;
    @Column( name = "CHARACTER", nullable = false)
    private String character;
    @Column( name = "OPPONENT", nullable = false)
    private String opponent;
}
