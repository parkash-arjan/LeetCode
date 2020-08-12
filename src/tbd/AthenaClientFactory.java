package aws.example.athena;

import software.amazon.awssdk.auth.credentials.InstanceProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.athena.AthenaClient;
import software.amazon.awssdk.services.athena.AthenaClientBuilder;

/**
 * AthenaClientFactory ------------------------------------- This code shows how
 * to create and configure an Amazon Athena client.
 */
public class AthenaClientFactory {
	/**
	 * AthenaClientClientBuilder to build Athena with the following properties: -
	 * Set the region of the client - Use the instance profile from the EC2 instance
	 * as the credentials provider - Configure the client to increase the execution
	 * timeout.
	 */
	private final AthenaClientBuilder builder = AthenaClient.builder().region(Region.US_EAST_1)
			.credentialsProvider(InstanceProfileCredentialsProvider.create());

	public AthenaClient createClient() {
		return builder.build();
	}
}
