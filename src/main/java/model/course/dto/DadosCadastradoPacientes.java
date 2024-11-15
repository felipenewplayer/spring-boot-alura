package model.course.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastradoPacientes(
        @NotBlank String nome,
        @NotBlank String email,
        @NotBlank @Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}-?\\d{2}") String cpf,
        @NotBlank String telefone,
        @NotNull @Valid DadosEndereco endereco
) {}