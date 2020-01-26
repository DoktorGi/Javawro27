package pl.sda.rafal.zientara.tdd.swing.ex3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LoginWindow {
    private JTextField passwordInput;
    private JButton loginButton;
    private LoginListener listener;
    private JFrame frame;

    public LoginWindow() {
        frame = new JFrame("Podaj Hasło");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(300, 350);
        passwordInput = new JPasswordField("password?");
        passwordInput.setBounds(50, 50, 200, 100);
        passwordInput.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {

                if (keyEvent.getKeyChar()==10) {
                    listener.onLoginClicked(getText());
                }
            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {

            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {

            }
        });
        frame.add(passwordInput);
        loginButton = new JButton("Login");
        loginButton.setBounds(50, 200, 200, 100);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.onLoginClicked(passwordInput.getText());
            }
        });
        frame.add(loginButton);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void setListener(LoginListener listener) {
        this.listener = listener;
    }

    public String getText() {
        return passwordInput.getText();
    }

    public JFrame getFrame() {
        return frame;
    }

    public interface LoginListener {
        void onLoginClicked(String password);
    }
    public void hide() {
        frame.setVisible(false);
    }
}