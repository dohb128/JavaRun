
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class JavaRun extends javax.swing.JFrame {

    public JavaRun() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        startBtn = new javax.swing.JButton();
        lblTitleBackgroundImage = new javax.swing.JLabel();
        gamePanel = new javax.swing.JPanel();
        pauseBtn = new javax.swing.JButton();
        restartBtn = new javax.swing.JButton();
        lifeBar = new javax.swing.JProgressBar();
        lblBackgroundImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Java Run");

        mainPanel.setPreferredSize(new java.awt.Dimension(700, 400));
        mainPanel.setLayout(null);

        startBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/playButton.png"))); // NOI18N
        startBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        startBtn.setBorderPainted(false);
        startBtn.setContentAreaFilled(false);
        startBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startBtnActionPerformed(evt);
            }
        });
        mainPanel.add(startBtn);
        startBtn.setBounds(210, 180, 277, 130);

        lblTitleBackgroundImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background_Title.png"))); // NOI18N
        mainPanel.add(lblTitleBackgroundImage);
        lblTitleBackgroundImage.setBounds(0, 0, 700, 400);

        gamePanel.setPreferredSize(new java.awt.Dimension(700, 400));
        gamePanel.setLayout(null);

        pauseBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pauseButton.png"))); // NOI18N
        gamePanel.add(pauseBtn);
        pauseBtn.setBounds(640, 10, 50, 50);

        restartBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/restartButton.png"))); // NOI18N
        gamePanel.add(restartBtn);
        restartBtn.setBounds(640, 60, 50, 50);

        lifeBar.setFont(new java.awt.Font("맑은 고딕", 0, 12)); // NOI18N
        lifeBar.setForeground(new java.awt.Color(255, 102, 102));
        lifeBar.setMaximum(100000);
        lifeBar.setToolTipText("");
        lifeBar.setValue(100000);
        lifeBar.setStringPainted(true);
        gamePanel.add(lifeBar);
        lifeBar.setBounds(50, 20, 540, 30);

        lblBackgroundImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background.png"))); // NOI18N
        gamePanel.add(lblBackgroundImage);
        lblBackgroundImage.setBounds(0, 0, 700, 400);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(gamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(gamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startBtnActionPerformed
        mainPanel.setVisible(false);
        gamePanel.setVisible(true);

        Thread lifeBarThread = new LifeBarThread(lifeBar);
        lifeBarThread.start();

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                updateLifeBar();
            }
        });
    }//GEN-LAST:event_startBtnActionPerformed

    public class LifeBarThread extends Thread {

        final static int DELAY = 5000;       // Thread delay 5 seconds
        JProgressBar lifeBar;

        // Constructor
        public LifeBarThread(JProgressBar lifeBar) {
            this.lifeBar = lifeBar;
            lifeBar.setStringPainted(true);
        }

        @Override
        public void run() {
            int minValue = lifeBar.getMinimum();
            int maxValue = lifeBar.getMaximum();

            for (int idx = maxValue; idx >= 0; idx--) { // Decreasing the value from maxValue to 0
                try {
                    Thread.sleep(DELAY);
                    lifeBar.setValue(idx); // Set the progress bar value to the current index
                } catch (InterruptedException ignoredException) {

                }
            }
        }
    }

    private void updateLifeBar() {
        int minValue = lifeBar.getMinimum();
        int maxValue = lifeBar.getMaximum();

        for (int idx = maxValue; idx >= 0; idx--) {
            try {
                Thread.sleep(LifeBarThread.DELAY);
                lifeBar.setValue(idx);
            } catch (InterruptedException ignoredException) {
            }
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JavaRun().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel gamePanel;
    private javax.swing.JLabel lblBackgroundImage;
    private javax.swing.JLabel lblTitleBackgroundImage;
    private javax.swing.JProgressBar lifeBar;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton pauseBtn;
    private javax.swing.JButton restartBtn;
    private javax.swing.JButton startBtn;
    // End of variables declaration//GEN-END:variables
}
