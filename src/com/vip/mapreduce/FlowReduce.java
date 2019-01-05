package com.vip.mapreduce;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import com.vip.entity.FlowBean;

public class FlowReduce extends Reducer<Text, FlowBean, Text, IntWritable>{
	// ͳ��ÿ���˵���������������������˼�룩
	@Override
	protected void reduce(Text name, Iterable<FlowBean> flowBeans, Reducer<Text, FlowBean, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		int flows = 0;
		for(FlowBean flowBean :flowBeans) {
			flows+= flowBean.getFlow();
		}
		context.write(name, new IntWritable(flows));
	}
}
