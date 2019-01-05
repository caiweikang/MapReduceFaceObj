package com.vip.entity;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

public class FlowBean implements Writable{
	// 序列化必须实现Writable接口，类似于java中的serializable接口
	private String phone;
	private String addr;
	private String name;
	private int flow;
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getFlow() {
		return flow;
	}
	public void setFlow(int flow) {
		this.flow = flow;
	}
	// 序列化
	@Override
	public void write(DataOutput out) throws IOException {
		out.writeUTF(phone);
		out.writeUTF(addr);
		out.writeUTF(name);
		out.writeInt(flow);
		
	}
	// 反序列化
	@Override
	public void readFields(DataInput in) throws IOException {
		this.phone = in.readUTF();
		this.addr = in.readUTF();
		this.name = in.readUTF();
		this.flow = in.readInt();
	}
	
	
}
