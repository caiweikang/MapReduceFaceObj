package com.vip.mapreduce;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import com.vip.entity.FlowBean;
import com.vip.entity.FlowPartition;

public class FlowDriver {

	public static void main(String[] args) throws Exception {
		Configuration configuration = new Configuration();
		Job job = Job.getInstance(configuration);
		
		// 1.����Job������������
		job.setJarByClass(FlowDriver.class);
		// ����Mapper������е���
		job.setMapperClass(FlowMapper.class);
		// ����Reducer���������
		job.setReducerClass(FlowReduce.class);
		
		// 2.����Mapper������key������
		job.setMapOutputKeyClass(Text.class);
		// ����Mapper������value����
		job.setMapOutputValueClass(FlowBean.class);
		// ����Reducer������key������
		job.setOutputKeyClass(Text.class);
		// ����Reducer������value����
		job.setOutputValueClass(IntWritable.class);
		
		// ����Reducer�����Լ��Զ����������
		job.setNumReduceTasks(3);
		job.setPartitionerClass(FlowPartition.class);
		
		// 3.����job�������ļ����ڵ�HDFS·��
		FileInputFormat.setInputPaths(job, new Path("hdfs://192.168.154.129:9000/flowCount/flow.txt"));
		// ���ý���ļ�·����Ҳ�����Ǵ洢HDFS��
		FileOutputFormat.setOutputPath(job, new Path("hdfs://192.168.154.129:9000/flowCount/result"));
		
		// 4.�ύ����
		job.waitForCompletion(true);

	}

}
