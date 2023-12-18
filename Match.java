import java.awt.event.*;
import java.io.IOException;
import java.net.URL;
import java.awt.*;
import javax.swing.*;


public class Match implements ActionListener{
	String question = new String("What letter is this?"); // same question all the pictures
	String [] [] options = {{"A", "O", "S", "B"},{"D", "B", "H", "P"}, {"O", "C", "D", "L"}, {"D", "P", "N", "E"},{"V", "A", "E", "F"},{"P", "F", "J", "Q"},{"G", "X", "U", "W"}, {"M", "H", "Z", "L"},{"J", "A", "V", "I"}, {"K", "J", "C", "L"}, {"K", "R", "Z", "F"}, {"L", "H", "V", "O"},{"U", "E", "G", "M"}, {"T", "N", "Y", "U"}, {"E", "A", "O", "V"}, {"P", "B", "G", "H"}, {"T", "Q", "D", "S"}, {"K", "D", "R", "L"}, {"E", "P", "H", "S"}, {"N", "T", "W", "A"}, {"O", "U", "H", "F"}, {"V", "A", "B", "I"}, {"N", "R", "C", "W"}, {"P", "U", "X", "E"}, {"H", "I", "Y", "J"}, {"Z", "C", "F", "K"}};
	char[] answers = {'A', 'B', 'B', 'A', 'C', 'B', 'A', 'B', 'D', 'B', 'A', 'A', 'D', 'B', 'C', 'A', 'B', 'C', 'D', 'B', 'B', 'A', 'D', 'C', 'C', 'A'};
	char guess, answer;
	int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 , 20, 21, 22, 23, 24, 25};
	int index, correctGuesses, results;
	int totalQuestions = answers.length;
	
	JFrame frame = new JFrame(); // JFrame
	JTextField questionField = new JTextField(); // text box for question
	JButton buttonA = new JButton(); // button for option 1
	JButton buttonB = new JButton();// button for option 2
	JButton buttonC = new JButton();// button for option 3
	JButton buttonD = new JButton();// button for option 4
	JLabel answerLabelA = new JLabel(); // text for option 1
	JLabel answerLabelB = new JLabel(); // text for option 2
	JLabel answerLabelC = new JLabel(); // text for option 3
	JLabel answerLabelD = new JLabel(); // text for option 4
	JLabel imageField = new JLabel(); // place for picture to go
	JTextField numberRight = new JTextField(); // text box for number right
	JTextField percentage = new JTextField(); // text box for percent right
	JTextField numberCorrect = new JTextField(); // text box for number correct
	ImageIcon[] letters = new ImageIcon[26]; // array of image icons 
	String[] lettersString = new String[26]; // array of strings with image name
	URL[] lettersURL = new URL[26]; // array of url of imageicons


	
	public void setLetters(){
		for( int i = 0; i < lettersString.length; i++) { //loop through each letter

			lettersString[i] = new String("letters/letters" + i + ".jpg"); // make a string for each letter
            lettersURL[i] = getClass().getResource(lettersString[i]); // turn the string into a url

            if ( lettersURL[i] != null) { // if the url is not null
                 letters[i] = new ImageIcon(lettersURL[i]); // use URL to create a ImageIcon
			 } else { // if URL is null, return error message
			 	throw new RuntimeException(
			 			"Card image not found: \"" + lettersString[i] + "\"");
			 }
            //new 
            Image img = letters[i].getImage();
            Image imgScale = img.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            letters[i] = new ImageIcon(imgScale);
         
		}		
	}
	
	 public Match() throws IOException {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1200, 800); // set size of window
		frame.getContentPane().setBackground(new Color(231,236,228)); //set background color to light green
		frame.setLayout(null);
		frame.setResizable(false);
		
		questionField.setBounds(0,0,1200,50); // place where ask question goes
		questionField.setBackground(new Color(206,216,199)); //set background of text box to medium green
		questionField.setForeground(new Color(85,117,85)); // set color of text to dark green
		questionField.setFont(new Font("Times New Roman", Font.BOLD, 40)); // set font, font size, make font bold
		questionField.setHorizontalAlignment(JTextField.CENTER); // center the text
		questionField.setEditable(false);
		questionField.setText(question); //set the string to the question
		
		//button A
		buttonA.setBounds(0, 400, 600, 200); //set location on (x, y) and size
		buttonA.addActionListener(this);
		buttonA.setFocusable(false);
		buttonA.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		buttonA.setText("testing label 1");
		
		//button B
		buttonB.setBounds(600, 400, 600, 200); // set location on ( x, y) plane and size
		buttonB.addActionListener(this);
		buttonB.setFocusable(false);
		buttonB.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		buttonB.setText("testing label 2");

		
		//button c
		buttonC.setBounds(0, 600, 600, 200); // set location on ( x, y) plane and size
		buttonC.addActionListener(this);
		buttonC.setFocusable(false);
		buttonC.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		buttonC.setText("testing label 3");

		
		//button c
		buttonD.setBounds(600, 600, 600, 200); // set location on ( x, y) plane and size
		buttonD.addActionListener(this);
		buttonD.setFocusable(false);
		buttonD.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		buttonD.setText("testing label 4");

		//Number Right
		numberRight.setBounds(400, 200, 400, 200); // set location on ( x, y) plane and size
		numberRight.setOpaque(true);
		numberRight.setForeground(new Color(85,117,85));
		numberRight.setFont(new Font("Times New Roman", Font.PLAIN, 45));
		numberRight.setHorizontalAlignment(JTextField.CENTER);
		
		//Percentage
		percentage.setBounds(400, 400, 400, 200); // set location on ( x, y) plane and size
		percentage.setOpaque(true);
		percentage.setForeground(new Color(85,117,85));
		percentage.setFont(new Font("Times New Roman", Font.PLAIN, 45));
		percentage.setHorizontalAlignment(JTextField.CENTER);
		
		frame.add(questionField); // add question text to frame
		frame.add(buttonA); // add button A to frame
		frame.add(buttonB); // add button B to frame
		frame.add(buttonC);// add button C to frame
		frame.add(buttonD);// add button D to frame
		
		setLetters(); // use the instantiated letters for the match method

		imageField.setBounds(450,70, 300,300);
		imageField.setIcon(letters[index]); // set icon for the image
        imageField.setVerticalAlignment(JLabel.TOP); // set vertical alignment for image
		imageField.setHorizontalAlignment(JLabel.CENTER); //set horizontal alignment for image
        frame.add(imageField); // add picture to frame

        frame.setVisible(true);
		
		nextMatch();
	}
	
	public void nextMatch() {
		if(index >= totalQuestions) {
			results();
		}
		else {
			buttonA.setText(options[index][0]);
			buttonB.setText(options[index][1]);
			buttonC.setText(options[index][2]);
			buttonD.setText(options[index][3]);
			imageField.setIcon(letters[index]);
			imageField.setVisible(true);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		if(e.getSource()== buttonA) {
			answer = 'A';
			if (answer == answers[index]) {
				correctGuesses++;
			}
		}
		
		if(e.getSource()== buttonB) {
			answer = 'B';
			if (answer == answers[index]) {
				correctGuesses++;
			}
		}
		
		if(e.getSource()== buttonC) {
			answer = 'C';
			if (answer == answers[index]) {
				correctGuesses++;
			}
		}
		
		if(e.getSource()== buttonD) {
			answer = 'D';
			if (answer == answers[index]) {
				correctGuesses++;
			}
		}
		
		if(e.getSource() == buttonA || e.getSource() == buttonB ||e.getSource() == buttonC ||e.getSource() == buttonD) {
			index++; // increase index
			buttonA.setEnabled(true); //make button clickable again
			buttonB.setEnabled(true);
			buttonC.setEnabled(true);
			buttonD.setEnabled(true);
			nextMatch();

		}
	}
	
	public void results() {
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);

		int result = (int)(((double) correctGuesses/totalQuestions)*100); // calculate percent correct
		
		questionField.setText("Results: "); 
		buttonA.setText(" ");
		buttonB.setText(" ");
		buttonC.setText(" ");
		buttonD.setText(" ");
		
		numberRight.setText(correctGuesses + " / " + totalQuestions + " correct"); //set text for number right
		numberRight.setEditable(false);
		percentage.setText(result + "%"); //set text for percentage
		percentage.setEditable(false);
		
		frame.add(percentage); // add percentage to frame
		frame.add(numberRight); // add number right
		
	}

}
