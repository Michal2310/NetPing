import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class PacketSender {
    public String checkIpAddress(String ipAddress, String message) {
        try {
            InetAddress address = InetAddress.getByName(ipAddress);
            boolean reachable = address.isReachable(5000);
            byte[] data = message.getBytes();
            DatagramPacket packet = new DatagramPacket(data, data.length, address, 80);
            DatagramSocket socket = new DatagramSocket();
            socket.send(packet);
            if (reachable) {
                return "Sending an ICMP packet was successful";
            } else {
                return "IP address is unreachable";
            }
        } catch (IOException e) {
            return "Error while sending ICMP packet: " + e.getMessage();
        }
    }
}