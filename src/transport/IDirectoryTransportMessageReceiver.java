package transport;

public interface IDirectoryTransportMessageReceiver {
	void onHandleReceived(Message msg);
}