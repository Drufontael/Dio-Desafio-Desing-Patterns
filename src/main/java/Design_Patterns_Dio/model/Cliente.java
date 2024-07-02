package Design_Patterns_Dio.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_customer")
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    @ManyToOne
    private CEP cep;
    private Integer numero;
    private String complemento;
}
