package server;

import transport.DirectoryTransport;
import transport.Employee;
import transport.IDictionary;

public class MainDictionary implements IDictionary {

	private DirectoryTransport messageTransport;
	public MainDictionary(DirectoryTransport transport) {
		messageTransport = transport;
	}
	
	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

}
