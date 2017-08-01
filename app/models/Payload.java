package models;

/**
 * Payload model POJO class
 *
 */
public class Payload {

	private String payloadName;
    private int payloadId;

    public int getPayloadId() {
		return payloadId;
	}
	public void setPayloadId(int payloadId) {
		this.payloadId = payloadId;
	}
	public String getPayloadName() {
        return payloadName;
    }
    public void setPayloadName(String payloadName) {
        this.payloadName = payloadName;
    }
}
