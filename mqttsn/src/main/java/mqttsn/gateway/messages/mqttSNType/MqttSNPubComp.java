package mqttsn.gateway.messages.mqttSNType;

import mqttsn.gateway.messages.MqttSNMessage;

/**
 * Created by jungao on 2017/10/19.
 */
public class MqttSNPubComp extends MqttSNMessage {

    //MqttSN PUBCOMP fields
    private int msgId;

    public MqttSNPubComp() {
        msgType = PUBCOMP;
    }

    public MqttSNPubComp(byte[] data) {
        msgType = PUBCOMP;
        msgId = ((data[2] & 0xFF) << 8) + (data[3] & 0xFF);
    }

    @Override
    public byte[] toBytes() {
        int length = 4;
        byte[] data = new byte[length];
        data[0] = (byte)length;
        data[1] = (byte)msgType;
        data[2] = (byte)((msgId >> 8) & 0xFF);
        data[3] = (byte)(msgId & 0xFF);
        return data;

    }

    public int getMsgId() {
        return msgId;
    }

    public void setMsgId(int msgId) {
        this.msgId = msgId;
    }
}
