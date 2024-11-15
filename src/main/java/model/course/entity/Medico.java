package model.course.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import model.course.dto.DadosCadastroMedicos;
import model.course.endereco.Endereco;
import model.course.medico.DadosAtualizacaoMedicos;
import model.course.medico.ESPECIALIDADE;

@Entity(name = "Medico")
@Table(name = "medicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private ESPECIALIDADE especialidade;

    @Embedded
    private Endereco endereco;

    private  boolean ativo;

    public Medico(DadosCadastroMedicos dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
        this.ativo = true;
    }

    public void atualizarInformacoes(@Valid DadosAtualizacaoMedicos dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.telefone() != null){
            this.telefone = dados.telefone();
        }
        if(dados.endereco() != null){
            this.endereco.atualizarInformacoes(dados.endereco());
        }
        if(dados.telefone() != null){
            this.telefone = dados.telefone();
        }


    }

    public void excluir() {
        this.ativo = false;
    }
}
