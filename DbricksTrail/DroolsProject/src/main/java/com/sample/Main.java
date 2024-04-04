package com.sample;
import com.databricks.sdk.WorkspaceClient;
import com.databricks.sdk.scala.dbutils.DBUtils;
import com.databricks.sdk.core.DatabricksConfig;

import com.databricks.sdk.service.compute.CreateCluster;
import com.databricks.sdk.service.compute.CreateClusterResponse;

public class Main {
  public static void main(String[] args) {
	  
		/*
		 * DatabricksConfig cfg = new DatabricksConfig()
		 * .setHost("https://adb-2984540110607491.11.azuredatabricks.net")
		 * .setToken("dapi13cb25d283d541d115f6700a8ae5322f");
		 */
  	WorkspaceClient w = new WorkspaceClient();


  	String filePath = "/Volumes/main/default/my-volume/zzz_hello.txt";
    String fileData = "Hello, Databricks!";
    DBUtils dbutils = DBUtils.getDBUtils(new DatabricksConfig().setProfile("DEFAULT"));

    dbutils.fs().put(filePath, fileData, true);

    System.out.println(dbutils.fs().head(filePath, 18));

    dbutils.fs().rm(filePath, false);
  }
}
