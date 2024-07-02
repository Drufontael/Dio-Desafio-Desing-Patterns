package Design_Patterns_Dio.service;

import Design_Patterns_Dio.dto.CEPDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep",url = "https://viacep.com.br/ws")
public interface CEPService {
    @GetMapping("/{cep}/json/")
    CEPDto consultarCep(@PathVariable("cep") String cep);
}
