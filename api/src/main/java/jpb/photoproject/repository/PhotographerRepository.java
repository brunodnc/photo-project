package jpb.photoproject.repository;

import jpb.photoproject.classes.Photographer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * CONFIGURED ON EntityManagerConfiguration
 */
public interface PhotographerRepository extends JpaRepository<Photographer,Long> {
}
