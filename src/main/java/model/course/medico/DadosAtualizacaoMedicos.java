package model.course.medico;

import jakarta.validation.constraints.NotNull;
import model.course.dto.DadosEndereco;
import model.course.endereco.Endereco;

public record DadosAtualizacaoMedicos(
        @NotNull
        Long id,
        String nome,
        String  telefone,
        DadosEndereco endereco) {
}
