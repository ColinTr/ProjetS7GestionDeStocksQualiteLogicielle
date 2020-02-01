package vue;

import controleur.Connexion;
import controleur.UtilisateurDAO;
import modele.ParametresBDD;
import modele.Utilisateur;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Objects;

public class FenetreDeConnexion {

    private final Color blueColor = new Color(50, 100, 150);
    private final Color colorHover = new Color(169, 171, 184);
    private final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    private JFrame frameLoginWindow;

    private JButton settingsButton;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel errorMessageLabel;

    private static final String usernameConstant = "Username";
    private static final String passwordConstant = "********";

    final static Logger logger = Logger.getLogger(FenetreDeConnexion.class);

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                FenetreDeConnexion window = new FenetreDeConnexion();
                window.frameLoginWindow.setVisible(true);
            } catch (Exception e) {
                logger.fatal(e);
            }
        });
    }

    /**
     * Create the application.
     */
    public FenetreDeConnexion() {
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

        frameLoginWindow = new JFrame();
        frameLoginWindow.getContentPane().setBackground(Color.BLACK);
        ImageIcon logo = new ImageIcon(Objects.requireNonNull(FenetreDeConnexion.class.getClassLoader().getResource("icon.png")));
        frameLoginWindow.setIconImage(logo.getImage());
        frameLoginWindow.setTitle("Connexion");
        frameLoginWindow.setBounds(dim.width/2-530/2, dim.height/2-250/2, 530, 250);
        frameLoginWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ImageIcon img = new ImageIcon(Objects.requireNonNull(FenetreDeConnexion.class.getClassLoader().getResource("user_icon.png")));
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{485, 0};
        gridBagLayout.rowHeights = new int[]{250, 0};
        gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
        frameLoginWindow.getContentPane().setLayout(gridBagLayout);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.BLACK);
        GridBagConstraints gbcMainPanel = new GridBagConstraints();
        gbcMainPanel.fill = GridBagConstraints.BOTH;
        gbcMainPanel.gridx = 0;
        gbcMainPanel.gridy = 0;
        frameLoginWindow.getContentPane().add(mainPanel, gbcMainPanel);
        GridBagLayout gblMainPanel = new GridBagLayout();
        gblMainPanel.columnWidths = new int[]{84, 345};
        gblMainPanel.rowHeights = new int[]{250, 0};
        gblMainPanel.columnWeights = new double[]{1.0, 1.0};
        gblMainPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
        mainPanel.setLayout(gblMainPanel);

        JPanel leftPanel = new JPanel();
        GridBagConstraints gbcLeftPanel = new GridBagConstraints();
        gbcLeftPanel.fill = GridBagConstraints.BOTH;
        gbcLeftPanel.gridx = 0;
        gbcLeftPanel.gridy = 0;
        mainPanel.add(leftPanel, gbcLeftPanel);
        leftPanel.setBackground(blueColor);
        GridBagLayout gblLeftPanel = new GridBagLayout();
        gblLeftPanel.columnWidths = new int[]{152, 0};
        gblLeftPanel.rowHeights = new int[]{0, 0, 0, 0};
        gblLeftPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gblLeftPanel.rowWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
        leftPanel.setLayout(gblLeftPanel);

        settingsButton = new JButton("");
        settingsButton.setToolTipText("Open the settings window");
        settingsButton.setOpaque(true);
        settingsButton.setBorder(null);
        settingsButton.setBackground(blueColor);
        settingsButton.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("settings_icon.png"))));
        settingsButton.addActionListener(e -> FenetreDeParametres.main(null));
        settingsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                settingsButton.setBackground(colorHover);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                settingsButton.setBackground(blueColor);
            }
        });
        GridBagConstraints gbcSettingsButton = new GridBagConstraints();
        gbcSettingsButton.anchor = GridBagConstraints.NORTHWEST;
        gbcSettingsButton.gridx = 0;
        gbcSettingsButton.gridy = 0;
        leftPanel.add(settingsButton, gbcSettingsButton);

        JLabel userIconImage = new JLabel("", SwingConstants.CENTER);
        userIconImage.setIcon(img);
        GridBagConstraints gbcUserIconImage = new GridBagConstraints();
        gbcUserIconImage.gridx = 0;
        gbcUserIconImage.gridy = 1;
        leftPanel.add(userIconImage, gbcUserIconImage);

        JPanel rightPanel = new JPanel();
        GridBagConstraints gbcRightPanel = new GridBagConstraints();
        gbcRightPanel.fill = GridBagConstraints.BOTH;
        gbcRightPanel.gridx = 1;
        gbcRightPanel.gridy = 0;
        mainPanel.add(rightPanel, gbcRightPanel);
        rightPanel.setBackground(Color.BLACK);
        GridBagLayout gblRightPanel = new GridBagLayout();
        gblRightPanel.columnWidths = new int[]{341, 0};
        gblRightPanel.rowHeights = new int[]{20, 0, 0, 0, 0, 0};
        gblRightPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gblRightPanel.rowWeights = new double[]{0.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
        rightPanel.setLayout(gblRightPanel);

        JLabel loginLabel = new JLabel("CONNEXION");
        loginLabel.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginLabel.setForeground(Color.WHITE);

        GridBagConstraints gbcLoginLabel = new GridBagConstraints();
        gbcLoginLabel.anchor = GridBagConstraints.SOUTH;
        gbcLoginLabel.insets = new Insets(10, 0, 5, 0);
        gbcLoginLabel.gridx = 0;
        gbcLoginLabel.gridy = 0;
        rightPanel.add(loginLabel, gbcLoginLabel);
        usernameField = new JTextField(15);
        usernameField.setText(usernameConstant);
        usernameField.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent arg0){
                if(usernameField.getText().equals(usernameConstant)){
                    usernameField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent arg0){
                if(usernameField.getText().isEmpty()){
                    usernameField.setText(usernameConstant);
                }
            }
        });
        GridBagConstraints gbcUsernameField = new GridBagConstraints();
        gbcUsernameField.insets = new Insets(0, 0, 5, 0);
        gbcUsernameField.gridx = 0;
        gbcUsernameField.gridy = 1;
        rightPanel.add(usernameField, gbcUsernameField);
        passwordField = new JPasswordField(15);
        passwordField.setText(passwordConstant);
        passwordField.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent arg0){
                if(String.valueOf(passwordField.getPassword()).equals(passwordConstant)){
                    passwordField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent arg0){
                if(String.valueOf(passwordField.getPassword()).isEmpty()){
                    passwordField.setText(passwordConstant);
                }
            }
        });
        GridBagConstraints gbcPasswordField = new GridBagConstraints();
        gbcPasswordField.insets = new Insets(0, 0, 5, 0);
        gbcPasswordField.gridx = 0;
        gbcPasswordField.gridy = 2;
        rightPanel.add(passwordField, gbcPasswordField);

        errorMessageLabel = new JLabel(" ");
        errorMessageLabel.setForeground(Color.RED);
        GridBagConstraints gbcErrorMessageLabel = new GridBagConstraints();
        gbcErrorMessageLabel.insets = new Insets(0, 0, 5, 0);
        gbcErrorMessageLabel.gridx = 0;
        gbcErrorMessageLabel.gridy = 3;
        rightPanel.add(errorMessageLabel, gbcErrorMessageLabel);

        JButton boutonConnexion = new JButton("Connexion");
        boutonConnexion.addActionListener(action -> {

            String username = usernameField.getText();
            String password = String.valueOf(passwordField.getPassword());


            if(Connexion.init("classique", ParametresBDD.getAdresse(), ParametresBDD.getUtilisateur(), ParametresBDD.getMotDePasse())){
                Utilisateur utilisateurCorrespondant = UtilisateurDAO.testerAuthentification(username, password);
                if(utilisateurCorrespondant == null){
                    errorMessageLabel.setText("Login ou mot de passe incorrect.");
                }  else if(utilisateurCorrespondant.isRestreint()) {
                    errorMessageLabel.setText("Accès au compte restreint, contactez l’administrateur.");
                } else{
                    String [] args = new String[2];
                    args[0] = String.valueOf(utilisateurCorrespondant.getIdUtilisateur());
                    frameLoginWindow.dispose();
                    FenetrePrincipale.main(args);
                }
            }
            else{
                errorMessageLabel.setText("Connexion impossible.");
            }

        });
        GridBagConstraints gbcConnectionButton = new GridBagConstraints();
        gbcConnectionButton.gridx = 0;
        gbcConnectionButton.gridy = 4;
        rightPanel.add(boutonConnexion, gbcConnectionButton);
    }
}