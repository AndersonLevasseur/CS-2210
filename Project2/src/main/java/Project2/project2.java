/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Project2;

import java.awt.Color;
import java.awt.Image;
import numeric.*;
import java.text.NumberFormat;
import javax.swing.ImageIcon;

/**
 *
 * @author Anderson
 */
public class project2 extends javax.swing.JFrame {

    /**
     * Creates new form project2
     */
    public project2() {
        initComponents();
        DrGPicture.setVisible(false);
    }

    private void LovelyDrG() {
        if (DrGPicture.isVisible()) {
            DrGPicture.setVisible(false);
        } else {
            ImageIcon DrG = new ImageIcon("creation_of_java.JPG");
            Image image = DrG.getImage(); // transform it 
            Image newimg = image.getScaledInstance(240, 120, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
            DrG = new ImageIcon(newimg);  // transform it back
            DrGPicture.setIcon(DrG);
            DrGPicture.setVisible(true);
        }
    }

    private void ComputeGCD() {
        NumberFormat myFormat = NumberFormat.getInstance();
        try {
            long num1 = Long.parseLong(GCDNum1TextField.getText());
            long num2 = Long.parseLong(GCDNum2TextField.getText());
            long ans = numeric.GCD.compute(num1, num2);
            GCDResult.setText(myFormat.format(ans));
            GCDResult.setForeground(Color.BLACK);
        } catch (NumberFormatException E) {
            GCDResult.setText("ERROR : Please enter a valid long");
            GCDResult.setForeground(Color.RED);
        }
    }

    private void GCDKeyPress(java.awt.event.KeyEvent evt) {
        switch (evt.getKeyCode()) {
            //Enter Key
            case 10 ->
                ComputeGCD();
            //Escape Key
            case 27 ->
                CloseGCD();
        }
    }

    private void OpenGCD() {
        GCDDialog.setVisible(true);
        GCDDialog.enableInputMethods(true);
        GCDDialog.setEnabled(true);
        GCDDialog.setModal(true);
    }

    private void CloseGCD() {
        GCDDialog.setVisible(false);
        GCDDialog.setModal(false);
        GCDDialog.setEnabled(false);
        GCDDialog.enableInputMethods(false);
    }

    private void ComputeFactorial() {
        long ans;
        //Initiates NumberFormat, used for adding commas to the answer
        NumberFormat myFormat = NumberFormat.getInstance();

        try {
            int num1;
            num1 = Integer.parseInt(FactNum1TextField.getText());
            ans = Factorial.compute(num1);
            FactResult.setText(myFormat.format(ans));
            FactResult.setForeground(Color.BLACK);
        } catch (FactorialException e) {
            FactResult.setText(e.getMessage());
            FactResult.setForeground(Color.RED);
        } catch (NumberFormatException e) {
            FactResult.setText("ERROR : Please enter a valid long");
            FactResult.setForeground(Color.RED);

        }
    }

    private void CompFactKeyPress(java.awt.event.KeyEvent evt) {
        switch (evt.getKeyCode()) {
            //Enter Key
            case 10 ->
                ComputeFactorial();
            //Esc Key
            case 27 ->
                CloseGCD();
        }
    }

    private void OpenFactorial() {
        FactorialDialog.setVisible(true);
        FactorialDialog.enableInputMethods(true);
        FactorialDialog.setEnabled(true);
        GCDDialog.setModal(true);
    }

    private void CloseFactorial() {
        FactorialDialog.setVisible(false);
        FactorialDialog.setModal(false);
        FactorialDialog.setEnabled(false);
        FactorialDialog.enableInputMethods(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GCDDialog = new javax.swing.JDialog();
        GCDNum1TextField = new javax.swing.JTextField();
        GCDTitle = new javax.swing.JLabel();
        GCDNum1Label = new javax.swing.JLabel();
        GCDNum2Label = new javax.swing.JLabel();
        GCDNum2TextField = new javax.swing.JTextField();
        GCDComputeButton = new javax.swing.JButton();
        GCDCloseButton = new javax.swing.JButton();
        GCDResultLabel = new javax.swing.JLabel();
        GCDResult = new javax.swing.JLabel();
        FactorialDialog = new javax.swing.JDialog();
        FactComputeButton = new javax.swing.JButton();
        FactCloseButton = new javax.swing.JButton();
        FactResultLabel = new javax.swing.JLabel();
        FactNum1TextField = new javax.swing.JTextField();
        FactorialTitle = new javax.swing.JLabel();
        FactNum1Label = new javax.swing.JLabel();
        FactResult = new javax.swing.JLabel();
        GCDButton = new javax.swing.JButton();
        FactorialButton = new javax.swing.JButton();
        DrGPicture = new javax.swing.JLabel();
        PushMeButton = new javax.swing.JButton();
        MainMenu = new javax.swing.JMenuBar();
        MainFileMenu = new javax.swing.JMenu();
        MainExitMenuItem = new javax.swing.JMenuItem();
        MainMethodsMenu = new javax.swing.JMenu();
        GCDMenuItem = new javax.swing.JMenuItem();
        FactorialMenuItem = new javax.swing.JMenuItem();

        GCDDialog.setAlwaysOnTop(true);
        GCDDialog.setEnabled(false);
        GCDDialog.setFocusCycleRoot(false);
        GCDDialog.setMinimumSize(new java.awt.Dimension(428, 330));

        GCDNum1TextField.setColumns(5);
        GCDNum1TextField.setToolTipText("Enter Num Here");
        GCDNum1TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GCDNum1TextFieldActionPerformed(evt);
            }
        });
        GCDNum1TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                GCDNum1TextFieldKeyPressed(evt);
            }
        });

        GCDTitle.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        GCDTitle.setText("GCD");

        GCDNum1Label.setText("Number One : ");

        GCDNum2Label.setText("Number Two : ");

        GCDNum2TextField.setColumns(5);
        GCDNum2TextField.setToolTipText("Enter Num Here");
        GCDNum2TextField.setName(""); // NOI18N
        GCDNum2TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                GCDNum2TextFieldKeyPressed(evt);
            }
        });

        GCDComputeButton.setText("Compute");
        GCDComputeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GCDComputeButtonMouseClicked(evt);
            }
        });
        GCDComputeButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                GCDComputeButtonKeyPressed(evt);
            }
        });

        GCDCloseButton.setText("Close");
        GCDCloseButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GCDCloseButtonMouseClicked(evt);
            }
        });
        GCDCloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GCDCloseButtonActionPerformed(evt);
            }
        });

        GCDResultLabel.setText("Result : ");

        GCDResult.setToolTipText("");

        javax.swing.GroupLayout GCDDialogLayout = new javax.swing.GroupLayout(GCDDialog.getContentPane());
        GCDDialog.getContentPane().setLayout(GCDDialogLayout);
        GCDDialogLayout.setHorizontalGroup(
            GCDDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GCDDialogLayout.createSequentialGroup()
                .addGroup(GCDDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GCDDialogLayout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(GCDTitle))
                    .addGroup(GCDDialogLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(GCDDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(GCDNum1Label)
                            .addComponent(GCDNum2Label)
                            .addComponent(GCDResultLabel))
                        .addGroup(GCDDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(GCDDialogLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(GCDDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(GCDNum2TextField)
                                    .addComponent(GCDNum1TextField)))
                            .addGroup(GCDDialogLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(GCDResult))))
                    .addGroup(GCDDialogLayout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(GCDComputeButton)
                        .addGap(75, 75, 75)
                        .addComponent(GCDCloseButton)))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        GCDDialogLayout.setVerticalGroup(
            GCDDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GCDDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(GCDTitle)
                .addGap(33, 33, 33)
                .addGroup(GCDDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GCDNum1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GCDNum1Label))
                .addGap(33, 33, 33)
                .addGroup(GCDDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GCDNum2Label)
                    .addComponent(GCDNum2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(GCDDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GCDResultLabel)
                    .addComponent(GCDResult))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(GCDDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GCDComputeButton)
                    .addComponent(GCDCloseButton))
                .addGap(78, 78, 78))
        );

        FactorialDialog.setMinimumSize(new java.awt.Dimension(450, 330));
        FactorialDialog.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                FactorialDialogKeyPressed(evt);
            }
        });

        FactComputeButton.setText("Compute");
        FactComputeButton.setName("ComputeButton"); // NOI18N
        FactComputeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FactComputeButtonMouseClicked(evt);
            }
        });
        FactComputeButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                FactComputeButtonKeyPressed(evt);
            }
        });

        FactCloseButton.setText("Close");
        FactCloseButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FactCloseButtonMouseClicked(evt);
            }
        });

        FactResultLabel.setText("Result : ");

        FactNum1TextField.setColumns(5);
        FactNum1TextField.setToolTipText("");
        FactNum1TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                FactNum1TextFieldKeyPressed(evt);
            }
        });

        FactorialTitle.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        FactorialTitle.setText("Factorial");

        FactNum1Label.setText("Number One : ");

        javax.swing.GroupLayout FactorialDialogLayout = new javax.swing.GroupLayout(FactorialDialog.getContentPane());
        FactorialDialog.getContentPane().setLayout(FactorialDialogLayout);
        FactorialDialogLayout.setHorizontalGroup(
            FactorialDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FactorialDialogLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(FactorialDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FactNum1Label)
                    .addComponent(FactResultLabel))
                .addGap(6, 6, 6)
                .addGroup(FactorialDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FactNum1TextField)
                    .addGroup(FactorialDialogLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(FactResult)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(261, Short.MAX_VALUE))
            .addGroup(FactorialDialogLayout.createSequentialGroup()
                .addGroup(FactorialDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FactorialDialogLayout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(FactComputeButton)
                        .addGap(75, 75, 75)
                        .addComponent(FactCloseButton))
                    .addGroup(FactorialDialogLayout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(FactorialTitle)))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        FactorialDialogLayout.setVerticalGroup(
            FactorialDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FactorialDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(FactorialTitle)
                .addGap(33, 33, 33)
                .addGroup(FactorialDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FactNum1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FactNum1Label))
                .addGap(30, 30, 30)
                .addGroup(FactorialDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FactResultLabel)
                    .addComponent(FactResult))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(FactorialDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FactComputeButton)
                    .addComponent(FactCloseButton))
                .addGap(78, 78, 78))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        GCDButton.setText("GCD");
        GCDButton.setMaximumSize(new java.awt.Dimension(76, 45));
        GCDButton.setMinimumSize(new java.awt.Dimension(76, 45));
        GCDButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GCDButtonMouseClicked(evt);
            }
        });
        GCDButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GCDButtonActionPerformed(evt);
            }
        });

        FactorialButton.setText("Factorial");
        FactorialButton.setMaximumSize(new java.awt.Dimension(76, 45));
        FactorialButton.setMinimumSize(new java.awt.Dimension(76, 45));
        FactorialButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FactorialButtonMouseClicked(evt);
            }
        });
        FactorialButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FactorialButtonActionPerformed(evt);
            }
        });

        DrGPicture.setMaximumSize(new java.awt.Dimension(50, 150));

        PushMeButton.setText("Push me");
        PushMeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PushMeButtonMouseClicked(evt);
            }
        });

        MainFileMenu.setText("File");

        MainExitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        MainExitMenuItem.setText("Exit");
        MainExitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MainExitMenuItemActionPerformed(evt);
            }
        });
        MainFileMenu.add(MainExitMenuItem);

        MainMenu.add(MainFileMenu);

        MainMethodsMenu.setText("Methods");

        GCDMenuItem.setText("GCD");
        GCDMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GCDMenuItemActionPerformed(evt);
            }
        });
        MainMethodsMenu.add(GCDMenuItem);

        FactorialMenuItem.setText("Factorial");
        FactorialMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FactorialMenuItemActionPerformed(evt);
            }
        });
        MainMethodsMenu.add(FactorialMenuItem);

        MainMenu.add(MainMethodsMenu);

        setJMenuBar(MainMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(GCDButton, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(FactorialButton, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                .addContainerGap(55, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PushMeButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(DrGPicture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(DrGPicture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GCDButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FactorialButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                .addComponent(PushMeButton)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GCDCloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GCDCloseButtonActionPerformed
        CloseGCD();
    }//GEN-LAST:event_GCDCloseButtonActionPerformed

    private void GCDButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GCDButtonMouseClicked
        OpenGCD();
    }//GEN-LAST:event_GCDButtonMouseClicked

    private void GCDNum1TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GCDNum1TextFieldActionPerformed
        ComputeGCD();
    }//GEN-LAST:event_GCDNum1TextFieldActionPerformed

    private void GCDCloseButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GCDCloseButtonMouseClicked
        CloseGCD();
    }//GEN-LAST:event_GCDCloseButtonMouseClicked

    private void GCDComputeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GCDComputeButtonMouseClicked
        ComputeGCD();

    }//GEN-LAST:event_GCDComputeButtonMouseClicked

    private void FactCloseButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FactCloseButtonMouseClicked
        CloseFactorial();
    }//GEN-LAST:event_FactCloseButtonMouseClicked

    private void FactComputeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FactComputeButtonMouseClicked
        ComputeFactorial();
    }//GEN-LAST:event_FactComputeButtonMouseClicked

    private void FactorialButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FactorialButtonMouseClicked
        OpenFactorial();
    }//GEN-LAST:event_FactorialButtonMouseClicked

    private void FactComputeButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FactComputeButtonKeyPressed
        CompFactKeyPress(evt);
    }//GEN-LAST:event_FactComputeButtonKeyPressed

    private void FactorialDialogKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FactorialDialogKeyPressed
        CompFactKeyPress(evt);
    }//GEN-LAST:event_FactorialDialogKeyPressed

    private void GCDComputeButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GCDComputeButtonKeyPressed
        GCDKeyPress(evt);
    }//GEN-LAST:event_GCDComputeButtonKeyPressed

    private void GCDNum1TextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GCDNum1TextFieldKeyPressed
        GCDKeyPress(evt);
    }//GEN-LAST:event_GCDNum1TextFieldKeyPressed

    private void GCDNum2TextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GCDNum2TextFieldKeyPressed
        GCDKeyPress(evt);
    }//GEN-LAST:event_GCDNum2TextFieldKeyPressed

    private void FactorialMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FactorialMenuItemActionPerformed
        OpenFactorial();
    }//GEN-LAST:event_FactorialMenuItemActionPerformed

    private void GCDMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GCDMenuItemActionPerformed
        OpenGCD();
    }//GEN-LAST:event_GCDMenuItemActionPerformed

    private void FactNum1TextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FactNum1TextFieldKeyPressed
        CompFactKeyPress(evt);
    }//GEN-LAST:event_FactNum1TextFieldKeyPressed

    private void MainExitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MainExitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_MainExitMenuItemActionPerformed

    private void GCDButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GCDButtonActionPerformed
        OpenGCD();
    }//GEN-LAST:event_GCDButtonActionPerformed

    private void FactorialButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FactorialButtonActionPerformed
        OpenFactorial();
    }//GEN-LAST:event_FactorialButtonActionPerformed

    private void PushMeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PushMeButtonMouseClicked
        LovelyDrG();
    }//GEN-LAST:event_PushMeButtonMouseClicked

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
            java.util.logging.Logger.getLogger(project2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(project2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(project2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(project2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new project2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DrGPicture;
    private javax.swing.JButton FactCloseButton;
    private javax.swing.JButton FactComputeButton;
    private javax.swing.JLabel FactNum1Label;
    private javax.swing.JTextField FactNum1TextField;
    private javax.swing.JLabel FactResult;
    private javax.swing.JLabel FactResultLabel;
    private javax.swing.JButton FactorialButton;
    private javax.swing.JDialog FactorialDialog;
    private javax.swing.JMenuItem FactorialMenuItem;
    private javax.swing.JLabel FactorialTitle;
    private javax.swing.JButton GCDButton;
    private javax.swing.JButton GCDCloseButton;
    private javax.swing.JButton GCDComputeButton;
    private javax.swing.JDialog GCDDialog;
    private javax.swing.JMenuItem GCDMenuItem;
    private javax.swing.JLabel GCDNum1Label;
    private javax.swing.JTextField GCDNum1TextField;
    private javax.swing.JLabel GCDNum2Label;
    private javax.swing.JTextField GCDNum2TextField;
    private javax.swing.JLabel GCDResult;
    private javax.swing.JLabel GCDResultLabel;
    private javax.swing.JLabel GCDTitle;
    private javax.swing.JMenuItem MainExitMenuItem;
    private javax.swing.JMenu MainFileMenu;
    private javax.swing.JMenuBar MainMenu;
    private javax.swing.JMenu MainMethodsMenu;
    private javax.swing.JButton PushMeButton;
    // End of variables declaration//GEN-END:variables
}
