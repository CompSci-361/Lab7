package transport;

import java.lang.reflect.Type;

import com.google.gson.Gson;

public abstract class DirectoryTransportMessageReceiver implements IDirectoryTransportMessageReceiver {

	@Override
	public void onHandleReceived(Message msg) {
		if (msg.messageValue != null) {
			//silently convert from json
			Gson g = new Gson();
			msg.messageValue = g.fromJson((String)msg.messageValue, msg.messageValueType);
		}
	}

	public abstract void onMessageReceived(Message msg);
}
