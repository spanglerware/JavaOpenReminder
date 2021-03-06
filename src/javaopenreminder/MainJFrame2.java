/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaopenreminder;

import java.awt.Toolkit;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Scott
 */

//TODO: allow edit of current reminders
//TODO: increase font size, view size? change style
//TODO: organize method placement
//TODO: add to Git


public class MainJFrame2 extends javax.swing.JFrame implements ReminderCallbacks {

    private int selectedIndex;
    private List<Reminder> reminders;
    
    /**
     * Creates new form MainJFrame2
     */
    public MainJFrame2() {
        initComponents();
        loadXMLFile();
        initTable();
        setLocationRelativeTo(null);
        setTitle("Open Reminder");
        URL iconURL = getClass().getResource("r_logo.png");
        ImageIcon icon = new ImageIcon(iconURL);
        setIconImage(icon.getImage());
    }

    //set up table for displaying reminder information
    private void initTable() {
        int arraySize = reminders.size();
        for (int i = 0; i < arraySize; i++) {
            ((DefaultTableModel)jTableReminder.getModel()).addRow(new Object[]{
                    reminders.get(i).getName(), 
                    reminders.get(i).getTime(), 
                    reminders.get(i).getRepeat()});
        }
    }

    //timer callback updates countdown timers in table
    @Override
    public void timerCallback(String timerValue, int index) {
        //call table update with new time value
        jTableReminder.getModel().setValueAt(timerValue, index, 1);
        System.out.println("callback updates time value");
    }
    
    //finished callback resets times in table and plays sound
    @Override
    public void finishedCallback(String timerValue, int index) {
        jTableReminder.getModel().setValueAt(timerValue, index, 1);
        System.out.println("callback resets time value");        
        //playAlarm();
        playAlarm();
    }
    
    //edit callback adds new reminder to list and table
    @Override
    public void editSavedCallback(EditJDialog editDialog) {
        System.out.println("returned from new button click");
        String name = editDialog.getName();
        String frequency = editDialog.getTime();
        boolean repeating = editDialog.getRepeat();
        int index = reminders.size();
        reminders.add(new Reminder(name, frequency, repeating, index, this));
        ((DefaultTableModel)jTableReminder.getModel())
                .addRow(new Object[]{name, reminders.get(index).getTime(), repeating});                
    }
    
