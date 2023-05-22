package br.com.afzdev.algamoneyapi.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @NotNull
    private String nome;

    @NotNull
    private boolean ativo;

    @Embedded
    private Endereco endereco;
}
