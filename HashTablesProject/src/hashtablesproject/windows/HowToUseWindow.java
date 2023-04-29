package hashtablesproject.windows;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Luigi Salcedo
 */
public class HowToUseWindow extends javax.swing.JFrame {

    public HowToUseWindow() {
        initComponents();
        readData();
        info.setEditable(false);
    }
    
    private void readData()
    {
        StringBuilder sb = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader(new File("data\\instructivos.txt"))))
        {
            String line;
            while((line = br.readLine()) != null)
            {
                sb.append(line).append("\n");
            }
        }
        catch(IOException e)
        {
            sb.append("\n").append("Ha ocurrido un error al leer el archivo 'instructivos.txt'").append("\n");
        }
        info.setText(sb.toString());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        text = new javax.swing.JLabel();
        infoScroll = new javax.swing.JScrollPane();
        info = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        text.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        text.setText("How to use:");

        info.setColumns(20);
        info.setRows(5);
        info.setAutoscrolls(false);
        infoScroll.setViewportView(info);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(text)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(infoScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 716, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(text)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(infoScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea info;
    private javax.swing.JScrollPane infoScroll;
    private javax.swing.JLabel text;
    // End of variables declaration//GEN-END:variables
}
