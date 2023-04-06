package jpb.photoproject.configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
@EnableJpaRepositories(basePackages = "jpb.photoproject.repository", entityManagerFactoryRef = "entityManager")
public class EntityManagerConfiguration {

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManager(
            final EntityManagerFactoryBuilder entityManagerFactoryBuilder, final HikariDataSource hikariDataSource) {

        return entityManagerFactoryBuilder.dataSource(hikariDataSource)
                .packages("jpb.photoproject.classes")
                .build();
    }
}
