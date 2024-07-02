package Design_Patterns_Dio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_cep")
@Data
public class CEP {
    @Id
    public String cep;
    public String logradouro;
    public String bairro;
    public String localidade;
    public String uf;

}
