package discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer		// This annotation activates Eureka Server functionality , functions like: 1.Start the Eureka Server 2.Provide a Dashboard 3.Handle Service Registration 4.Health Checks 5.Replication (Optional): If you configure multiple Eureka Servers (for high availability), they will replicate their service registry data with each other. This ensures that even if one Eureka Server goes down, other Eureka Servers in the cluster can still manage service registration and discovery.
@SpringBootApplication
public class DiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryApplication.class, args);
	}

}
