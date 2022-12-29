package jpb.photoproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.cassandra.CassandraDataAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude={CassandraDataAutoConfiguration.class})
public class PhotoprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoprojectApplication.class, args);
	}

}
