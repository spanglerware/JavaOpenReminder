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

//callbacks used to return operation to MainJFrame2 for UI updates
public interface ReminderCallbacks {
    void timerCallback(String timeValue, int index);
    
    void finishedCallback(String timeValue, int index);
    
    void editSavedCallback(EditJDialog editDialog);
}
