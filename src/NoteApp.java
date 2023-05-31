import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class NoteApp extends JFrame {
    private List<String> notes;
    private JTextArea notesTextArea;

    public NoteApp() {
        notes = new ArrayList<>();

        setTitle("Notebook");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 300);
        setLocationRelativeTo(null);

        JLabel titleLabel = new JLabel("Notebook", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));

        notesTextArea = new JTextArea();
        notesTextArea.setLineWrap(true);
        notesTextArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(notesTextArea);

        JButton addButton = new JButton("Add Note");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNote();
            }
        });

        JButton deleteButton = new JButton("Delete Note");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteNote();
            }
        });

        JButton saveButton = new JButton("Save Notes");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveNotes();
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(saveButton);

        setLayout(new BorderLayout());
        add(titleLabel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.EAST);
    }

    private void addNote() {
        String note = JOptionPane.showInputDialog(this, "Enter your note:");
        if (note != null && !note.isEmpty()) {
            notes.add(note);
            refreshNotesTextArea();
        }
    }

    private void deleteNote() {
        if (notes.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No notes available to delete.");
        } else {
            String[] noteArray = notes.toArray(new String[0]);
            String selectedNote = (String) JOptionPane.showInputDialog(this, "select a note to delete:",
                    "Delete Note", JOptionPane.PLAIN_MESSAGE, null, noteArray, noteArray[0]);
            if (selectedNote != null) {
                notes.remove(selectedNote);
                refreshNotesTextArea();
            }
        }
    }

    private void saveNotes() {
        if (notes.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No notes available to save.");
        } else {
            StringBuilder notesContent = new StringBuilder();
            for (String note : notes) {
                notesContent.append(note).append("\n");
            }
            JOptionPane.showMessageDialog(this, "Notes saved:\n" + notesContent.toString());
        }
    }

    private void refreshNotesTextArea() {
        StringBuilder notesContent = new StringBuilder();
        for (String note : notes) {
            notesContent.append(note).append("\n");
        }
        notesTextArea.setText(notesContent.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NoteApp().setVisible(true);
            }
        });
    }
}
