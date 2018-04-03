package interfaceCar;

import File.CarFile;
import domain.Car;
import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author karol
 */
public class RegisterCar extends javax.swing.JFrame {

    public static CarFile carFile;
    public static Car car;

    /**
     * Creates new form InterfaceCar
     * @throws java.io.IOException
     * 
     * 
     * 
     */
    public RegisterCar() throws IOException {

        initComponents();

    }

    public void unLock(){
    
    
    }
    

///Estos metodos, nos permiten saber, si el usuario deje un campo de texto vacio, o ingresa un caracter invalido, en caso de ser int el campo de texto
    //si fuese invalido lo ingresado, le enviamos un sms de advertencia
    public String readName() {

        String name = "";
        if (name.equals(fieldName.getText())) {
            JOptionPane.showMessageDialog(null, "Incorrect data");
            return null;
        } else {
            return name;
        }
    }

    public int readYear() {
        String year = "";
        if (year.equals(fieldYear.getText())) {
            JOptionPane.showMessageDialog(null, "Incorrect data");
            return -666;
        } else {
            return 0;
        }
    }

    public float readMileage() {
        String mileage = "";
    
        if (mileage.equals(fieldMileage.getText())) {
            JOptionPane.showMessageDialog(null, "Incorrect data");
            return -666;
        } else {
            //v=Float.parseFloat(mileage);
            return 0;
        }
    }

    public int readSeries() {
      
        String serie = "";
        int x;
        
        if (serie.equals(fieldSeries.getText())) {
            JOptionPane.showMessageDialog(null, "Incorrect data");
            return -666;
        } else {
    
            return 0;
        }
    }

    public void enterTo() throws IOException {
        try {
          //  File fileCar = new File("./Car.dat");
            String name = fieldName.getText();
            int year = Integer.parseInt(fieldYear.getText());
            float mileage = Float.parseFloat(fieldMileage.getText());
            boolean american = Boolean.parseBoolean(fieldAmerican.getSelectedItem().toString());
            int series = Integer.parseInt(fieldSeries.getText());
            Car c1 = new Car(name, year, mileage, american, series);
     
  
              if ((carFile.repeat(series) == true)) {
                carFile.repeat(series);
               
              }else if(carFile.repeat(series)!=true){
           
            carFile.addEndRecord(c1);
            textArea.setText(String.valueOf(carFile.getAllStudents()));
            JOptionPane.showMessageDialog(null, "Registered car:" + "\n" + c1.toString());
            
              }
        } catch (HeadlessException | IOException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Incorrect date");

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fieldName = new javax.swing.JTextField();
        fieldYear = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        fieldMileage = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        fieldSeries = new javax.swing.JTextField();
        reg = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        fieldAmerican = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Lucida Handwriting", 1, 14)); // NOI18N
        jLabel1.setText("Name:");

        jLabel2.setFont(new java.awt.Font("Lucida Handwriting", 1, 14)); // NOI18N
        jLabel2.setText("Year:");

        jLabel3.setFont(new java.awt.Font("Lucida Handwriting", 1, 14)); // NOI18N
        jLabel3.setText("Maleage:");

        jLabel4.setFont(new java.awt.Font("Lucida Handwriting", 1, 14)); // NOI18N
        jLabel4.setText("American:");

        jLabel5.setFont(new java.awt.Font("Lucida Handwriting", 1, 14)); // NOI18N
        jLabel5.setText("Series:");

        fieldSeries.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldSeriesActionPerformed(evt);
            }
        });

        reg.setFont(new java.awt.Font("Lucida Handwriting", 1, 12)); // NOI18N
        reg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/automovil (2).png"))); // NOI18N
        reg.setText("To register");
        reg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regActionPerformed(evt);
            }
        });

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane2.setViewportView(textArea);

        jButton3.setFont(new java.awt.Font("Lucida Handwriting", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit_clear.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Lucida Handwriting", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrow_undo.png"))); // NOI18N
        jButton1.setText("Exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        fieldAmerican.setFont(new java.awt.Font("Lucida Handwriting", 1, 10)); // NOI18N
        fieldAmerican.setForeground(new java.awt.Color(255, 102, 102));
        fieldAmerican.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "True", "False" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fieldYear, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                            .addComponent(fieldName))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(fieldAmerican, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(fieldMileage, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldSeries, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 35, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(244, 244, 244)
                .addComponent(reg)
                .addGap(0, 312, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(fieldMileage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(fieldSeries, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(fieldYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(fieldAmerican, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton3))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(reg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void regActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regActionPerformed
        File fileCar = new File("./Car.dat");
        int nameLen = fieldName.getText().length();//obtenemos el tamano del nombre, que el usuario dijite en el campo de texto
        try {
            carFile = new CarFile(fileCar);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Incorrect data");
        }

        try {

            if ((nameLen <= 20 && nameLen > 0) && (readYear() != -666)) {//Si el tamano de el campo de nombre es menoor a 20, esta permitido 
                //que guarde el registro  escriba
                enterTo();

            } else if (nameLen > 20) {//Si el tamano del campo de texto, de nombre, es mayor a 20 caracteres, no permitimos que escriva
                JOptionPane.showMessageDialog(null, "The name is very extensive. Please enter another name");

            } else if (("".equals(readName()))) {//Si el usuario, guarda el registro con el campo de texto, nombre, vacio, no se le permite
                readName();

            } else if ((readYear() == -666)) {//Si el usuario, guarda el registro con el campo de texto, ano, con un caracter invalido, no se le permite

                readYear();

            } else if ((readMileage() == -666)){//Si el usuario, guarda el registro con el campo de texto, mileage, con un caracter invalido, no se le perm

                readMileage();

            } else if (readSeries() == -666) {////Si el usuario, guarda el registro con el campo de texto, series, con un caracter invalido, no se le perm
                readSeries();
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect data");
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Incorrect data");

        }


    }//GEN-LAST:event_regActionPerformed

    private void fieldSeriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldSeriesActionPerformed
    
    }//GEN-LAST:event_fieldSeriesActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            fieldName.setText("");
            fieldYear.setText("");
            fieldMileage.setText("");
            fieldSeries.setText("");
        } catch (Exception e) {
           
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        InterfaceMain  returnn= new InterfaceMain();
//         returnn.setVisible(true);
//         this.setVisible(false);   
this.dispose();

// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

  

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
            java.util.logging.Logger.getLogger(RegisterCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new RegisterCar().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(RegisterCar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> fieldAmerican;
    public javax.swing.JTextField fieldMileage;
    public javax.swing.JTextField fieldName;
    public javax.swing.JTextField fieldSeries;
    public javax.swing.JTextField fieldYear;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton reg;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
}
