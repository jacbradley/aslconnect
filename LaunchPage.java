import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class LaunchPage implements ActionListener{

	JFrame launch = new JFrame();
	JButton start = new JButton("Start");
	String title = new String("ASL Connect"); // name of app
	String description = new String("Quiz yourself on the American Sign Language Alphabet using this game!"); // description of how to play
	JTextField titleField = new JTextField(); // text box for title
	JTextField descriptionField = new JTextField(); // text box for description


	
	LaunchPage(){
		start.setBounds(475, 500, 250, 125);
		start.setFont(new Font("Times New Roman", Font.PLAIN, 40)); // set font, font size, make font bold
		start.setFocusable(false);
		start.addActionListener(this);
		
		titleField.setBounds(0,70,1200,50); // place where app name goes
		titleField.setFont(new Font("Times New Roman", Font.BOLD, 60)); // set font, font size, make font bold
		titleField.setBackground(new Color(206,216,199)); //set color of background
		titleField.setHorizontalAlignment(JTextField.CENTER); // center the text
		titleField.setForeground(new Color(85,117,85)); // set color of text to dark green
		titleField.setEditable(false); //cannot edit title
		titleField.setText(title); //set the string to the question

		descriptionField.setBounds(0,120,1200,50); // place where ask name goes
		descriptionField.setHorizontalAlignment(JTextField.CENTER); // center the text
		descriptionField.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		descriptionField.setEditable(false);
		descriptionField.setText(description);
		descriptionField.setBackground(new Color(206,216,199)); //set color of background
		descriptionField.setForeground(new Color(85,117,85)); // set color of text to dark green
		
		launch.add(start);
		launch.add(titleField);
		launch.add(descriptionField);
		launch.getContentPane().setBackground(new Color(206,216,199)); //set background color to light green
		launch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		launch.setSize(1200, 800); // set size of window
		launch.setLayout(null);
		launch.setVisible(true);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == start) {
			launch.dispose();
			try {
				Window matchWindow = new Window();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
}
