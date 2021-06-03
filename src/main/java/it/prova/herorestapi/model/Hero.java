package it.prova.herorestapi.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "hero")
@Data @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

}
