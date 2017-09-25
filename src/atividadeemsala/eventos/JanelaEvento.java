package atividadeemsala.eventos;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JanelaEvento extends JFrame {

    private final JLabel lblLongitude = new JLabel("Longitude");
    private final JLabel lblCodigo = new JLabel("Código");
    private final JLabel lblLatitude = new JLabel("Latitude");
    private final JLabel lblDescricao = new JLabel("Descrição");
    private final JLabel lblDataHora = new JLabel("Data e Hora");
    private final JTextField txtLongitude = new JTextField();
    private final JTextField txtCodigo = new JTextField();
    private final JTextField txtLatitude = new JTextField();
    private final JTextField txtDescricao = new JTextField();
    private final JTextField txtDataHora = new JTextField();
    private final JButton Salvar = new JButton("Salvar");
    private final JButton Cancelar = new JButton("Cancelar");
    private JanelaEventos janelaEventos;

    public JanelaEventos getJanelaEventos() {
        return janelaEventos;
    }

    public void setJanelaEventos(JanelaEventos janelaEventos) {
        this.janelaEventos = janelaEventos;
    }

    public JanelaEvento() {
        super("Evento");
        setMinimumSize(new Dimension(300, 200));
        JPanel botoes = new JPanel(new GridLayout(1, 2));
        botoes.add(Salvar);
        botoes.add(Cancelar);
        add(botoes, BorderLayout.SOUTH);
        JPanel pnlCodigo = new JPanel(new GridLayout(1, 2));
        pnlCodigo.add(lblCodigo);
        pnlCodigo.add(txtCodigo);
        JPanel pnlLong = new JPanel(new GridLayout(1, 2));
        pnlLong.add(lblLongitude);
        pnlLong.add(txtLongitude);

        JPanel pnlLat = new JPanel(new GridLayout(1, 2));
        pnlLat.add(lblLatitude);
        pnlLat.add(txtLatitude);
        JPanel pnlDesc = new JPanel(new GridLayout(1, 2));
        pnlDesc.add(lblDescricao);
        pnlDesc.add(txtDescricao);
        JPanel pnlData = new JPanel(new GridLayout(1, 2));
        pnlData.add(lblDataHora);
        pnlData.add(txtDataHora);
        JPanel formulario = new JPanel(new GridLayout(5, 1));
        formulario.add(pnlCodigo);
        formulario.add(pnlDesc);
        formulario.add(pnlLong);
        formulario.add(pnlLat);
        formulario.add(pnlData);
        add(formulario, BorderLayout.NORTH);
        Salvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double longitude, latitude;
                String descricao, dataHora;
                int cod;
                if (isValid(txtLongitude.getText()) && isValid(txtLatitude.getText()) && isValid(txtDescricao.getText()) && isValid(txtDataHora.getText())) {
                    try {
                        cod = Integer.parseInt(txtCodigo.getText());
                        longitude = Double.parseDouble(txtLongitude.getText());
                        latitude = Double.parseDouble(txtLatitude.getText());
                        descricao = txtDescricao.getText();
                        dataHora = txtDataHora.getText();
                        Evento evento = new Evento(cod, descricao, dataHora, longitude, latitude);
                        janelaEventos.adicionaEvento(evento);

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Formato Inválido", "ERRO", ERROR);

                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Campo Vazio", "Advertência", NORMAL);
                }

            }
        });
        Cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }

    private boolean isValid(String text) {
        if (text.isEmpty()) {
            return false;
        }
        return true;
    }

    public void solicitaNovoEvento() {
        setLocationRelativeTo(null);
        setVisible(true);
        txtLongitude.setText("");
        txtLatitude.setText("");
        txtDescricao.setText("");
        txtDataHora.setText("");
        txtCodigo.setText(Integer.toString(Evento.gerarCodigo()));
        txtCodigo.setEnabled(false);
        txtDescricao.requestFocus();
    }

    public void solicitaEditarEvento(Evento evento) {
        setLocationRelativeTo(null);
        setVisible(true);
        txtLongitude.setText(Double.toString(evento.getLongitude()));
        txtLatitude.setText(Double.toString(evento.getLatitude()));
        txtDescricao.setText(evento.getDescricao());
        txtDataHora.setText(evento.getDatahora());
        txtCodigo.setText(Integer.toString(evento.getCodigo()));
        txtDescricao.requestFocus();

    }
}
