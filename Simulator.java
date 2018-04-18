import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
public class Simulator {

	 static DateFormat formatter = new SimpleDateFormat("h:mm:ss:S");
	 static ChronoController controller = new ChronoController();
	 
//	 JTextField tf1,tf2,tf3, tf4, tf5, tf6;  
	 JLabel start, end1, end2, finish, title;
	 JButton power, prtpwr, func, swap,
	 	zero, one, two, three, four, five, six, seven, eight, nine, lb, star; 
	 JRadioButton s1, s3, s5, s7, e1, e2, e3, e4, e5, 
	 	e6, e7, e8, f2, f4, f6, f8, b1, b2, b3, b4, b5, b6, b7, b8;
	 ButtonGroup t = new ButtonGroup();
	 
	 public final static void main(String[] args) {
		 
		 Gson g = new Gson();
		 Scanner input = new Scanner(System.in); 
		 String next; 
	     String[] line;
	     new Simulator();
		
		 do {
			 System.out.print("Enter a command (\"exit\") to finish : ");
			 
			 next = input.nextLine();
	         line = next.split(" ");
	         if(next.equalsIgnoreCase("exit")) {
	        	 try (Writer w = new FileWriter("Output.txt")){
	    			 Gson gson = new GsonBuilder().create();
	    			 gson.toJson(controller.ct,w);
	    		 } catch (IOException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
	         }
	         if (line[0].equalsIgnoreCase("load")) {
	             List<String> commandLines = getCommands(line[1]);
	             for (String commandLine : commandLines) {
	                controller.processCommand(commandLine.toUpperCase());
	             }
	          }
	         else {
	        	 Date d = new Date();
	        	 next = formatter.format(d) + " " + next;
	        	 controller.processCommand(next.toUpperCase());
	         }
		 } while (!next.equalsIgnoreCase("exit"));
		 
		 
	 }
	 
	 
	 
	 
	 public static List<String> getCommands(String fileName) {
		   if(fileName == null) return new ArrayList<String>(0);
		   ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		   File file = new File(classLoader.getResource("resources/" + fileName).getFile());
		   if(! (file.exists() && file.canRead())) {
		      System.err.println("Cannot access file! Non-existent or read access restricted");
		      return new ArrayList<String>(0);
		   }

		   List<String> commandLines = new ArrayList<String>(32);
		   Scanner scanner;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		   while(scanner.hasNextLine()) {
		      commandLines.add(scanner.nextLine());
		   }

		   scanner.close();

		   return commandLines;
		}
	 
	 public Simulator(){  
		 
		 // need to do - printer text box and console text box
	        JFrame f= new JFrame();  
	        
	        s1 = new JRadioButton("1");
	        s1.setBounds(150,150,100,20);
	        s3 = new JRadioButton("3");
	        s3.setBounds(250,150,100,20);
	        s5 = new JRadioButton("5");
	        s5.setBounds(350,150,100,20);
	        s7 = new JRadioButton("7");
	        s7.setBounds(450,150,100,20);
	        t.add(s1);
	        t.add(s3);
	        t.add(s5);
	        t.add(s7);
	        
	        e1 = new JRadioButton("1");
	        e1.setBounds(150,200,100,20);
	        e3 = new JRadioButton("3");
	        e3.setBounds(250,200,100,20);
	        e5 = new JRadioButton("5");
	        e5.setBounds(350,200,100,20);
	        e7 = new JRadioButton("7");
	        e7.setBounds(450,200,100,20);
	        t.add(e1);
	        t.add(e3);
	        t.add(e5);
	        t.add(e7);
	        
	        f2 = new JRadioButton("2");
	        f2.setBounds(150,250,100,20);
	        f4 = new JRadioButton("4");
	        f4.setBounds(250,250,100,20);
	        f6 = new JRadioButton("6");
	        f6.setBounds(350,250,100,20);
	        f8 = new JRadioButton("8");
	        f8.setBounds(450,250,100,20);
	        t.add(f2);
	        t.add(f4);
	        t.add(f6);
	        t.add(f8);
	        
	        e2 = new JRadioButton("2");
	        e2.setBounds(150,300,100,20);
	        e4 = new JRadioButton("4");
	        e4.setBounds(250,300,100,20);
	        e6 = new JRadioButton("6");
	        e6.setBounds(350,300,100,20);
	        e8 = new JRadioButton("8");
	        e8.setBounds(450,300,100,20);
	        t.add(e2);
	        t.add(e4);
	        t.add(e6);
	        t.add(e8);
	        
	        title=new JLabel("Chronomotor 1009");  
	        title.setBounds(400,50,100,20);  
	        start=new JLabel("start");  
	        start.setBounds(50,150, 100,20); 
	        end1=new JLabel("enable/disable");  
	        end1.setBounds(50,200, 100,20);  
	        finish=new JLabel("finish");  
	        finish.setBounds(50,250, 100,20); 
	        end2=new JLabel("enable/disable");  
	        end2.setBounds(50,300, 100,20);
//	        l5=new JLabel("Gender");  
//	        l5.setBounds(0,250, 100,20);  
//	        l6=new JLabel("Title");  
//	        l6.setBounds(0,300, 100,20); 
	   
	         
	        power=new JButton("Power");  
	        power.setBounds(50,50,100,50);  
	        func=new JButton("Function");
	        func.setBounds(50, 350, 100, 50);
	        swap = new JButton("Swap");
	        swap.setBounds(50, 450, 100, 50);
	        prtpwr = new JButton("Printer Power");
	        prtpwr.setBounds(750, 50, 100, 50);
	        
	        zero=new JButton("0");  
	        zero.setBounds(700,300,50,50);
	        one=new JButton("1");  
	        one.setBounds(750,300,50,50); 
	        two=new JButton("2");  
	        two.setBounds(800,300,50,50); 
	        three=new JButton("3");  
	        three.setBounds(700,350,50,50); 
	        four=new JButton("4");  
	        four.setBounds(750,350,50,50);
	        five=new JButton("5");  
	        five.setBounds(800,350,50,50); 
	        six=new JButton("6");  
	        six.setBounds(700,400,50,50);
	        seven=new JButton("7");  
	        seven.setBounds(750,400,50,50); 
	        eight=new JButton("8");  
	        eight.setBounds(800,400,50,50);
	        star=new JButton("*");  
	        star.setBounds(700,450,50,50);
	        nine=new JButton("9");  
	        nine.setBounds(750,450,50,50); 
	        lb=new JButton("#");  
	        lb.setBounds(800,450,50,50); 
	        
	       // b1.addActionListener(this);  
//	        f.add(b1); 
	        f.add(e1);f.add(e3);f.add(e5);f.add(e7);f.add(s1);f.add(s3);
	        f.add(s5);f.add(s7);f.add(title);f.add(start);f.add(end1);
	        f.add(f2);f.add(f4);f.add(f6);f.add(f8);f.add(finish);
	        f.add(e2);f.add(e4);f.add(e6);f.add(e8);f.add(end2);
	        f.add(power);f.add(func);f.add(swap);f.add(prtpwr);
	        f.add(zero);f.add(one);f.add(two);f.add(three);f.add(four);f.add(five);f.add(six);
	        f.add(seven);f.add(eight);f.add(nine);f.add(star);f.add(lb);
	        f.setSize(1000,1000);  
	        f.setLayout(null);  
	        f.setVisible(true);  
	    }         
	    public void actionPerformed(ActionEvent e) {  // need to add to implement buttons

	    }  
}
