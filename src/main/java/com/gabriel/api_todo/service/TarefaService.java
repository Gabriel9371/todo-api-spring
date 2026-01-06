package com.gabriel.api_todo.service;

import com.gabriel.api_todo.model.Tarefa;
import com.gabriel.api_todo.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {
    private final TarefaRepository repository;

    public TarefaService(TarefaRepository repository){
        this.repository = repository;

    }


    public List<Tarefa> listar(){
        return repository.findAll();
    }

    public Optional<Tarefa> buscarPorID(Long id){
        return repository.findById(id);
    }

    public Tarefa salvar(Tarefa tarefa){
        return repository.save(tarefa);
    }

    public Optional<Tarefa> atualizar(Long id, Tarefa tarefaAtualizada){
        return repository.findById(id).map(tarefa -> {
            tarefa.setTitulo(tarefaAtualizada.getTitulo());
            tarefa.setConcluida(tarefaAtualizada.isConcluida());
            return repository.save(tarefa);
        });

    }

    public boolean deletar(Long id){
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }


}
