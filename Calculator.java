import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Calculator implements ActionListener{
    // =========================
    // Object & variable setup
    // =========================
    JFrame frame;
    JTextField screen = new JTextField();
    JPanel panel;
    JButton[] digit= new JButton[10];
    JButton[] functions = new JButton[10];
    double num1,num2,result=0;
    char opr;
    JButton divbutton,addbutton,minusbutton,modbutton,equalbutton;
    JButton clrbutton,delbutton,plusminusbutton,decbutton,multbutton;
    Font myFont= new Font("Monospaced", Font.BOLD, 40);
    Font myFont2 = new Font("Consolas", Font.BOLD, 22);
    Font myFont3= new Font("Segoe UI", Font.BOLD, 21);
        Calculator(){
        frame= new JFrame("Calculator");
        frame.setLayout(null); // // Using null layout to manually control component positions
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 520);
        // =========================
        // Display screen (JTextField)
        // =========================
        screen.setBounds(50, 25, 300, 50);
        screen.setHorizontalAlignment(JTextField.RIGHT);// // Text aligns to the right 
        screen.setEditable(false); // Prevent typing from keyboard
        screen.setFont(myFont);
        frame.add(screen);
        // =========================
        // Button initialization
        // =========================
        divbutton= new JButton("/");
        addbutton= new JButton("+");
        minusbutton= new JButton("-");
        modbutton= new JButton("%");
        equalbutton= new JButton("=");
        clrbutton= new JButton("clr");
        delbutton= new JButton("del");
        plusminusbutton= new JButton("+/-");
        decbutton= new JButton(".");
        multbutton= new JButton("*");
        // Store all function buttons into one array
        functions[0]=addbutton;
        functions[1]=minusbutton;
        functions[2]=multbutton;
        functions[3]=divbutton;
        functions[4]=modbutton;
        functions[5]=equalbutton;
        functions[6]=plusminusbutton;
        functions[7]=decbutton;
        functions[8]=delbutton;
        functions[9]=clrbutton;
        
        // =========================
        // Digit buttons (0–9)
        // =========================
        for(int i=0;i<10;i++){ 
            digit[i] = new JButton(String.valueOf(i));
            digit[i].addActionListener(this);
            digit[i].setFocusable(false);
            digit[i].setBackground(Color.WHITE);
            digit[i].setForeground(Color.GREEN);
            digit[i].setFont(myFont2);
            digit[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        }

        for(int i=0;i<10;i++){
            functions[i].addActionListener(this);
            functions[i].setFocusable(false); // // Remove focus border
            functions[i].setFont(myFont3);
            if (functions[i].getText().equals("=") || functions[i].getText().equals("del") || functions[i].getText().equals("clr"))
            {
                    functions[i].setBackground(new Color(255, 127, 0));
                    functions[i].setForeground(Color.white);
                    functions[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
                    
            }
            else{
                functions[i].setBackground(Color.BLACK);
                functions[i].setForeground(Color.blue);
                functions[i].setBorder(BorderFactory.createLineBorder(Color.white, 2));
            }
        }

        // =========================
        // Button panel (GridLayout)
        // =========================
        panel = new JPanel();
        panel.setBounds(25, 100, 350, 350);
        panel.setBackground(Color.GRAY);
        panel.setLayout(new GridLayout (5,4,10,10));

        panel.add(clrbutton);
        panel.add(delbutton);
        panel.add(plusminusbutton);
        panel.add(modbutton);

        panel.add(digit[1]);
        panel.add(digit[2]);
        panel.add(digit[3]);
        panel.add(multbutton);

        panel.add(digit[4]);
        panel.add(digit[5]);
        panel.add(digit[6]);
        panel.add(divbutton);

        panel.add(digit[7]);
        panel.add(digit[8]);
        panel.add(digit[9]);
        panel.add(addbutton);

        panel.add(decbutton);
        panel.add(digit[0]);
        panel.add(minusbutton);
        panel.add(equalbutton);

        frame.add(panel);
        frame.setVisible(true);
    }
    public static void main(String[] args){
        Calculator calculator = new Calculator();
        
    }

    // =========================
    // Button event handling
    // =========================
@Override
	public void actionPerformed(ActionEvent e) {
        // Handle digit buttons
        for(int i=0;i<10;i++){
            if(e.getSource()==digit[i]){
                screen.setText(screen.getText().concat(String.valueOf(i)));
            }
        }
        // Operators
        if(e.getSource()==addbutton){
            try{
                num1=Double.parseDouble(screen.getText());
                opr ='+';
                screen.setText("");
                } 
            catch(NumberFormatException ex)
            {
                screen.setText("Error");
            }
        }
        if(e.getSource()==minusbutton){
            try{
                num1=Double.parseDouble(screen.getText());
                opr ='-';
                screen.setText("");
            }
            catch(NumberFormatException ex)
            {
                screen.setText("Error");
            }
        }    
        if(e.getSource()==divbutton){
            try{
                num1=Double.parseDouble(screen.getText());
                opr ='/';
                screen.setText("");
            }
            catch(NumberFormatException ex)
            {
                screen.setText("Error");
            }
        }
        if(e.getSource()==multbutton){
            try{
                num1=Double.parseDouble(screen.getText());
                opr ='*';
                screen.setText("");
                }
            catch(NumberFormatException ex)
            {
                screen.setText("Error");
            }    
        }
        if(e.getSource()==modbutton){
            try{
                num1=Double.parseDouble(screen.getText());
                opr ='%';
                screen.setText("");
                }
            catch(NumberFormatException ex)
            {
                screen.setText("Error");
            }
        }
        
        // Decimal point (only one allowed)
        if(e.getSource() == decbutton){
            if(!screen.getText().contains(".")){  // 
                screen.setText(screen.getText() + ".");
            }
        }
        // Delete last digit
        if(e.getSource() == delbutton){
            String text = screen.getText();
            if(!text.isEmpty()){ // Αν κειμενο δεν ειναι αδειο
                screen.setText(text.substring(0, text.length() - 1)); //  Αφέρεσαι το τελευταίο ψηφίο
            }
        }
        // Clear screen
        if(e.getSource()==clrbutton){
            screen.setText("");
        }
         // Calculate result
        if(e.getSource()==equalbutton){
            try{
                num2=Double.parseDouble(screen.getText());
                    switch(opr){
                    case'+':
                        result=num1+num2;
                        break;
                    case'-':
                        result=num1-num2;
                        break;
                    case'*':
                        result=num1*num2;
                        break;
                    case'/':
                        if(num2 == 0){
                        screen.setText("Error");
                        return;
                        }
                        result = num1 / num2;
                        break;
                    case'%':
                        result=num1%num2;
                        break;
                }
                // Display integer results without ".0"
                if(result % 1 == 0){ 
                    screen.setText(String.valueOf((int) result));
                }
                else {
                    screen.setText(String.valueOf(result));
                }
                // Store result to continue calculations
                num1=result; 
            }
            catch(NumberFormatException ex)
            {
                screen.setText("Error");
            }
            
        }
    }
}
