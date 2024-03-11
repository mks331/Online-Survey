import javax.swing.*;
import java.awt.event.*;
import java.awt.GridLayout;

public class Rating {
    private JFrame rating = new JFrame();
    private JPanel ratingPanel;
    private JSlider slider1;
    private JTextField textField1;
    private JTextArea textArea1;
    private JButton SUBMITButton;
    private JLabel rate;

    public Rating() {
        ratingPanel = new JPanel();
        rating.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rating.setContentPane(ratingPanel);
        rating.setLayout(new GridLayout(0, 2));
        rating.setSize(400, 200);
        rating.setLocationRelativeTo(null);
        rating.setVisible(true);

        slider1 = new JSlider();
        textField1 = new JTextField();
        textArea1 = new JTextArea();
        SUBMITButton = new JButton("Submit");
        rate = new JLabel();

        ratingPanel.add(new JLabel("Name:"));
        ratingPanel.add(textField1);
        ratingPanel.add(new JLabel("Feedback:"));
        ratingPanel.add(textArea1);
        ratingPanel.add(new JLabel("Rating:"));
        ratingPanel.add(slider1);
        ratingPanel.add(rate);
        ratingPanel.add(SUBMITButton);

        slider1.setMinimum(0);
        slider1.setMaximum(5);
        slider1.setPaintTicks(true);
        slider1.setPaintLabels(true);
        slider1.setMajorTickSpacing(1);

        SUBMITButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField1.getText().isEmpty() || textArea1.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill in NAME and Feedback to submit.");
                } else {
                    // Handle the submit action without database interaction
                    handleSubmit();

                    // Show success message
                    JOptionPane.showMessageDialog(null, "Submit successful!");

                    // Clear input fields
                    textField1.setText("");
                    textArea1.setText("");
                }
            }
        });

        slider1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                rate.setText(String.valueOf(slider1.getValue()) + " Star");
            }
        });
    }

    private void handleSubmit() {
        // You can add code here to handle the submission action
        // without interacting with a database
        // For example, printing data to the console.
        System.out.println("Name: " + textField1.getText());
        System.out.println("Feedback: " + textArea1.getText());
        System.out.println("Rating: " + slider1.getValue() + " Star");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Rating());
    }
}