    //plays alarm sound when reminder triggers
    public void playAlarm() {
        try {
            File file = new File("Adagio2.wav").getAbsoluteFile();
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTableReminder = new javax.swing.JTable();
        jButtonStart = new javax.swing.JButton();
        jButtonStop = new javax.swing.JButton();
        jButtonNew = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableReminder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Frequency", "Repeating"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableReminder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableReminderMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableReminder);

        jButtonStart.setText("Start");
        jButtonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStartActionPerformed(evt);
            }
        });

        jButtonStop.setText("Stop");
        jButtonStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStopActionPerformed(evt);
            }
        });

        jButtonNew.setText("New");
        jButtonNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewActionPerformed(evt);
            }
        });

        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jButtonSave.setText("Save");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonDelete))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                .addComponent(jButtonStart)
                                .addComponent(jButtonStop)
                                .addComponent(jButtonNew))
                            .addComponent(jButtonSave))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonStart)
                        .addGap(31, 31, 31)
                        .addComponent(jButtonStop)
                        .addGap(30, 30, 30)
                        .addComponent(jButtonNew)
                        .addGap(35, 35, 35)
                        .addComponent(jButtonDelete)
                        .addGap(34, 34, 34)
                        .addComponent(jButtonSave))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStartActionPerformed
        goStart();
    }//GEN-LAST:event_jButtonStartActionPerformed

    private void jButtonStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStopActionPerformed
        goStop();
    }//GEN-LAST:event_jButtonStopActionPerformed

    private void jButtonNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewActionPerformed
        goNew();
    }//GEN-LAST:event_jButtonNewActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        goDelete();
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        goSave();
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jTableReminderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableReminderMouseClicked
        goSelect();
    }//GEN-LAST:event_jTableReminderMouseClicked

    //starts selected reminder
    private void goStart() {
        int index = jTableReminder.getSelectedRow();
        selectedIndex = index;
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Please select an entry");
            return;
        }        
        reminders.get(index).startTimer();        
    }
    
    //stops selected reminder
    private void goStop() {
        if (reminders.get(selectedIndex) != null) {
            reminders.get(selectedIndex).stopTimer();
            jTableReminder.getModel().setValueAt(
                    reminders.get(selectedIndex).getTime(), selectedIndex, 1);
        }        
    }
    
    //launches edit dialog
    private void goNew() {
        EditJDialog editDialog = new EditJDialog(this, true, this);
    }
    
    //deletes selected reminder from list and table and re-indexes list
    private void goDelete() {
        //remove from list
        reminders.remove(selectedIndex);
        //remove from table, refresh table
        ((DefaultTableModel)jTableReminder.getModel())
                .removeRow(selectedIndex);
        //reindex list
        int size = reminders.size();
        if (selectedIndex < (size - 1)) {
            for (int i = selectedIndex; i < size; i++) {
                reminders.get(i).setIndex(i);
            }
        }
    }
    
    //saves data to xml file
    private void goSave() {
        writeToXMLFile();        
    }
    
    //sets selected index value in class variable
    private void goSelect() {
        selectedIndex = jTableReminder.getSelectedRow();
    }
    
    //optional alarm for reminders plays beeps instead of audio file
    private void playBeeps() {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            int counter = 3;
            public void run () {
                Toolkit.getDefaultToolkit().beep();
                if (counter-- <= 0) {
                    timer.cancel();
                }
            }
        }, 0, 200);
    }
    
    //loads data from xml file
    private void loadXMLFile() {
        try {	
            File inputFile = new File("reminderData.txt");
            DocumentBuilderFactory dbFactory 
                = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("reminder");
            int arraySize = nList.getLength();
            String name;
            String freq;
            boolean repeat;
            Reminder rem;
            
            reminders = new ArrayList<Reminder>();

            for (int i = 0; i < arraySize; i++) {
                Node nNode = nList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    name = eElement
                        .getElementsByTagName("name")
                        .item(0)
                        .getTextContent();
                    freq = eElement
                        .getElementsByTagName("frequency")
                        .item(0)
                        .getTextContent();
                    repeat = Boolean.parseBoolean(eElement
                        .getElementsByTagName("repeat")
                        .item(0)
                        .getTextContent());
                    rem = new Reminder(name, freq, repeat, i, this);
                    reminders.add(rem);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }
    
    //updates data in xml file
    private void writeToXMLFile() {
        int arrSize = reminders.size();
        String name;
        String freq;
        String repeat;

        try {
            File inputFile = new File("reminderData.txt"); 	    	
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(inputFile);
            Element app = doc.getDocumentElement();
            
            NodeList reminderList = doc.getElementsByTagName("reminder");
            int listSize = reminderList.getLength();
    //delete entries if needed
            if (listSize > arrSize) {
                Node removeNode;
                for (int i = (listSize - 1); i > (arrSize - 1); i--) {
                    removeNode = reminderList.item(i);
                    app.removeChild(removeNode);
                    //app.removeChild(reminderList.item(i));
                }
            }
            
    // loop the reminder child node and update values as needed
            for (int i = 0; i < listSize; i++) {
                NodeList list = reminderList.item(i).getChildNodes();
                for (int k = 0; k < list.getLength(); k++) {
                    Node node = list.item(k);
                    name = reminders.get(i).getName();
                    if ("name".equals(node.getNodeName())){
                        if(!name.equals(node.getTextContent())){
                            node.setTextContent(name);
                        }
                    }
                    freq = reminders.get(i).getFreq();
                    if ("frequency".equals(node.getNodeName())) {
                        if (!freq.equals(node.getTextContent())) {
                            node.setTextContent(freq);
                        }
                    }
                    repeat = String.valueOf(reminders.get(i).getRepeat());
                    if ("repeat".equals(node.getNodeName())) {
                        if (!repeat.equals(node.getTextContent())) {
                            node.setTextContent(repeat);
                        }
                    }
                }
            }
            
    //add new entries
            if (arrSize > listSize) {
                for (int i = listSize; i < arrSize; i++) {
                    Element newEntry = doc.createElement("reminder");

                    Element eName = doc.createElement("name");
                    name = reminders.get(i).getName();
                    eName.appendChild(doc.createTextNode(name));
                    newEntry.appendChild(eName);

                    Element eFreq = doc.createElement("frequency");
                    freq = reminders.get(i).getFreq();
                    eFreq.appendChild(doc.createTextNode(freq));
                    newEntry.appendChild(eFreq);

                    Element eRepeat = doc.createElement("repeat");
                    repeat = String.valueOf(reminders.get(i).getRepeat());
                    eRepeat.appendChild(doc.createTextNode(
                            String.valueOf(repeat)));
                    newEntry.appendChild(eRepeat);
                    
                    app.appendChild(newEntry);
                }
            }
            
    // update the xml file
            TransformerFactory transformerFactory = 
                TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            System.out.println("Updated xml file");
            StreamResult result = new StreamResult(inputFile);
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonNew;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JButton jButtonStart;
    private javax.swing.JButton jButtonStop;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableReminder;
    // End of variables declaration//GEN-END:variables
}
