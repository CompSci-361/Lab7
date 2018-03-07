package server;

import transport.DirectoryTransport;
import transport.Employee;
import transport.IDictionary;
import transport.IDirectoryTransportMessageReceiver;
import transport.Message;

public class MainDirectory implements IDictionary {

	private class MessageHandler implements IDirectoryTransportMessageReceiver {

		@Override
		public void onMessageReceived(Message msg) {
			// TODO Auto-generated method stub
			switch(msg.messageName.toLowerCase()) {
			case "print":
				MainDirectory.this.print();
				break;
			}
		}
		
	}
	
	private DirectoryTransport messageTransport;
	public MainDirectory(DirectoryTransport transport) {
		messageTransport = transport;
		messageTransport.registerHandlerAsServer(new MessageHandler());
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
