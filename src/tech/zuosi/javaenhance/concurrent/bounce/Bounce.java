package tech.zuosi.javaenhance.concurrent.bounce;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by iwar on 2017/7/2.
 */
public class Bounce {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new BounceFrame();
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class BallRunnable implements Runnable {
    private Ball ball;
    private BallComponent comp;
    public static final int STEPS = 1000;
    public static final int DELAY = 3;

    public BallRunnable(Ball aBall, BallComponent ballComponent) {
        ball = aBall;
        comp = ballComponent;
    }

    public void run() {
        try {
            for (int i = 1; i <= STEPS; i++) {
                ball.move(comp.getBounds());
                comp.repaint();
                Thread.sleep(DELAY);
            }
        } catch (InterruptedException e) {}
    }
}

class BounceFrame extends JFrame {
    private BallComponent comp;

    public BounceFrame() {
        setTitle("Bounce");

        comp = new BallComponent();
        add(comp, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        addButton(buttonPanel, "Start", e -> addBall());
        addButton(buttonPanel, "Close", e -> System.exit(0));
        add(buttonPanel, BorderLayout.SOUTH);
        pack();
    }

    public void addButton(Container c, String title, ActionListener listener) {
        JButton button = new JButton(title);
        c.add(button);
        button.addActionListener(listener);
    }

    public void addBall() {
        Ball ball = new Ball();
        comp.add(ball);
        Runnable r = new BallRunnable(ball, comp);
        Thread t = new Thread(r);
        t.start();
    }
}
