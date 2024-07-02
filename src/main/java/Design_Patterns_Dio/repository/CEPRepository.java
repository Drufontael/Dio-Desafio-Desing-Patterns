package Design_Patterns_Dio.repository;

import Design_Patterns_Dio.model.CEP;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CEPRepository extends JpaRepository<CEP,String> {
}
