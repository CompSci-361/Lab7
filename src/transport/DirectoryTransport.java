package transport;

import java.lang.reflect.Type;

public class DirectoryTransport {
	private IDirectoryTransportMessageReceiver serverHandler = null;
	private IDirectoryTransportMessageReceiver clientHandler = null;
	
	public void sendToServer(String messageName, String json, Type objectType) {
		if (serverHandler != null) {
			Message msg = new Message();
			msg.messageName = messageName;
			msg.messageValue = json;
			msg.messageValueType = objectType;
			serverHandler.onHandleReceived(msg);
		}
	}
	public void sendToClient(String messageName, String json, Type objectType) {
		if (clientHandler != null) {
			Message msg = new Message();
			msg.messageName = messageName;
			msg.messageValue = json;
			msg.messageValueType = objectType;
			clientHandler.onHandleReceived(msg);
		}
	}
	
	public void registerHandlerAsServer(IDirectoryTransportMessageReceiver handler) {
		serverHandler = handler;
	}
	
	public void registerHandlerAsClient(IDirectoryTransportMessageReceiver handler) {
		clientHandler = handler;
	}
}
