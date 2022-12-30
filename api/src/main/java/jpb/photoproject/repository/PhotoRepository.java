package jpb.photoproject.repository;

import jpb.photoproject.classes.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * CONFIGURED ON EntityManagerConfiguration
 */
public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
