package com.aspose.hadoop.examples;

import com.aspose.hadoop.core.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapred.SequenceFileInputFormat;
import org.apache.hadoop.mapred.SequenceFileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class CreateDocumentTextSequence extends Configured implements Tool{
	public static class Map extends MapReduceBase implements Mapper<Text, BytesWritable, Text, Text> {
		public void map(Text key, BytesWritable value, OutputCollector<Text, Text> output, Reporter reporter) throws IOException {
			InputStream input = new ByteArrayInputStream(value.getBytes());
			try {
					DocumentParser sparse = new DocumentParser(input);
					output.collect(key, new Text(sparse.getParsedDocument()));
			} catch (IOException ioe) { 
				ioe.printStackTrace();
			} 			
		}
	}
	public int run(String[] args) throws Exception {
		JobConf conf = new JobConf(CreateEmailTextSequence.class);
		conf.setJobName("CreateDocumentTextSequence");
		conf.setMapperClass(Map.class);
		conf.setInputFormat(SequenceFileInputFormat.class);
		conf.setOutputFormat(SequenceFileOutputFormat.class);
		FileInputFormat.setInputPaths(conf, new Path(args[0]));
		FileOutputFormat.setOutputPath(conf, new Path(args[1]));
		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(Text.class);
		JobClient.runJob(conf);
		return 0;
	}

	public static void main(String[] args) throws Exception {
		int exitCode = ToolRunner.run(new CreateDocumentTextSequence(), args);
		System.exit(exitCode);  
		}
}
