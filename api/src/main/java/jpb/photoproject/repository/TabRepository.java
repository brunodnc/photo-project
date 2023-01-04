package jpb.photoproject.repository;

import jpb.photoproject.classes.Tab;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * CONFIGURED ON EntityManagerConfiguration
 */
public interface TabRepository extends JpaRepository<Tab, Long> {


    List<Tab> findByClientID(Long id);


}
