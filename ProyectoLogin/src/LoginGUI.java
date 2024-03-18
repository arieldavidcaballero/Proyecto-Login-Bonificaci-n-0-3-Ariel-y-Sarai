import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;


public class LoginGUI extends JFrame implements ActionListener {

    private JTextField usuarioField;
    private JPasswordField claveField;
    private JPanel loginPanel;
    private JPanel inicioPanel;
    private JLabel bienvenidaLabel;

    public LoginGUI() {
        super("Inicio de Sesión");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        loginPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);

        loginPanel.setBackground(new Color(179, 229, 192));

        JLabel usuarioLabel = new JLabel("Usuario:");
        loginPanel.add(usuarioLabel, gbc);

        usuarioField = new JTextField(15);
        gbc.gridx = 1;
        loginPanel.add(usuarioField, gbc);

        JLabel claveLabel = new JLabel("Clave:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        loginPanel.add(claveLabel, gbc);

        claveField = new JPasswordField(15);
        gbc.gridx = 1;
        loginPanel.add(claveField, gbc);

        JButton loginButton = new JButton("Iniciar Sesión");
        loginButton.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        loginPanel.add(loginButton, gbc);

        inicioPanel = new JPanel(new BorderLayout());
        bienvenidaLabel = new JLabel("¡Bienvenido!");
        bienvenidaLabel.setHorizontalAlignment(SwingConstants.CENTER);
        inicioPanel.add(bienvenidaLabel, BorderLayout.NORTH);

        inicioPanel.setBackground(new Color(173, 216, 230));

        JButton salirButton = new JButton("Salir");
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarSalida();
                mostrarPanelLogin();
            }
        });
        inicioPanel.add(salirButton, BorderLayout.SOUTH);

        getContentPane().add(loginPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String usuario = usuarioField.getText();
        String clave = new String(claveField.getPassword());

        if (Usuarios.validarUsuario(usuario, clave)) {
            mostrarPanelInicio(usuario);
            registrarIngreso(usuario);
        } else {
            JOptionPane.showMessageDialog(this, "Usuario o clave incorrecta", "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mostrarPanelInicio(String usuario) {
        getContentPane().remove(loginPanel);
        bienvenidaLabel.setText("¡Bienvenido, " + usuario + "!");
        getContentPane().add(inicioPanel);
        revalidate();
        repaint();
    }

    private void mostrarPanelLogin() {
        getContentPane().remove(inicioPanel);
        usuarioField.setText("");
        claveField.setText("");
        getContentPane().add(loginPanel);
        revalidate();
        repaint();
    }

    private void registrarIngreso(String usuario) {
        String ingreso = LocalDate.now() + "-" + LocalTime.now() + "-" + usuario;
        escribirTxt.escribir(ingreso);
    }

    private void registrarSalida() {
        String salida = LocalDate.now() + "-" + LocalTime.now() + "-Salida de sesión";
        escribirTxt.escribir(salida);
    }
}
