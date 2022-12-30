package jpb.photoproject.repository;

import jpb.photoproject.classes.Client;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * CONFIGURED ON EntityManagerConfiguration
 */
public interface ClientRepository extends JpaRepository<Client, Long> {
}
