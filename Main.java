import javax.swing.JFrame;


public class Main {

	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setBounds(10, 10, 500, 500);
		window.setTitle("");
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(new Gameplay());
		window.setVisible(true);

	}

}
