package vue;

import modele.ParametresBDD;
import org.apache.log4j.Logger;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import java.util.Objects;
import java.util.Properties;



public class FenetreDeParametres {

    private JFrame frameSettingWindow;

    final static Logger logger = Logger.getLogger(FenetreDeParametres.class);

    private final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                FenetreDeParametres window = new FenetreDeParametres();
                window.frameSettingWindow.setVisible(true);
            } catch (Exception e) {
                logger.fatal(e);
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
            logger.fatal(e);
        }


        JPanel mainPanel;
        JLabel addressLabel;
        JTextField addressField;
        JLabel accountLabel;
        JLabel passwordLabel;
        JTextField passwordField;
        JTextField accountField;
        JPanel optionsPanel;
        JButton btnApply;
        JButton btnCancel;

        frameSettingWindow = new JFrame();
        ImageIcon logo = new ImageIcon(Objects.requireNonNull(FenetreDeParametres.class.getClassLoader().getResource("icon.png")));
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
        GridBagConstraints gbcmainPanel = new GridBagConstraints();
        gbcmainPanel.fill = GridBagConstraints.BOTH;
        gbcmainPanel.gridx = 0;
        gbcmainPanel.gridy = 0;
        frameSettingWindow.getContentPane().add(mainPanel, gbcmainPanel);
        GridBagLayout gblMainPanel = new GridBagLayout();
        gblMainPanel.columnWidths = new int[]{0, 0};
        gblMainPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        gblMainPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gblMainPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        mainPanel.setLayout(gblMainPanel);

        addressLabel = new JLabel("Addresse de connexion :");
        GridBagConstraints gbcAddressLabel = new GridBagConstraints();
        gbcAddressLabel.anchor = GridBagConstraints.WEST;
        gbcAddressLabel.insets = new Insets(10, 10, 5, 10);
        gbcAddressLabel.gridx = 0;
        gbcAddressLabel.gridy = 0;
        mainPanel.add(addressLabel, gbcAddressLabel);

        addressField = new JTextField();
        GridBagConstraints gbcAddressField = new GridBagConstraints();
        gbcAddressField.insets = new Insets(5, 10, 15, 10);
        gbcAddressField.fill = GridBagConstraints.HORIZONTAL;
        gbcAddressField.gridx = 0;
        gbcAddressField.gridy = 1;
        mainPanel.add(addressField, gbcAddressField);
        addressField.setColumns(10);
        addressField.setText(ParametresBDD.getAdresse());

        accountLabel = new JLabel("Compte :");
        GridBagConstraints gbcAccountLabel = new GridBagConstraints();
        gbcAccountLabel.anchor = GridBagConstraints.WEST;
        gbcAccountLabel.insets = new Insets(5, 10, 5, 10);
        gbcAccountLabel.gridx = 0;
        gbcAccountLabel.gridy = 2;
        mainPanel.add(accountLabel, gbcAccountLabel);

        accountField = new JTextField();
        GridBagConstraints gbcAccountField = new GridBagConstraints();
        gbcAccountField.insets = new Insets(5, 10, 15, 10);
        gbcAccountField.fill = GridBagConstraints.HORIZONTAL;
        gbcAccountField.gridx = 0;
        gbcAccountField.gridy = 3;
        mainPanel.add(accountField, gbcAccountField);
        accountField.setColumns(10);
        accountField.setText(ParametresBDD.getUtilisateur());

        passwordLabel = new JLabel("Mot de passe :");
        GridBagConstraints gbcPasswordLabel = new GridBagConstraints();
        gbcPasswordLabel.anchor = GridBagConstraints.WEST;
        gbcPasswordLabel.insets = new Insets(5, 10, 5, 10);
        gbcPasswordLabel.gridx = 0;
        gbcPasswordLabel.gridy = 4;
        mainPanel.add(passwordLabel, gbcPasswordLabel);

        passwordField = new JTextField();
        GridBagConstraints gbcPasswordField = new GridBagConstraints();
        gbcPasswordField.insets = new Insets(5, 10, 10, 10);
        gbcPasswordField.fill = GridBagConstraints.HORIZONTAL;
        gbcPasswordField.gridx = 0;
        gbcPasswordField.gridy = 5;
        mainPanel.add(passwordField, gbcPasswordField);
        passwordField.setColumns(10);
        passwordField.setText(ParametresBDD.getMotDePasse());

        optionsPanel = new JPanel();
        optionsPanel.setBackground(Color.WHITE);
        GridBagConstraints gbcOptionsPanel = new GridBagConstraints();
        gbcOptionsPanel.fill = GridBagConstraints.BOTH;
        gbcOptionsPanel.gridx = 0;
        gbcOptionsPanel.gridy = 6;
        mainPanel.add(optionsPanel, gbcOptionsPanel);
        GridBagLayout gblOptionsPanel = new GridBagLayout();
        gblOptionsPanel.columnWidths = new int[]{0, 0, 0};
        gblOptionsPanel.rowHeights = new int[]{0, 0};
        gblOptionsPanel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
        gblOptionsPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
        optionsPanel.setLayout(gblOptionsPanel);

        btnApply = new JButton("Confirmer");
        btnApply.addActionListener(e -> {
            Properties newInfos = new Properties();
            newInfos.put("user", accountField.getText());
            newInfos.put("password", passwordField.getText());
            ParametresBDD.setInformationsUtilisateur(newInfos);
            ParametresBDD.setAdresse(addressField.getText());
            frameSettingWindow.dispose();
        });
        GridBagConstraints gbcBtnApply = new GridBagConstraints();
        gbcBtnApply.anchor = GridBagConstraints.EAST;
        gbcBtnApply.insets = new Insets(0, 0, 0, 10);
        gbcBtnApply.gridx = 0;
        gbcBtnApply.gridy = 0;
        optionsPanel.add(btnApply, gbcBtnApply);

        btnCancel = new JButton("Annuler");
        btnCancel.addActionListener(e -> frameSettingWindow.dispose());
        GridBagConstraints gbcBtnCancel = new GridBagConstraints();
        gbcBtnCancel.insets = new Insets(0, 10, 0, 0);
        gbcBtnCancel.anchor = GridBagConstraints.WEST;
        gbcBtnCancel.gridx = 1;
        gbcBtnCancel.gridy = 0;
        optionsPanel.add(btnCancel, gbcBtnCancel);
    }

}