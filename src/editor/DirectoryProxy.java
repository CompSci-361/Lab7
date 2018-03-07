package editor;

import com.google.gson.Gson;
import server.MainDirectory;
import transport.DirectoryTransport;
import transport.DirectoryTransportMessageReceiver;
import transport.Employee;
import transport.IDictionary;
import transport.IDirectoryTransportMessageReceiver;
import transport.Message;

public class DirectoryProxy implements IDictionary {
	private class MessageHandler extends DirectoryTransportMessageReceiver {

		@Override
		public void onMessageReceived(Message msg) {
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
		messageTransport.sendToServer("print", null, null);
	}

	@Override
	public void add(Employee employee) {
		Gson g = new Gson();
		String out = g.toJson(employee);
		messageTransport.sendToServer("add", out, Employee.class);
	}

	@Override
	public void clear() {
		messageTransport.sendToServer("clear", null, null);
	}

}
