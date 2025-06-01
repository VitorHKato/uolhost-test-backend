package vitor.kato.uolhost_backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "players")
@Table(name = "players")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    private String phoneNumber;

    private String codiname;

    private GroupType groupType;

}
