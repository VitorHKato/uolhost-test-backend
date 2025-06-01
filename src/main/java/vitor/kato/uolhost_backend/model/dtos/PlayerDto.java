package vitor.kato.uolhost_backend.model.dtos;

import vitor.kato.uolhost_backend.model.GroupType;

public record PlayerDto(
        String name,
        String email,
        String phoneNumber,
        GroupType groupType
) {
}
