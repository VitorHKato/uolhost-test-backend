package vitor.kato.uolhost_backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import vitor.kato.uolhost_backend.model.dtos.PlayerDto;

@Entity(name = "players")
@Table(name = "players")
//@Getter
//@Setter
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

    public Player() {

    }

    public Player(PlayerDto playerDto) {
        this.name = playerDto.name();
        this.email = playerDto.email();
        this.phoneNumber = playerDto.phoneNumber();
        this.groupType = playerDto.groupType();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCodiname() {
        return codiname;
    }

    public void setCodiname(String codiname) {
        this.codiname = codiname;
    }

    public GroupType getGroupType() {
        return groupType;
    }

    public void setGroupType(GroupType groupType) {
        this.groupType = groupType;
    }
}
