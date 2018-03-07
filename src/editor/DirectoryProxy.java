package editor;

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
