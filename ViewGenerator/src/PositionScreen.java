import java.awt.Canvas;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.JToggleButton;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
@SuppressWarnings("rawtypes")
public class PositionScreen { 

	private JFrame frame;
	
	Canvas fakeScreen;
	JPanel mainPanel;
	JPanel charDetailsSelect;
	JPanel clickPanel;

	JLabel lblpos;
	JLabel outJLabel;
	JLabel lblFace;
	JLabel lblOutfit;
	JLabel lblArm;
	JLabel lblCharacter;
	JLabel outlabl;
	JLabel charSelect;
	JLabel labelPos;
	
	JLabel clickFace;
	JLabel clickArm;
	JLabel clickOutfit;
	JLabel clickFade;
	JLabel clickCharacter;
	JLabel clickpos;
	

	JCheckBox fadeChcbx;
	JCheckBox hideChcnx;

	JButton showChara;

	JComboBox armCbox;
	JComboBox faceBox;
	JComboBox charaCbox;
	JComboBox clothesCbox;
	JComboBox faceCbox;
	JComboBox posCbox;

	JButton btnClear;
	JButton btnGenerate;

	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try {
						PositionScreen window = new PositionScreen();
						window.frame.setVisible(true);
					} 
				catch (Exception e) 
					{
						e.printStackTrace();
					}
			}
		}
		);
	}


	public PositionScreen() {
		initialize();
	}

	@SuppressWarnings("unchecked")
	private void initialize() {
		Util util = new Util();
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 730, 441);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		String sampleImageLocation = "C:\\Users\\user\\Desktop\\pad\\Game\\assets\\oso_naked_full.png"; //change to path of the image
		
		charSelect = new JLabel("");
		charSelect.setBounds(19, 26, 168, 209);
		charSelect.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon charaAsset = new ImageIcon(sampleImageLocation);
		ImageIcon resizedCharacter  = util.scaleImage(charaAsset, 200, 200);
		frame.getContentPane().setLayout(null);


		charSelect.setIcon(resizedCharacter);
		frame.getContentPane().add(charSelect);

		fakeScreen = new Canvas();
		fakeScreen.setBackground(new Color(204, 255, 204));
		fakeScreen.setBounds(253, 10, 444, 249);
		frame.getContentPane().add(fakeScreen);

		charDetailsSelect = new JPanel();
		charDetailsSelect.setBorder(new TitledBorder(null,"Character Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		charDetailsSelect.setBounds(19, 277, 472, 118);
		frame.getContentPane().add(charDetailsSelect);
		charDetailsSelect.setLayout(null);
		

		outlabl = new JLabel("Select character");
		outlabl.setBounds(6, 16, 171, 14);
		charDetailsSelect.add(outlabl);
		
		faceCbox = new JComboBox();
		faceCbox.setModel(new DefaultComboBoxModel(Face.values()));
		faceCbox.setSelectedIndex(0);
		faceCbox.setBounds(65, 40, 99, 20);
		charDetailsSelect.add(faceCbox);
		
		lblFace = new JLabel("Face:");
		lblFace.setBounds(9, 43, 46, 14);
		charDetailsSelect.add(lblFace);
		
		lblOutfit = new JLabel("Outfit");
		lblOutfit.setBounds(6, 80, 46, 14);
		charDetailsSelect.add(lblOutfit);
		
		clothesCbox = new JComboBox();
		clothesCbox.setModel(new DefaultComboBoxModel(Outfit.values()));
		clothesCbox.setSelectedIndex(0);
		clothesCbox.setBounds(65, 77, 99, 20);
		charDetailsSelect.add(clothesCbox);
		
		lblArm = new JLabel("Arm:");
		lblArm.setBounds(204, 43, 46, 14);
		charDetailsSelect.add(lblArm);
		
		armCbox = new JComboBox();
		armCbox.setModel(new DefaultComboBoxModel(Arm.values()));
		armCbox.setSelectedIndex(0);
		armCbox.setBounds(250, 40, 99, 20);
		
		charDetailsSelect.add(armCbox);
		
		fadeChcbx = new JCheckBox("Fade On");
		fadeChcbx.setBounds(370, 60, 97, 23);
		charDetailsSelect.add(fadeChcbx);
		
		hideChcnx = new JCheckBox("Hide Pos");
		hideChcnx.setBounds(370, 30, 97, 23);
		charDetailsSelect.add(hideChcnx);
		
		
		labelPos = new JLabel("Pos:");
		labelPos.setBounds(204, 75, 97, 20);
		charDetailsSelect.add(labelPos);
		
		posCbox = new JComboBox();
		posCbox.setModel(new DefaultComboBoxModel(position.values()));
		posCbox.setSelectedIndex(0);
		posCbox.setBounds(250, 75, 89, 23);
		charDetailsSelect.add(posCbox);
		
		showChara = new JButton("Add");
		showChara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		showChara.setBounds(360, 85, 89, 23);
		//showChara.setBounds(x, y, width, height);
		charDetailsSelect.add(showChara);

		lblCharacter = new JLabel("Character:");
		lblCharacter.setBounds(29, 246, 63, 14);
		frame.getContentPane().add(lblCharacter);

		
		charaCbox = new JComboBox();
		charaCbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String charaSelected = charaCbox.getSelectedItem().toString();
				outlabl.setText(charaSelected);
				
				
			}
		});
		
		lblCharacter.setLabelFor(charaCbox);

		charaCbox.setModel(new DefaultComboBoxModel(Character.values()));
		charaCbox.setSelectedIndex(0);
		charaCbox.setBounds(94, 246, 105, 20);
		frame.getContentPane().add(charaCbox);

		
		
		
		clickPanel = new JPanel();
		clickPanel.setBorder(new TitledBorder(null,"Character Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		clickPanel.setBounds(6, 16, 150, 200);
		frame.getContentPane().add(clickPanel);
		clickPanel.setLayout(null);
		
		
		clickCharacter = new JLabel("Character:");
		clickCharacter.setBounds(6, 16, 150, 14);
		clickPanel.add(clickCharacter);
		
		clickArm = new JLabel("Arm:");
		clickArm.setBounds(6, 35, 150, 14);
		clickPanel.add(clickArm);
		
		clickFace = new JLabel("Face:");
		clickFace.setBounds(6, 54, 150, 14);
		clickPanel.add(clickFace);
		
		clickFade = new JLabel("Fade:");
		clickFade.setBounds(6, 73, 150, 14);
		clickPanel.add(clickFade);
		
		clickOutfit = new JLabel("Outfit:");
		clickOutfit.setBounds(6, 92, 150, 14);
		clickPanel.add(clickOutfit);
		
		clickpos = new JLabel("Pos:");
		clickpos.setBounds(6, 111, 150, 14);
		clickPanel.add(clickpos);
		
		
		
		
		
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(555, 277, 96, 35);
		frame.getContentPane().add(btnClear);
		
		JButton btnGenerate = new JButton("Generate Scene");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//some action
			}
		});
		btnGenerate.setBounds(555, 323, 150, 59);
		frame.getContentPane().add(btnGenerate);

		

	}
}
