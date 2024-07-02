package Design_Patterns_Dio.service;

import Design_Patterns_Dio.dto.CEPDto;
import Design_Patterns_Dio.model.CEP;
import Design_Patterns_Dio.model.Cliente;
import Design_Patterns_Dio.repository.CEPRepository;
import Design_Patterns_Dio.repository.ClienteRepository;
import Design_Patterns_Dio.util.Util;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClienteService {

    private ClienteRepository clienteRepository;
    private CEPRepository cepRepository;
    private CEPService cepService;

    public void create(Cliente cliente){
        CEP cep=cepRepository.findById(cliente.getCep().getCep()).orElseGet(()->{
            String cepValido=Util.valideCEP(cliente.getCep().getCep());
            CEPDto cepDto=cepService.consultarCep(cepValido);
            if(cepDto!=null) {
                CEP novoCEP = new CEP();
                novoCEP.setCep(cepDto.getCep());
                novoCEP.setLogradouro(cepDto.getLogradouro());
                novoCEP.setBairro(cepDto.getBairro());
                novoCEP.setLocalidade(cepDto.getLocalidade());
                novoCEP.setUf(cepDto.getUf());
                cepRepository.save(novoCEP);
                return novoCEP;
            }else throw new RuntimeException("CEP não encontrado");
        });
        clienteRepository.save(cliente);
    }
    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }

    public Cliente read(Long id){
        return clienteRepository.findById(id).orElseThrow(()->new RuntimeException("Cliente não encontrado"));
    }

    public void update(Long id,Cliente cliente){
        Cliente clienteOld=clienteRepository.findById(id).orElseThrow(()->new RuntimeException("Cliente não encontrado"));
        Util.copyNonNullProperties(cliente,clienteOld);
        clienteRepository.save(clienteOld);
    }

    public void delete(Long id){
        clienteRepository.deleteById(id);
    }


}
