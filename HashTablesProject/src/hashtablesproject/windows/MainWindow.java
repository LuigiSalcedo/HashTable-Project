package hashtablesproject.windows;

import hashtablesproject.models.Identifier;
import hashtablesproject.models.Person;
import hashtablesproject.structures.Entry;
import hashtablesproject.structures.HashTable;
import hashtablesproject.structures.LinkedList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.function.Function;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luigi Salcedo
 */
public class MainWindow extends javax.swing.JFrame 
{
    private File selectedFile;
    private HashTable<Identifier, Person> data;
    
    public MainWindow() 
    {
        initComponents();
        updateComponentsStatus(false);
        firstFunctionRadioButton.setSelected(true);
    }
    
    private void updateComponentsStatus(boolean state)
    {
        idTextField.setText("");
        idTextField.setEditable(state);
        idTextField.setEnabled(state);
        insertButton.setEnabled(state);
        removeButton.setEnabled(state);
        searchButton.setEnabled(state);
        insertIDTextField.setEditable(state);
        firstNameTextField.setEditable(state);
        lastNameTextField.setEditable(state);
        genderTextField.setEditable(state);
        
        if(state == false)
        {
            DefaultTableModel table = (DefaultTableModel) dataTable.getModel();
            table.setRowCount(0);
            dataTable.setModel(table);
        }
    }
    
