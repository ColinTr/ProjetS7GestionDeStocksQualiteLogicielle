package vue;

import modele.ParametresBDD;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class FenetreDeParametres {

    private JFrame frameSettingWindow;
    private JPanel mainPanel;
    private JLabel addressLabel;
    private JTextField addressField;
    private JLabel accountLabel;
    private JLabel passwordLabel;
    private JTextField passwordField;
    private JTextField accountField;
    private JPanel optionsPanel;
    private JButton btnApply;
    private JButton btnCancel;

    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FenetreDeParametres window = new FenetreDeParametres();
                    window.frameSettingWindow.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public FenetreDeParametres() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        frameSettingWindow = new JFrame();
        ImageIcon logo = new ImageIcon(FenetreDeParametres.class.getClassLoader().getResource("file_icon.png"));
        frameSettingWindow.setIconImage(logo.getImage());
        frameSettingWindow.setBackground(Color.WHITE);
        frameSettingWindow.setTitle("Paramètres de connection à la BDD");
        frameSettingWindow.setBounds(dim.width/2-400/2, dim.height/2-290/2, 400, 290);
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{434, 0};
        gridBagLayout.rowHeights = new int[]{0, 0};
        gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
        frameSettingWindow.getContentPane().setLayout(gridBagLayout);

        mainPanel = new JPanel();
        mainPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc_mainPanel = new GridBagConstraints();
        gbc_mainPanel.fill = GridBagConstraints.BOTH;
        gbc_mainPanel.gridx = 0;
        gbc_mainPanel.gridy = 0;
        frameSettingWindow.getContentPane().add(mainPanel, gbc_mainPanel);
        GridBagLayout gbl_mainPanel = new GridBagLayout();
        gbl_mainPanel.columnWidths = new int[]{0, 0};
        gbl_mainPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        gbl_mainPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gbl_mainPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        mainPanel.setLayout(gbl_mainPanel);

        addressLabel = new JLabel("Addresse de connexion :");
        GridBagConstraints gbc_addressLabel = new GridBagConstraints();
        gbc_addressLabel.anchor = GridBagConstraints.WEST;
        gbc_addressLabel.insets = new Insets(10, 10, 5, 10);
        gbc_addressLabel.gridx = 0;
        gbc_addressLabel.gridy = 0;
        mainPanel.add(addressLabel, gbc_addressLabel);

        addressField = new JTextField();
        GridBagConstraints gbc_addressField = new GridBagConstraints();
        gbc_addressField.insets = new Insets(5, 10, 15, 10);
        gbc_addressField.fill = GridBagConstraints.HORIZONTAL;
        gbc_addressField.gridx = 0;
        gbc_addressField.gridy = 1;
        mainPanel.add(addressField, gbc_addressField);
        addressField.setColumns(10);
        addressField.setText(ParametresBDD.getAdresse());

        accountLabel = new JLabel("Compte :");
        GridBagConstraints gbc_accountLabel = new GridBagConstraints();
        gbc_accountLabel.anchor = GridBagConstraints.WEST;
        gbc_accountLabel.insets = new Insets(5, 10, 5, 10);
        gbc_accountLabel.gridx = 0;
        gbc_accountLabel.gridy = 2;
        mainPanel.add(accountLabel, gbc_accountLabel);

        accountField = new JTextField();
        GridBagConstraints gbc_accountField = new GridBagConstraints();
        gbc_accountField.insets = new Insets(5, 10, 15, 10);
        gbc_accountField.fill = GridBagConstraints.HORIZONTAL;
        gbc_accountField.gridx = 0;
        gbc_accountField.gridy = 3;
        mainPanel.add(accountField, gbc_accountField);
        accountField.setColumns(10);
        accountField.setText(ParametresBDD.getUtilisateur());

        passwordLabel = new JLabel("Mot de passe :");
        GridBagConstraints gbc_passwordLabel = new GridBagConstraints();
        gbc_passwordLabel.anchor = GridBagConstraints.WEST;
        gbc_passwordLabel.insets = new Insets(5, 10, 5, 10);
        gbc_passwordLabel.gridx = 0;
        gbc_passwordLabel.gridy = 4;
        mainPanel.add(passwordLabel, gbc_passwordLabel);

        passwordField = new JTextField();
        GridBagConstraints gbc_passwordField = new GridBagConstraints();
        gbc_passwordField.insets = new Insets(5, 10, 10, 10);
        gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
        gbc_passwordField.gridx = 0;
        gbc_passwordField.gridy = 5;
        mainPanel.add(passwordField, gbc_passwordField);
        passwordField.setColumns(10);
        passwordField.setText(ParametresBDD.getMotDePasse());

        optionsPanel = new JPanel();
        optionsPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc_optionsPanel = new GridBagConstraints();
        gbc_optionsPanel.fill = GridBagConstraints.BOTH;
        gbc_optionsPanel.gridx = 0;
        gbc_optionsPanel.gridy = 6;
        mainPanel.add(optionsPanel, gbc_optionsPanel);
        GridBagLayout gbl_optionsPanel = new GridBagLayout();
        gbl_optionsPanel.columnWidths = new int[]{0, 0, 0};
        gbl_optionsPanel.rowHeights = new int[]{0, 0};
        gbl_optionsPanel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
        gbl_optionsPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
        optionsPanel.setLayout(gbl_optionsPanel);

        btnApply = new JButton("Confirmer");
        btnApply.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Properties newInfos = new Properties();
                newInfos.put("user", accountField.getText());
                newInfos.put("password", passwordField.getText());
                ParametresBDD.setInformationsUtilisateur(newInfos);
                ParametresBDD.setAdresse(addressField.getText());
                frameSettingWindow.dispose();
            }
        });
        GridBagConstraints gbc_btnApply = new GridBagConstraints();
        gbc_btnApply.anchor = GridBagConstraints.EAST;
        gbc_btnApply.insets = new Insets(0, 0, 0, 10);
        gbc_btnApply.gridx = 0;
        gbc_btnApply.gridy = 0;
        optionsPanel.add(btnApply, gbc_btnApply);

        btnCancel = new JButton("Annuler");
        btnCancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frameSettingWindow.dispose();
            }
        });
        GridBagConstraints gbc_btnCancel = new GridBagConstraints();
        gbc_btnCancel.insets = new Insets(0, 10, 0, 0);
        gbc_btnCancel.anchor = GridBagConstraints.WEST;
        gbc_btnCancel.gridx = 1;
        gbc_btnCancel.gridy = 0;
        optionsPanel.add(btnCancel, gbc_btnCancel);
    }

}
