package com.vip.entity;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 * �ȷ����ٻ���
 * @author Administrator
 *
 */
public class FlowPartition extends Partitioner<Text, FlowBean>{

	@Override
	public int getPartition(Text name, FlowBean flowBeans, int numPartitions) {
		if(flowBeans.getAddr().equals("sh")) {
			return 0;
		}
		if(flowBeans.getAddr().equals("bj")) {
			return 1;
		}
		else {
			return 2;
		}
	}

}
