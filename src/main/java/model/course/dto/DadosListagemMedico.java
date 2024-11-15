package model.course.dto;

import model.course.entity.Medico;
import model.course.medico.ESPECIALIDADE;

public record DadosListagemMedico(
        Long id,
        String nome,
        String email,
        String crm,
        ESPECIALIDADE especialidade  ) {

    public DadosListagemMedico(Medico medico){
        this(
                medico.getId(),
                medico.getNome(),
                medico.getEmail(),
                medico.getCrm(),
                medico.getEspecialidade());
    }
}