    private void updateTable()
    {
        DefaultTableModel table = (DefaultTableModel) dataTable.getModel();
        table.setRowCount(0);
        if(data == null)
        {
            dataTable.setModel(table);
            collisionsValue.setText(String.valueOf(0));
            return;            
        }
        for(int i = 0; i < data.getBuckets().length; i++)
        {
            if(data.getBuckets()[i] == null) continue;
            table.addRow(new Object[]{i, 
                data.getBuckets()[i].toString()});
        }
        dataTable.setModel(table);
        collisionsValue.setText(String.valueOf(data.collisions()));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        hashFunctionsGroup = new javax.swing.ButtonGroup();
        informationPanel = new javax.swing.JPanel();
        fileSelectedValue = new javax.swing.JLabel();
        fileSelectedLabel = new javax.swing.JLabel();
        secondFunctionRadioButton = new javax.swing.JRadioButton();
        firstFunctionRadioButton = new javax.swing.JRadioButton();
        mainPanel = new javax.swing.JPanel();
        insertButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        idTextField = new javax.swing.JTextField();
        idSearcherLabel = new javax.swing.JLabel();
        tableScroll = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();
        insertIdLabel = new javax.swing.JLabel();
        insertIDTextField = new javax.swing.JTextField();
        firstNameLabel = new javax.swing.JLabel();
        firstNameTextField = new javax.swing.JTextField();
        lastNameLabel = new javax.swing.JLabel();
        lastNameTextField = new javax.swing.JTextField();
        genderLabel = new javax.swing.JLabel();
        genderTextField = new javax.swing.JTextField();
        collisionsValue = new javax.swing.JLabel();
        collisionsText = new javax.swing.JLabel();
        optionsBar = new javax.swing.JMenuBar();
        fileOption = new javax.swing.JMenu();
        loadFileOptionButton = new javax.swing.JMenuItem();
        saveFileOptionButton = new javax.swing.JMenuItem();
        closeFileOptionButton = new javax.swing.JMenuItem();
        infoOption = new javax.swing.JMenu();
        howToUseButton = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HashTable Project");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(getPreferredSize());

        informationPanel.setBackground(new java.awt.Color(255, 255, 255));
        informationPanel.setBorder(javax.swing.BorderFactory.createLineBorder(null));

        fileSelectedValue.setBackground(new java.awt.Color(255, 255, 255));
        fileSelectedValue.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        fileSelectedValue.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fileSelectedValue.setText("no file select yet.");
        fileSelectedValue.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        fileSelectedLabel.setBackground(new java.awt.Color(255, 255, 255));
        fileSelectedLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        fileSelectedLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fileSelectedLabel.setText("Selected File:");
        fileSelectedLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        secondFunctionRadioButton.setBackground(new java.awt.Color(255, 255, 255));
        hashFunctionsGroup.add(secondFunctionRadioButton);
        secondFunctionRadioButton.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        secondFunctionRadioButton.setText("k mod m");
        secondFunctionRadioButton.setFocusPainted(false);

        firstFunctionRadioButton.setBackground(new java.awt.Color(255, 255, 255));
        hashFunctionsGroup.add(firstFunctionRadioButton);
        firstFunctionRadioButton.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        firstFunctionRadioButton.setText("m(kA mod 1)");
        firstFunctionRadioButton.setFocusPainted(false);

        javax.swing.GroupLayout informationPanelLayout = new javax.swing.GroupLayout(informationPanel);
        informationPanel.setLayout(informationPanelLayout);
        informationPanelLayout.setHorizontalGroup(
            informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(informationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fileSelectedLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fileSelectedValue)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(firstFunctionRadioButton)
                .addGap(18, 18, 18)
                .addComponent(secondFunctionRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        informationPanelLayout.setVerticalGroup(
            informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fileSelectedLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
            .addComponent(firstFunctionRadioButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(secondFunctionRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(fileSelectedValue, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setBorder(javax.swing.BorderFactory.createLineBorder(null));

        insertButton.setBackground(new java.awt.Color(216, 239, 216));
        insertButton.setFont(new java.awt.Font("Segoe UI Semilight", 0, 15)); // NOI18N
        insertButton.setText("Insert");
        insertButton.setBorder(javax.swing.BorderFactory.createLineBorder(null));
        insertButton.setFocusPainted(false);
        insertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertButtonActionPerformed(evt);
            }
        });

        removeButton.setBackground(new java.awt.Color(250, 191, 191));
        removeButton.setFont(new java.awt.Font("Segoe UI Semilight", 0, 15)); // NOI18N
        removeButton.setText("Remove");
        removeButton.setBorder(javax.swing.BorderFactory.createLineBorder(null));
        removeButton.setFocusPainted(false);
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        searchButton.setBackground(new java.awt.Color(155, 200, 241));
        searchButton.setFont(new java.awt.Font("Segoe UI Semilight", 0, 15)); // NOI18N
        searchButton.setText("Search");
        searchButton.setBorder(javax.swing.BorderFactory.createLineBorder(null));
        searchButton.setFocusPainted(false);
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        idTextField.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        idTextField.setBorder(javax.swing.BorderFactory.createLineBorder(null));

        idSearcherLabel.setBackground(new java.awt.Color(255, 255, 255));
        idSearcherLabel.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        idSearcherLabel.setText("ID (Remove or Search):");

        dataTable.setBorder(javax.swing.BorderFactory.createLineBorder(null));
        dataTable.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        dataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Hash", "Data"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableScroll.setViewportView(dataTable);

        insertIdLabel.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        insertIdLabel.setText("ID:");

        insertIDTextField.setBorder(javax.swing.BorderFactory.createLineBorder(null));

        firstNameLabel.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        firstNameLabel.setText("First Name:");

        firstNameTextField.setBorder(javax.swing.BorderFactory.createLineBorder(null));

        lastNameLabel.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        lastNameLabel.setText("Last Name:");

        lastNameTextField.setBorder(javax.swing.BorderFactory.createLineBorder(null));

        genderLabel.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        genderLabel.setText("Gender:");

        genderTextField.setBorder(javax.swing.BorderFactory.createLineBorder(null));

        collisionsValue.setFont(new java.awt.Font("Segoe UI Semilight", 0, 36)); // NOI18N
        collisionsValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        collisionsValue.setText("0");
        collisionsValue.setBorder(javax.swing.BorderFactory.createLineBorder(null));

        collisionsText.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        collisionsText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        collisionsText.setText("Collisions");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(tableScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(idSearcherLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(insertButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(insertIdLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(insertIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(firstNameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lastNameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(genderLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(genderTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(collisionsValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(collisionsText, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                        .addGap(36, 36, 36))))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(insertButton)
                            .addComponent(insertIdLabel)
                            .addComponent(insertIDTextField)
                            .addComponent(firstNameLabel)
                            .addComponent(firstNameTextField)
                            .addComponent(lastNameLabel)
                            .addComponent(lastNameTextField)
                            .addComponent(genderLabel)
                            .addComponent(genderTextField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(removeButton)
                            .addComponent(searchButton)
                            .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idSearcherLabel)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(collisionsText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(collisionsValue, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tableScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        optionsBar.setBackground(new java.awt.Color(51, 51, 51));
        optionsBar.setBorder(null);
        optionsBar.setForeground(new java.awt.Color(255, 255, 255));
        optionsBar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N

        fileOption.setBorder(null);
        fileOption.setForeground(new java.awt.Color(255, 255, 255));
        fileOption.setText("File");
        fileOption.setBorderPainted(false);

        loadFileOptionButton.setText("Load File");
        loadFileOptionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadFileOptionButtonActionPerformed(evt);
            }
        });
        fileOption.add(loadFileOptionButton);

        saveFileOptionButton.setText("Save File");
        saveFileOptionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFileOptionButtonActionPerformed(evt);
            }
        });
        fileOption.add(saveFileOptionButton);

        closeFileOptionButton.setText("Close File");
        closeFileOptionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeFileOptionButtonActionPerformed(evt);
            }
        });
        fileOption.add(closeFileOptionButton);

        optionsBar.add(fileOption);

        infoOption.setForeground(new java.awt.Color(255, 255, 255));
        infoOption.setText("More info");

        howToUseButton.setText("How to use");
        howToUseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                howToUseButtonActionPerformed(evt);
            }
        });
        infoOption.add(howToUseButton);

        optionsBar.add(infoOption);

        setJMenuBar(optionsBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(informationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(informationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadFileOptionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadFileOptionButtonActionPerformed
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivo datos excel separado por comas.", "csv"));
        fileChooser.showOpenDialog(this);
        
        selectedFile = fileChooser.getSelectedFile();
        
        if(selectedFile == null)
        {
            fileSelectedValue.setText("no file selected yet.");
            updateComponentsStatus(false);
            return;
        }
        
        if(!selectedFile.getName().endsWith(".csv"))
        {
            JOptionPane.showMessageDialog(null, "This doesn't look like a .csv file.", "File error", JOptionPane.ERROR_MESSAGE);
            selectedFile = null;
            fileSelectedValue.setText("no file selected yet.");
            updateComponentsStatus(false);
            return;
        }
        
        fileSelectedValue.setText(selectedFile.getAbsolutePath());
        if(!loadData())
        {
            JOptionPane.showMessageDialog(null, "Ups. Something went wrong. Please verify the data from the file.", 
                    "Data error", JOptionPane.ERROR_MESSAGE);         
            updateComponentsStatus(true);
            return;
        }
        updateComponentsStatus(true);
    }//GEN-LAST:event_loadFileOptionButtonActionPerformed

    private void insertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertButtonActionPerformed
        String id = insertIDTextField.getText();
        String firstName = firstNameTextField.getText();
        String lastName = lastNameTextField.getText();
        String gender = genderTextField.getText();
        
        if(id == null){
            showInsertDataError("ID");
            return;
        }
        if(id.isBlank()){
            showInsertDataError("ID");
            return;
        }
        
        if(firstName.isBlank()){
            showInsertDataError("First name");
            return;           
        }
        
        if(lastName.isBlank()){
            showInsertDataError("Last name");
            return;
        }
        
        if(gender.isBlank()){
            showInsertDataError("Gender");
            return;
        }
        
        Identifier ID = new Identifier(id);
        data.put(ID, new Person(ID, firstName, lastName, gender));
        insertIDTextField.setText("");
        firstNameTextField.setText("");
        lastNameTextField.setText("");
        genderTextField.setText("");
        
        JOptionPane.showMessageDialog(null, "The data has been added/update.", "Insert/Update completed.", JOptionPane.DEFAULT_OPTION);
        updateTable();
    }//GEN-LAST:event_insertButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        String ID = idTextField.getText();
        Person person = data.get(new Identifier(ID));
        if(person == null)
        {
            JOptionPane.showMessageDialog(null, "Element not found.", "Search completed.", JOptionPane.DEFAULT_OPTION);
            return;
        }
        JOptionPane.showMessageDialog(null, "ID: " + person.getID().getIdValue() +
                                            "\nFirst name: " + person.getFirstName() + 
                                            "\nLast name: " + person.getLastName() + 
                                            "\nGender: " + person.getGender(),  
                "Search completed. Element found.", JOptionPane.DEFAULT_OPTION);
        
    }//GEN-LAST:event_searchButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        String ID = idTextField.getText();
        if(data.remove(new Identifier(ID)) == null)
        {
            JOptionPane.showMessageDialog(null, "Element not found.", "Remove completed.", JOptionPane.DEFAULT_OPTION);
            return;            
        }
        JOptionPane.showMessageDialog(null, "Element removed.", "Remove completed.", JOptionPane.DEFAULT_OPTION);
        updateTable();
    }//GEN-LAST:event_removeButtonActionPerformed

