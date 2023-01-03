package jpb.photoproject.repository;

import jpb.photoproject.classes.Tab;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * CONFIGURED ON EntityManagerConfiguration
 */
public interface TabRepository extends JpaRepository<Tab, Long> {

    Tab findById(Long id);

    List<Tab> findByClientId(Long id);


}
