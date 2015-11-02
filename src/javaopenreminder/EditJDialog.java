/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaopenreminder;

/**
 *
 * @author Scott
 */
//edit dialog used for adding new reminders
public class EditJDialog extends javax.swing.JDialog {

    private long reminderTime = 0;
    private String reminderName;
    private boolean repeating = false;
    private ReminderCallbacks callbacks;
    
    /**
     * Creates new form EditJDialog
     */
    public EditJDialog(java.awt.Frame parent, boolean modal, 
            ReminderCallbacks callbacks) {
        super(parent, modal);
        initComponents();
        this.callbacks = callbacks;
        setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldName = new javax.swing.JTextField();
        jLabelName = new javax.swing.JLabel();
        jLabelTime = new javax.swing.JLabel();
        jButtonDone = new javax.swing.JButton();
        jTextFieldHours = new javax.swing.JTextField();
        jTextFieldMinutes = new javax.swing.JTextField();
        jTextFieldSeconds = new javax.swing.JTextField();
        jCheckBoxRepeat = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit Reminder");

        jTextFieldName.setToolTipText("Reminder Name");

        jLabelName.setText("Name");

        jLabelTime.setText("Time (Hours : Minutes : Seconds)");
        jLabelTime.setToolTipText("Reminder Time");

        jButtonDone.setText("Add");
        jButtonDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDoneActionPerformed(evt);
            }
        });

        jTextFieldHours.setText("0");
        jTextFieldHours.setToolTipText("Reminder Hours");
        jTextFieldHours.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldHoursFocusGained(evt);
            }
        });

        jTextFieldMinutes.setText("0");
        jTextFieldMinutes.setToolTipText("Reminder Minutes");
        jTextFieldMinutes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldMinutesFocusGained(evt);
            }
        });

        jTextFieldSeconds.setText("0");
        jTextFieldSeconds.setToolTipText("Reminder Seconds");
        jTextFieldSeconds.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldSecondsFocusGained(evt);
            }
        });

        jCheckBoxRepeat.setText("Repeat");
        jCheckBoxRepeat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxRepeatActionPerformed(evt);
            }
        });

        jLabel1.setText(":");

        jLabel2.setText(":");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelTime)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonDone)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldHours, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldMinutes, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldSeconds, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelName)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jCheckBoxRepeat, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(78, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabelName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelTime)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldHours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldMinutes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldSeconds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jCheckBoxRepeat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jButtonDone)
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBoxRepeatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxRepeatActionPerformed
        repeating = jCheckBoxRepeat.isSelected();
    }//GEN-LAST:event_jCheckBoxRepeatActionPerformed

    private void jButtonDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDoneActionPerformed
        goDone();
    }//GEN-LAST:event_jButtonDoneActionPerformed

    private void jTextFieldHoursFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldHoursFocusGained
        jTextFieldHours.selectAll();
    }//GEN-LAST:event_jTextFieldHoursFocusGained

    private void jTextFieldMinutesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldMinutesFocusGained
        jTextFieldMinutes.selectAll();
    }//GEN-LAST:event_jTextFieldMinutesFocusGained

    private void jTextFieldSecondsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldSecondsFocusGained
        jTextFieldSeconds.selectAll();
    }//GEN-LAST:event_jTextFieldSecondsFocusGained

    //triggers callback to MainJFrame2 for adding new reminder
    private void goDone() {
        int hours = Integer.parseInt(jTextFieldHours.getText());
        int minutes = Integer.parseInt(jTextFieldMinutes.getText());
        int seconds = Integer.parseInt(jTextFieldSeconds.getText());
        
        reminderTime = (hours * 3600) + (minutes * 60) + seconds;
        reminderName = jTextFieldName.getText();
        this.setVisible(false);
        callbacks.editSavedCallback(this);
    }
    
    public String getName() {
        return reminderName;
    }
    
    public String getTime() {
        return String.valueOf(reminderTime);
    }
    
    public boolean getRepeat() {
        return repeating;
    }
    
    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDone;
    private javax.swing.JCheckBox jCheckBoxRepeat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelTime;
    private javax.swing.JTextField jTextFieldHours;
    private javax.swing.JTextField jTextFieldMinutes;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldSeconds;
    // End of variables declaration//GEN-END:variables
}