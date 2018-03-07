package server;

import java.util.ArrayList;

import transport.DirectoryTransport;
import transport.DirectoryTransportMessageReceiver;
import transport.Employee;
import transport.IDictionary;
import transport.IDirectoryTransportMessageReceiver;
import transport.Message;

public class MainDirectory implements IDictionary {
	
	ArrayList<Employee> directory;

	private class MessageHandler extends DirectoryTransportMessageReceiver {

		@Override
		public void onMessageReceived(Message msg) {
			switch(msg.messageName.toLowerCase()) {
			case "print":
				MainDirectory.this.print();
				break;
			case "add":
				MainDirectory.this.add((Employee) msg.messageValue);
				break;
			case "clear":
				MainDirectory.this.clear();
				break;
			}
		}
		
	}
	
	private DirectoryTransport messageTransport;
	
	public MainDirectory(DirectoryTransport transport) {
		directory = new ArrayList<Employee>();
		messageTransport = transport;
		messageTransport.registerHandlerAsServer(new MessageHandler());
	}
	
	@Override
	public void print() {
		for (Employee object: directory) {
		    System.out.println(object.toString());
		}
		
	}

	@Override
	public void add(Employee employee) {
		if(employee == null) throw new NullPointerException("Employee to add must not be null");
		directory.add(employee);	
	}

	@Override
	public void clear() {
		directory.clear();
		
	}

}
