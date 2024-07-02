package Design_Patterns_Dio.controller;

import Design_Patterns_Dio.model.Cliente;
import Design_Patterns_Dio.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clientes")
@AllArgsConstructor
public class ClienteController {

    private ClienteService service;

    @PostMapping
    public ResponseEntity create(@RequestBody Cliente cliente){
        service.create(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.read(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id,@RequestBody Cliente cliente){
        service.update(id,cliente);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/id")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
