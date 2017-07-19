import java.awt.Canvas;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PaperDoll {

	
	Canvas canvas;
	String assetDir;
	
	private JFrame frame;
	Sprite sprite=null;
	
	Util util = new Util();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaperDoll window = new PaperDoll();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PaperDoll() {
		try{
			initialize();
		}catch(Exception e){
			System.out.println("ERROR: "+e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws Exception {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 579, 621);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		assetDir = new File(".").getCanonicalPath()+"\\assets\\";
		String sampleImageLocation = assetDir+"oso_naked_full.png"; //change to path of the image

		canvas = new Canvas();
		canvas.setBounds(156, 43, 277, 267);
		frame.getContentPane().add(canvas);


		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null,"Character Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(40, 381, 291, 185);
		frame.getContentPane().add(panel);

		JLabel outlabl = new JLabel("Select character");
		outlabl.setBounds(6, 16, 171, 14);
		panel.add(outlabl);

		JComboBox faceCbox = new JComboBox();
		faceCbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sprite.setFace(faceCbox.getSelectedItem().toString());
				canvas = drawThis(canvas,sprite);
			}
		});
		faceCbox.setBounds(65, 40, 171, 20);
		panel.add(faceCbox);

		JLabel label_1 = new JLabel("Face:");
		label_1.setBounds(9, 43, 46, 14);
		panel.add(label_1);

		JLabel label_2 = new JLabel("Outfit");
		label_2.setBounds(6, 80, 46, 14);
		panel.add(label_2);

		JComboBox clothesCbox = new JComboBox();
		clothesCbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sprite.setOutfit(clothesCbox.getSelectedItem().toString());
				canvas = drawThis(canvas,sprite);
			}
		});
		clothesCbox.setBounds(65, 77, 171, 20);
		panel.add(clothesCbox);

		JLabel label_3 = new JLabel("Arm:");
		label_3.setBounds(6, 105, 46, 14);
		panel.add(label_3);

		JComboBox armCbox = new JComboBox();
		armCbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sprite.setArm(armCbox.getSelectedItem().toString());
				canvas = drawThis(canvas,sprite);
			}
		});
		armCbox.setBounds(65, 108, 171, 20);
		panel.add(armCbox);

		JComboBox charaCbox = new JComboBox();
		charaCbox.setModel(new DefaultComboBoxModel(Character.values()));
		charaCbox.setSelectedIndex(0);
		charaCbox.setBounds(111, 328, 105, 20);
		frame.getContentPane().add(charaCbox);
		charaCbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String charaSelected = charaCbox.getSelectedItem().toString();
				outlabl.setText(charaSelected);

				//prepare the cboxes
				faceCbox.setModel(new DefaultComboBoxModel(util.findImages(assetDir+charaSelected+"//head//")));
				armCbox.setModel(new DefaultComboBoxModel(util.findImages(assetDir+charaSelected+"//arms//")));
				clothesCbox.setModel(new DefaultComboBoxModel(util.findImages(assetDir+charaSelected+"//body//")));
				
				sprite = new Sprite(charaSelected, faceCbox.getSelectedItem().toString(), armCbox.getSelectedItem().toString(), clothesCbox.getSelectedItem().toString(), "pos1", false);
			}
		});

		JLabel label_4 = new JLabel("Character:");
		label_4.setBounds(46, 328, 63, 14);
		frame.getContentPane().add(label_4);
	}
	
	public Canvas drawThis(Canvas temp, Sprite thisSprite){
		
		String imgLocate = assetDir+thisSprite.getCharacter()+"\\";//+"\\head\\"+faceSelected;
		
		temp.getGraphics().clearRect(0, 0, 200, 200);
		
		ImageIcon head = util.scaleImage(new ImageIcon(imgLocate+"head\\"+thisSprite.getFace()),200,200);
		ImageIcon body = util.scaleImage(new ImageIcon(imgLocate+"body\\"+thisSprite.getOutfit()),200,200);
		ImageIcon arms = util.scaleImage(new ImageIcon(imgLocate+"arms\\"+thisSprite.getArm()),200,200);

		temp.getGraphics().drawImage(body.getImage(), 10, 10, null);
		temp.getGraphics().drawImage(arms.getImage(), 10, 10, null);
		temp.getGraphics().drawImage(head.getImage(), 10, 10, null);
		
		return temp;
	}
	
	
}
