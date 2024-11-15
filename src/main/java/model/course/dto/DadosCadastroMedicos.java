package model.course.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import model.course.medico.ESPECIALIDADE;

public record DadosCadastroMedicos(
        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,

        @NotNull
        ESPECIALIDADE especialidade,

        @NotNull @Valid
        DadosEndereco endereco) {
}
