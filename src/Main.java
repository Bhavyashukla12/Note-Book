import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    private static List<String> notes = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Note App Menu:");
            System.out.println("1. Add a note");
            System.out.println("2. Edit a note");
            System.out.println("3. Delete a note");
            System.out.println("4. View all notes");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the new line character

            switch (choice) {
                case 1:
                    addNote();
                    break;
                case 2:
                    editNote();
                    break;
                case 3:
                    deleteNote();
                    break;
                case 4:
                    viewNotes();
                    break;
                case 5:
                    isRunning = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addNote() {
        System.out.print("Enter your note: ");
        String note = scanner.nextLine();
        notes.add(note);
        System.out.println("Note added successfully!");
    }

    private static void editNote() {
        if (notes.isEmpty()) {
            System.out.println("No notes available to edit.");
            return;
        }

        System.out.println("Select a note to edit:");
        for (int i = 0; i < notes.size(); i++) {
            System.out.println((i + 1) + ". " + notes.get(i));
        }

        System.out.print("Enter the note number: ");
        int noteNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the new line character

        if (noteNumber >= 1 && noteNumber <= notes.size()) {
            System.out.print("Enter your updated note: ");
            String updatedNote = scanner.nextLine();
            notes.set(noteNumber - 1, updatedNote);
            System.out.println("Note updated successfully!");
        } else {
            System.out.println("Invalid note number.");
        }
    }

    private static void deleteNote() {
        if (notes.isEmpty()) {
            System.out.println("No notes available to delete.");
            return;
        }

        System.out.println("Select a note to delete:");
        for (int i = 0; i < notes.size(); i++) {
            System.out.println((i + 1) + ". " + notes.get(i));
        }

        System.out.print("Enter the note number: ");
        int noteNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the new line character

        if (noteNumber >= 1 && noteNumber <= notes.size()) {
            notes.remove(noteNumber - 1);
            System.out.println("Note deleted successfully!");
        } else {
            System.out.println("Invalid note number.");
        }
    }

    private static void viewNotes() {
        if (notes.isEmpty()) {
            System.out.println("No notes available.");
            return;
        }

        System.out.println("Your notes:");
        for (int i = 0; i < notes.size(); i++) {
            System.out.println((i + 1) + ". " + notes.get(i));
        }
    }
}