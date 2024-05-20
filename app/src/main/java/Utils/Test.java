package Utils;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;

public class Test extends JFrame {

    public Test() {
        initComponents();
        GlassPanePopup.install(this);
    }

    private void initComponents() {
        JButton jButton1 = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Show Message");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(313, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(305, 305, 305))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(240, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(226, 226, 226))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        Message obj = new Message();
        obj.eventOK(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Click OK");
                GlassPanePopup.closePopupLast();
            }
        });
        GlassPanePopup.showPopup(obj);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Test().setVisible(true);
            }
        });
    }

    public static class Message extends JPanel {

        private Button cmdCancel;
        private Button cmdOK;
        private JLabel jLabel1;
        private JTextPane txt;

        public Message() {
            initComponents();
            setOpaque(false);
            txt.setBackground(new Color(0, 0, 0, 0));
            txt.setSelectionColor(new Color(48, 170, 63, 200));
            txt.setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics grphcs) {
            Graphics2D g2 = (Graphics2D) grphcs.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 15, 15));
            g2.dispose();
            super.paintComponent(grphcs);
        }

        private void initComponents() {
            jLabel1 = new JLabel();
            txt = new JTextPane();
            cmdOK = new Button();
            cmdCancel = new Button();

            setBackground(new Color(255, 255, 255));
            setBorder(javax.swing.BorderFactory.createEmptyBorder(25, 25, 25, 25));

            jLabel1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
            jLabel1.setForeground(new Color(80, 80, 80));
            jLabel1.setText("CONFIRM");

            txt.setEditable(false);
            txt.setForeground(new Color(133, 133, 133));
            txt.setText("        Are you sure you want to proceed?");

            cmdOK.setBackground(new Color(48, 170, 63));
            cmdOK.setForeground(new Color(255, 255, 255));
            cmdOK.setText("OK");

            cmdCancel.setBackground(new Color(233, 233, 233));
            cmdCancel.setText("Cancel");
            cmdCancel.addActionListener(evt -> {
                GlassPanePopup.closePopupLast();
            });

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
            this.setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(107, 107, 107)
                    .addComponent(jLabel1)
                    .addGap(0, 0, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(27, Short.MAX_VALUE)
                    .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(cmdOK, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(txt)
                    .addContainerGap())
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmdOK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(24, Short.MAX_VALUE))
            );
        }

        public void eventOK(ActionListener event) {
            cmdOK.addActionListener(event);
        }

        public static class Button extends JButton {
            public Button() {
                setContentAreaFilled(false);
                setFocusPainted(false);
            }

            @Override
            protected void paintComponent(Graphics g) {
                if (getModel().isArmed()) {
                    g.setColor(getBackground().darker());
                } else {
                    g.setColor(getBackground());
                }
                g.fillRect(0, 0, getWidth(), getHeight());
                super.paintComponent(g);
            }
        }
    }

    public static class GlassPanePopup {
        private static GlassPanePopup instance;
        private JLayeredPane layerPane;

        private GlassPanePopup() {
            init();
        }

        private void init() {
            layerPane = new JLayeredPane();
            layerPane.setLayout(new CardLayout());
        }

        public void addAndShowPopup(Component component) {
            layerPane.add(component, 0);
            component.setVisible(true);
            if (!layerPane.isVisible()) {
                layerPane.setVisible(true);
            }
            layerPane.grabFocus();
        }

        public static void install(JFrame frame) {
            instance = new GlassPanePopup();
            frame.setGlassPane(instance.layerPane);
            instance.layerPane.setVisible(true);
        }

        public static void showPopup(Component component) {
            instance.addAndShowPopup(component);
        }

        public static void closePopupLast() {
            if (instance.layerPane.getComponentCount() > 0) {
                Component last = instance.layerPane.getComponent(instance.layerPane.getComponentCount() - 1);
                instance.layerPane.remove(last);
                instance.layerPane.repaint();
            }
        }
    }
}
