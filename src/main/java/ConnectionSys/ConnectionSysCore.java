package ConnectionSys;

import FrameSys.FrameSysCore;

import java.io.IOException;
import java.net.*;

public class ConnectionSysCore {
    
}


class EchoClient {
    private DatagramSocket socket;
    private InetAddress address;

    private byte[] buf;

    public EchoClient() throws SocketException, UnknownHostException {
        socket = new DatagramSocket();
        address = InetAddress.getByName(FrameSysCore.getServerIp());
        //192.168.0.102
    }

    public String sendEcho(String msg) throws IOException {
        buf = msg.getBytes();

        DatagramPacket packet;

        try {
            packet
                    = new DatagramPacket(buf, msg.length(), address, 4020);
            socket.send(packet);
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.exit(-9);
        }

        String received = "Server closed";
        if (!msg.equals("end")) {
            packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);
            received = new String(
                    packet.getData(), 0, packet.getLength());
        }
        return received;
    }

    public void close() {
        socket.close();
    }
}