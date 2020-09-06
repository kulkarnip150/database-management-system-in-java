package db.system;

import static db.system.DataBaseFunctions.getTableNames;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Prasad
 */
public class UpdateRow extends javax.swing.JFrame {

    /**
     * Creates new form UpdateRow
     */
    JLabel jLabel1;
    JComboBox jComboBox1;
    JTable jTable1;
    JButton submit , cancel;
    int size;
    DefaultTableModel model;
    String[] columnNames ={};
    String[] values = {};
    
    public UpdateRow() {
        initComponents();
        jLabel1 = new JLabel("Select Table Name");
        submit = new JButton("Update");
        cancel = new JButton("Cancel");  
        jComboBox1 = new JComboBox(getTableNames());
        model = new DefaultTableModel();
        jTable1 = new JTable(model);
        jTable1.setRowHeight(30);
        
        jTable1.setPreferredScrollableViewportSize(new Dimension(500,100));
        jTable1.setFillsViewportHeight(true);
        
        setLayout(null);
        setTitle("Update Rows");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JScrollPane sp = new JScrollPane();
        sp.setViewportView(jTable1);
        jComboBox1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox jComboBox1 = (JComboBox) e.getSource();
                if(!"Select".equals(jComboBox1.getSelectedItem().toString())){
                    model.setRowCount(0);
                    model.setColumnCount(0);
                    size = DataBaseFunctions.getColumnNames(jComboBox1.getSelectedItem().toString()).length;
                    columnNames = new String[size];
                    values = new String[size];
                    columnNames = DataBaseFunctions.getColumnNames(jComboBox1.getSelectedItem().toString());
                    for (String columnName : columnNames) {
                        model.addColumn(columnName);
                    }
                    DataBaseFunctions.addRows(jComboBox1.getSelectedItem().toString(),columnNames,size,model);
                } else {
                }
            }
        });
        
        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt){
                if(jTable1.getRowCount()>0){
                    int selectedRowIndex = jTable1.getSelectedRow();
                    for(int i=0;i<size;i++){
                        values[i] = model.getValueAt(selectedRowIndex, i).toString();
                    }
                }
                //deleteRow(jComboBox1.getSelectedItem().toString(),columnNames,values);
            }
        });   
        submit.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                if(e.getClickCount() == 1){
                    if(jComboBox1.getSelectedItem()!="Select"){
                        updateRowData uRD;
                        uRD = new updateRowData(jComboBox1.getSelectedItem().toString(),columnNames,values);
                        uRD.setVisible(true);
                        model.setRowCount(0);
                        model.setColumnCount(0);
                        jComboBox1.setSelectedIndex(0);
                    }
                }
            }
        });
        cancel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                if(e.getClickCount() == 1){
                    model.setRowCount(0);
                    model.setColumnCount(0);
                    jComboBox1.setSelectedIndex(0);
                    dispose();
                }
            }
        });
        
        jLabel1.setBounds(30,10,120,40);
        jComboBox1.setBounds(150, 10, 200, 40);
        sp.setBounds(30,70,520,400);
        submit.setBounds(130,480,150,40);
        cancel.setBounds(290,480,150,40);
        
        add(jLabel1);
        add(jComboBox1);
        add(sp);
        add(submit);
        add(cancel);
     
        setPreferredSize(new Dimension(600,600));
        pack();
        //setSize(1400,800);
        setLocationRelativeTo(null);
    }   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UpdateRow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateRow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateRow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateRow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UpdateRow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
