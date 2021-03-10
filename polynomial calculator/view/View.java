package PT2020.assign1.Assignment1.view;

import javax.swing.JOptionPane;
import PT2020.assign1.Assignment1.controller.*;

public class View extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private Controller controller;
    public View() {
        initComponents();
    }

    private javax.swing.JButton add;
    private javax.swing.JButton clear;
    private javax.swing.JButton der1;
    private javax.swing.JButton der2;
    private javax.swing.JButton div;
    private javax.swing.JButton int1;
    private javax.swing.JButton int2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JButton mul;
    private javax.swing.JLabel p1;
    private javax.swing.JLabel p2;
    private javax.swing.JTextField poly1;
    private javax.swing.JTextField poly2;
    private javax.swing.JTextField rem;
    private javax.swing.JLabel remainder;
    private javax.swing.JTextField res;
    private javax.swing.JLabel result;
    private javax.swing.JButton sub;
                     
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        p1 = new javax.swing.JLabel();
        p2 = new javax.swing.JLabel();
        poly1 = new javax.swing.JTextField();
        poly2 = new javax.swing.JTextField();
        der1 = new javax.swing.JButton();
        int1 = new javax.swing.JButton();
        der2 = new javax.swing.JButton();
        int2 = new javax.swing.JButton();
        add = new javax.swing.JButton();
        sub = new javax.swing.JButton();
        mul = new javax.swing.JButton();
        div = new javax.swing.JButton();
        result = new javax.swing.JLabel();
        rem = new javax.swing.JTextField();
        remainder = new javax.swing.JLabel();
        res = new javax.swing.JTextField();
        clear = new javax.swing.JButton();

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        p1.setText("Polynomial1");

        p2.setText("Polynomial2");

        der1.setText("Derivative");
        der1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                der1ActionPerformed(evt);
            }
        });

        int1.setText("Integrate");
        int1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int1ActionPerformed(evt);
            }
        });

        der2.setText("Derivative");
        der2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                der2ActionPerformed(evt);
            }
        });

        int2.setText("Integrate");
        int2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int2ActionPerformed(evt);
            }
        });

        add.setText("+");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        sub.setText("-");
        sub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subActionPerformed(evt);
            }
        });

        mul.setText("*");
        mul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mulActionPerformed(evt);
            }
        });

        div.setText("/");
        div.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                divActionPerformed(evt);
            }
        });

        result.setText("Result");

        remainder.setText("Remainder");

        clear.setText("Clear");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(p2)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(add)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(sub)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(mul)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(div)
                                        .addGap(0, 71, Short.MAX_VALUE))
                                    .addComponent(poly2)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(p1)
                                .addGap(18, 18, 18)
                                .addComponent(poly1)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(der1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(int1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(der2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(int2))
                            .addComponent(clear)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(remainder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(result, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(res)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rem, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(p1)
                    .addComponent(poly1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(der1)
                    .addComponent(int1))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(p2)
                    .addComponent(poly2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(der2)
                    .addComponent(int2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add)
                    .addComponent(sub)
                    .addComponent(mul)
                    .addComponent(div)
                    .addComponent(clear))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(result)
                    .addComponent(res, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(remainder)
                    .addComponent(rem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        pack();
    }
    
    public String getPoly1() {
    	return poly1.getText();
    }
    public String getPoly2() {
    	return poly2.getText();
    }
    
    private void addActionPerformed(java.awt.event.ActionEvent evt) {                                    
        try {
    		controller.addition();
    	} catch (MissingInputException e) {
    		JOptionPane.showMessageDialog(View.this, e.getMessage(), "Warning",JOptionPane.WARNING_MESSAGE);
    	}
    }                                                              

    private void der1ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        try {
				controller.derivationFirst();
			} catch (MissingInputException e) {
				JOptionPane.showMessageDialog(View.this, e.getMessage(), "Warning",JOptionPane.WARNING_MESSAGE);
			}
    }                                    

    private void der2ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        try {
				controller.derivationSecond();
			} catch (MissingInputException e) {
				JOptionPane.showMessageDialog(View.this, e.getMessage(), "Warning",JOptionPane.WARNING_MESSAGE);
			}
    }                                                               

    private void int1ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        try {
				controller.integrationFirst();
			} catch (MissingInputException e) {
				JOptionPane.showMessageDialog(View.this, e.getMessage(),"Warning",JOptionPane.WARNING_MESSAGE);
			}
    }                                    

    private void int2ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        try {
				controller.integrationSecond();
			} catch (MissingInputException e) {
				JOptionPane.showMessageDialog(View.this, e.getMessage(), "Warning",JOptionPane.WARNING_MESSAGE);
			}
    }                                    

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {                                      
    	poly1.setText("");
    	poly2.setText("");
    	res.setText("");
    	rem.setText("");
    }                                     

    private void subActionPerformed(java.awt.event.ActionEvent evt) {                                    

        try {
    		controller.subtraction();
    	} catch (MissingInputException e) {
    		JOptionPane.showMessageDialog(View.this, e.getMessage(), "Warning",JOptionPane.WARNING_MESSAGE);
    	}
    }                                   

    private void mulActionPerformed(java.awt.event.ActionEvent evt) {
        try {
				controller.multiplication();
			} catch (MissingInputException e) {
				JOptionPane.showMessageDialog(View.this, e.getMessage(), "Warning",JOptionPane.WARNING_MESSAGE);
			}
    }                                   

    private void divActionPerformed(java.awt.event.ActionEvent evt) {                                    
        try {
				controller.division();
			} catch (MissingInputException e) {
				JOptionPane.showMessageDialog(View.this, e.getMessage(), "Warning",JOptionPane.WARNING_MESSAGE);
			}
    }                                   

    public void setResultField(String result) {
		res.setText(result);
	}
	
    public void setRemainderField(String remain) {
    	rem.setText(remain);
    }
	public void setController(Controller controller) {
		this.controller = controller;
	}
                  
}
