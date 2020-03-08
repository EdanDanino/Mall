package misc;

@SuppressWarnings("serial")
public class MsgException extends Exception {
	protected String msg;

	public MsgException(String msg) {
		super(msg);
	}
}
