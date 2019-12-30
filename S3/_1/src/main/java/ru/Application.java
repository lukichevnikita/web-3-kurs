package ru;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.S3ClientOptions;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectSummary;

import java.io.File;
import java.util.List;


public class Application {

    private static final String accesskey = "rdMBCpxnyeWPh3pRWuXYAR";
    private static final String secret = "59a7jRgTGfv11DtgxpxXLfdqLUaksjUQos4KiZJ3a11F";
    private static AmazonS3 s3;
    private static final String bucketName = "sbb3";


    public static void main(String[] args) {
        ClientConfiguration config = new ClientConfiguration();
        AWSCredentials credentials = new BasicAWSCredentials (accesskey, secret);
        s3 = new AmazonS3Client(credentials, config);
        s3.setEndpoint("hb.bizmrg.com");

        s3.putObject(
                bucketName,
                "1.txt",
                new File("./1")
        );

        List<Bucket> buckets = s3.listBuckets();
        for(Bucket bucket : buckets) {
            System.out.println(bucket.getName());
        }

        ObjectListing objectListing = s3.listObjects(bucketName);
        for(S3ObjectSummary os : objectListing.getObjectSummaries()) {
            System.out.println(os.getKey());
        }
    }


}
