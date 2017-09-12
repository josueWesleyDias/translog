package br.edu.unifesspa.service;

public class Validate {
	public boolean empty(int value) {
		if(value != 0 || value < 0)
			return false;
		else return true;
	}
	public boolean empty(String value) {
		if(!value.isEmpty())
			return true;
		else return false;
	}
	public boolean empty(float value) {
		if(value != 0 || value < 0)
			return false;
		else return true;
	}
	public boolean empty(double value) {
		if(value != 0 || value < 0)
			return false;
		else return true;
	}
	public boolean empty(long value) {
		if(value != 0 || value < 0)
			return false;
		else return true;
	}
}
