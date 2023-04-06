import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Main {
    public static void main(String[] args) {
        JFrame frame=new JFrame("NetPing");
        final JTextField addressText=new JTextField();
        addressText.setBounds(50,50, 200,30);
        addressText.setUI(new JTextFieldPlaceholder("Enter your IP address", Color.gray));

        final JTextField messageText=new JTextField();
        messageText.setBounds(50,100, 200,30);
        messageText.setUI(new JTextFieldPlaceholder("Enter your message", Color.gray));

        JButton button=new JButton("Send ICMP packet");
        button.setBounds(50,150,200,30);
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String ipAddress = addressText.getText();
                String message = messageText.getText();
                if(ipAddress.trim().length()>1){
                    PacketSender ps = new PacketSender();
                    String result = ps.checkIpAddress(ipAddress, message);
                    JOptionPane.showMessageDialog(frame, result);
                }else {
                    JOptionPane.showMessageDialog(frame, "You need to provide ip address");
                }
            }
        });
        frame.add(button);
        frame.add(addressText);
        frame.add(messageText);
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}