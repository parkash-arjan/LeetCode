package aws.example.athena;

public class ExampleConstants {
	public static final int CLIENT_EXECUTION_TIMEOUT = 100000;
	public static final String ATHENA_OUTPUT_BUCKET = "s3://s3athenabucket001/data/";
	public static final String ATHENA_SAMPLE_QUERY = "SELECT * FROM my_table;";
	public static final long SLEEP_AMOUNT_IN_MS = 1000;
	public static final String ATHENA_DEFAULT_DATABASE = "my_database";
}
