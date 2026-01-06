package com.gabriel.api_todo.controller;


import com.gabriel.api_todo.model.Tarefa;
import com.gabriel.api_todo.service.TarefaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    private final TarefaService service;

    public TarefaController(TarefaService service){
        this.service = service;
    }


    @GetMapping
    public List<Tarefa> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarPorID(@PathVariable Long id){
        return service.buscarPorID(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Tarefa> criar(@Valid @RequestBody Tarefa tarefa){
        Tarefa salva = service.salvar(tarefa);
        return ResponseEntity.status(201).body(salva);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizar(@PathVariable Long id, @RequestBody Tarefa tarefa){
        return service.atualizar(id, tarefa).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Tarefa> deletar(@PathVariable Long id){
        if(service.deletar(id)){
            return ResponseEntity.noContent().build();

        }

        return  ResponseEntity.notFound().build();
    }


    @PatchMapping("/{id}")
    public ResponseEntity<Tarefa> concluir(@PathVariable Long id){
        return service.concluir(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }



}
