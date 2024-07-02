package Design_Patterns_Dio.repository;

import Design_Patterns_Dio.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
