package atividadeemsala.eventos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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

public class JanelaEventos extends JFrame {

    private final List<Evento> eventos = new ArrayList<>();
    JList<Evento> lstEvento = new JList(new DefaultListModel<>());
    private final JButton criarEvento = new JButton("Cria Evento");
    private final JButton editarEvento = new JButton("Editar Evento");
    private final JButton excluirEvento = new JButton("Exclui Evento");
    private final JanelaEvento janelaEvento = new JanelaEvento();
    private final JLabel titulo = new JLabel("Eventos Cadastrados");

    public JanelaEventos() {
        super("Eventos");

        titulo.setSize(50, 20);
        lstEvento.setModel(new EventosListModel(eventos));
        add(new JScrollPane(lstEvento), BorderLayout.CENTER);
        JPanel botoes = new JPanel(new GridLayout(1, 3));
        botoes.add(criarEvento);
        botoes.add(editarEvento);
        botoes.add(excluirEvento);
        add(botoes, BorderLayout.SOUTH);
        add(titulo, BorderLayout.NORTH);

        lstEvento.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        janelaEvento.setJanelaEventos(this);
        criarEvento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaEvento.solicitaNovoEvento();
            }
        }
        );
        editarEvento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!eventos.isEmpty() && lstEvento.getSelectedValue() != null) {
                    Evento evento = lstEvento.getSelectedValue();
                    janelaEvento.solicitaEditarEvento(evento);
                } else {
                    JOptionPane.showMessageDialog(null, "Não há evento selecionado");
                }
            }
        });
        excluirEvento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!eventos.isEmpty() && lstEvento.getSelectedValue() != null) {
                    Evento evento = lstEvento.getSelectedValue();
                    removeEvento(evento);
                } else {
                    JOptionPane.showMessageDialog(null, "Não há evento selecionado");
                }
            }
        });
    }

    private boolean isValid(String text) {
        if (text.isEmpty()) {
            return false;
        }
        return true;
    }

    public void adicionaEvento(Evento a) {
        try {
            if (eventos.isEmpty()) {
                eventos.add(a);
            } else if (eventos.get(a.getCodigo()) != null) {
                eventos.remove(a.getCodigo());
                eventos.add(a.getCodigo(), a);
            }

        } catch (IndexOutOfBoundsException ex) {
            eventos.add(a);
        } finally {
            lstEvento.updateUI();
            janelaEvento.setVisible(false);
        }
    }

    public void removeEvento(Evento a) {
        eventos.remove(a);
        lstEvento.updateUI();

    }
}
