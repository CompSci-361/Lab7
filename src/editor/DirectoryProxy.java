package editor;

import server.MainDictionary;
import transport.DirectoryTransport;
import transport.Employee;
import transport.IDictionary;
import transport.IDirectoryTransportMessageReceiver;
import transport.Message;

public class DirectoryProxy implements IDictionary {
	private class MessageHandler implements IDirectoryTransportMessageReceiver {

		@Override
		public void onMessageReceived(Message msg) {
			// TODO Auto-generated method stub
			switch(msg.messageName.toLowerCase()) {
			case "moo":
				//DirectoryProxy.this.hashCode();
				break;
			}
		}
		
	}
	
	private DirectoryTransport messageTransport;
	public DirectoryProxy(DirectoryTransport transport) {
		messageTransport = transport;
		messageTransport.registerHandlerAsClient(new MessageHandler());
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
