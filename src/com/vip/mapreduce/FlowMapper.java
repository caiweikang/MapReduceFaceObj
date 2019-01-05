package com.vip.mapreduce;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import com.vip.entity.FlowBean;

public class FlowMapper extends Mapper<LongWritable, Text, Text, FlowBean>{
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, FlowBean>.Context context)
			throws IOException, InterruptedException {
		FlowBean flowBean = new FlowBean();
		String[] values = value.toString().split(" ");
		flowBean.setPhone(values[0]);
		flowBean.setAddr(values[1]);
		flowBean.setName(values[2]);
		flowBean.setFlow(Integer.parseInt(values[3]));
		context.write(new Text(values[2]), flowBean);
	}
}
