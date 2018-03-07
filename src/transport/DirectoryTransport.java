package transport;

public class DirectoryTransport {
	private IDirectoryTransportMessageReceiver serverHandler = null;
	private IDirectoryTransportMessageReceiver clientHandler = null;
	
	public void sendToServer(String messageName, String json) {
		if (serverHandler != null) {
			Message msg = new Message();
			msg.messageName = messageName;
			msg.messageValue = json;
			serverHandler.onMessageReceived(msg);
		}
	}
	public void sendToClient(String messageName, String json) {
		if (clientHandler != null) {
			Message msg = new Message();
			msg.messageName = messageName;
			msg.messageValue = json;
			clientHandler.onMessageReceived(msg);
		}
	}
	
	public void registerHandlerAsServer(IDirectoryTransportMessageReceiver handler) {
		serverHandler = handler;
	}
	
	public void registerHandlerAsClient(IDirectoryTransportMessageReceiver handler) {
		clientHandler = handler;
	}
}
