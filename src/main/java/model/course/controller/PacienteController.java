package model.course.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import model.course.dto.DadosCadastradoPacientes;
import model.course.entity.Paciente;
import model.course.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastradoPacientes dados){
        pacienteRepository.save(new Paciente(dados));
    }
}
