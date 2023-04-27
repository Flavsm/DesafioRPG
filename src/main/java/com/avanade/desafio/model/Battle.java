package com.avanade.desafio.model;

//import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.Array;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table( name = "BATTLE" )
@Entity
public class Battle implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "ID", nullable = false)
    private Long id;
    @Column ( name = "PLAYER_1", nullable = false)
    private String player_1;
    @Column ( name = "PLAYER_2", nullable = false)
    private String player_2;
//    @Column ( name = "FIRST_MOVE", nullable = false)
//    private String firstMove;
//    @Column ( name = "TURNS", nullable = false)
//    private String turns;
}
