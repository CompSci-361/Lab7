package editor;

import com.google.gson.Gson;

import transport.DirectoryTransport;
import transport.Employee;
import transport.IDictionary;

public class DirectoryProxy implements IDictionary {

	private DirectoryTransport messageTransport;
	public DirectoryProxy(DirectoryTransport transport) {
		messageTransport = transport;
	}
	
	@Override
	public void print() {
		messageTransport.sendToServer("print", null);
	}

	@Override
	public void add(Employee employee) {
		Gson g = new Gson();
		String out = g.toJson(employee);
		messageTransport.sendToServer("add", out);
	}

	@Override
	public void clear() {
		messageTransport.sendToServer("clear", null);
	}

}
