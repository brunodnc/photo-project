package jpb.photoproject.repository;

import jpb.photoproject.classes.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * CONFIGURED ON EntityManagerConfiguration
 */
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
}
