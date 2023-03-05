package br.gov.previc.main;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class Main {
	public static void main(String[] args) {
		SparkSession spark = SparkSession
				  .builder()
				  .appName("Java Spark SQL basic example")
				  .config("spark.master", "local")
				  .getOrCreate();
		Dataset<Row> jdbcDF = spark.read()
				  .format("jdbc")
				  .option("url", "jdbc:sqlserver://10.68.14.47;databaseName=INFGER")
				  .option("dbtable", "INFGER.PESSOAS_JURIDICAS_PLANOS")
				  .option("user", "localdev")
				  .option("password", "P@$$w0rd")
				  .load();
		jdbcDF.show();
		spark.stop();
	}
}