    private void saveFileOptionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveFileOptionButtonActionPerformed
        try(PrintWriter pw = new PrintWriter(new FileWriter(selectedFile)))
        {
            Person aux;
            for (LinkedList<Entry<Identifier, Person>> bucket : data.getBuckets()) {
                if (bucket == null) {
                    continue;
                }
                for (Entry<Identifier, Person> element : bucket) {
                    aux = element.getValue();
                    pw.println(aux.getID() + ";" + aux.getFirstName() + ";" + aux.getLastName() + ";" + aux.getGender());
                }
            }
                                  
        }
        catch(IOException e)
        {
            JOptionPane.showMessageDialog(null, "Something went wrong with file saving.", "Save error", JOptionPane.ERROR_MESSAGE);
        }
        JOptionPane.showMessageDialog(null, "Data saved!", "File saved", JOptionPane.DEFAULT_OPTION);
    }//GEN-LAST:event_saveFileOptionButtonActionPerformed

    private void closeFileOptionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeFileOptionButtonActionPerformed
        data = null;
        selectedFile = null;
        fileSelectedValue.setText("no file selected yet.");
        updateTable();
        updateComponentsStatus(false);
    }//GEN-LAST:event_closeFileOptionButtonActionPerformed

    private void howToUseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_howToUseButtonActionPerformed
        HowToUseWindow htu = new HowToUseWindow();
        htu.setVisible(true);
    }//GEN-LAST:event_howToUseButtonActionPerformed

    private void showInsertDataError(String field)
    {
        JOptionPane.showMessageDialog(null, field + " isn't valid.", "Insert data error", JOptionPane.ERROR_MESSAGE);      
    }
    
    private boolean loadData()
    {
        data = null;
        if(firstFunctionRadioButton.isSelected())
        {
            data = new HashTable(256, 10, new Function<Integer, Integer>(){
                @Override
                public Integer apply(Integer hashCode){
                    return (int)(256 * (hashCode * (Math.sqrt(5) - 1) / 2));
                }
            });
        }
        else
        {
            data = new HashTable(256, 10, x -> x);
        }
        try(BufferedReader br = new BufferedReader(new FileReader(selectedFile)))
        {
            String line;
            Person personData;
            while((line = br.readLine()) != null)
            {
                if(line.isBlank()) continue;
                personData = Person.parsePerson(line);
                data.put(personData.getID(), personData);
            }
        }
        catch(IOException e){
            data = null;
            return false;
        }
        updateTable();
        return true;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem closeFileOptionButton;
    private javax.swing.JLabel collisionsText;
    private javax.swing.JLabel collisionsValue;
    private javax.swing.JTable dataTable;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JMenu fileOption;
    private javax.swing.JLabel fileSelectedLabel;
    private javax.swing.JLabel fileSelectedValue;
    private javax.swing.JRadioButton firstFunctionRadioButton;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JTextField firstNameTextField;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JTextField genderTextField;
    private javax.swing.ButtonGroup hashFunctionsGroup;
    private javax.swing.JMenuItem howToUseButton;
    private javax.swing.JLabel idSearcherLabel;
    private javax.swing.JTextField idTextField;
    private javax.swing.JMenu infoOption;
    private javax.swing.JPanel informationPanel;
    private javax.swing.JButton insertButton;
    private javax.swing.JTextField insertIDTextField;
    private javax.swing.JLabel insertIdLabel;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JTextField lastNameTextField;
    private javax.swing.JMenuItem loadFileOptionButton;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar optionsBar;
    private javax.swing.JButton removeButton;
    private javax.swing.JMenuItem saveFileOptionButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JRadioButton secondFunctionRadioButton;
    private javax.swing.JScrollPane tableScroll;
    // End of variables declaration//GEN-END:variables
}
