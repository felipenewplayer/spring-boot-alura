package model.course.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import model.course.dto.DadosCadastroMedicos;
import model.course.dto.DadosListagemMedico;
import model.course.entity.Medico;
import model.course.medico.DadosAtualizacaoMedicos;
import model.course.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedicos dados){
        medicoRepository.save(new Medico(dados));
    }

    @GetMapping

    public Page<DadosListagemMedico> listar(@PageableDefault(size =10) Pageable paginacao){
        return medicoRepository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }

    @PutMapping()
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedicos dados){
        var medico = medicoRepository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable Long id){
        var medico = medicoRepository.getReferenceById(id);
        medico.excluir();
    }




}
