import java.awt.Canvas;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class GenerateMe {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenerateMe window = new GenerateMe();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public GenerateMe() {
		try{
			initialize();
		}catch(Exception e){
			System.out.println("ERROR");
		}
	}

	private void initialize() throws Exception {
		Util util = new Util();
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 813, 520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		String assetDir = new File(".").getCanonicalPath()+"\\assets\\";
		String sampleImageLocation = assetDir+"oso_naked_full.png"; //change to path of the image

		JLabel charSelect = new JLabel("");
		charSelect.setBounds(19, 26, 168, 209);
		charSelect.setHorizontalAlignment(SwingConstants.CENTER);
		//ImageIcon charaAsset = new ImageIcon(sampleImageLocation);

		//ImageIcon charaAsset = new ImageIcon(frame.getClass().getResource(sampleImageLocation));
		ImageIcon charaAsset = new ImageIcon(sampleImageLocation);
		ImageIcon resizedCharacter  = util.scaleImage(charaAsset, 200, 200);


		frame.getContentPane().setLayout(null);


		charSelect.setIcon(resizedCharacter);
		frame.getContentPane().add(charSelect);

		Canvas fakeScreen = new Canvas();
		fakeScreen.setBackground(new Color(204, 255, 204));
		fakeScreen.setBounds(559, 10, 189, 249);
		frame.getContentPane().add(fakeScreen);
		

		CharacterSelect designChara = new CharacterSelect();
		designChara.setBackground(UIManager.getColor("CheckBox.light"));
		designChara.setBounds(283, 26, 230, 221);
		frame.getContentPane().add(designChara);

		JPanel charDetailsSelect = new JPanel();
		charDetailsSelect.setBorder(new TitledBorder(null,"Character Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		charDetailsSelect.setBounds(19, 277, 388, 185);
		frame.getContentPane().add(charDetailsSelect);
		charDetailsSelect.setLayout(null);


		JLabel outlabl = new JLabel("Select character");
		outlabl.setBounds(6, 16, 171, 14);
		charDetailsSelect.add(outlabl);

		JComboBox faceCbox = new JComboBox();
		faceCbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String faceSelected = faceCbox.getSelectedItem().toString();
				String imgLocate = assetDir+outlabl.getText()+"\\head\\"+faceSelected;
				System.out.println(imgLocate);
				designChara.updateCharacter(imgLocate);
				designChara.repaint();
			}
		});
		faceCbox.setBounds(65, 40, 171, 20);
		charDetailsSelect.add(faceCbox);

		JLabel lblFace = new JLabel("Face:");
		lblFace.setBounds(9, 43, 46, 14);
		charDetailsSelect.add(lblFace);

		JLabel lblOutfit = new JLabel("Outfit");
		lblOutfit.setBounds(6, 80, 46, 14);
		charDetailsSelect.add(lblOutfit);

		JComboBox clothesCbox = new JComboBox();
		clothesCbox.setBounds(65, 77, 171, 20);
		charDetailsSelect.add(clothesCbox);

		JLabel lblArm = new JLabel("Arm:");
		lblArm.setBounds(6, 105, 46, 14);
		charDetailsSelect.add(lblArm);

		JComboBox armCbox = new JComboBox();
		armCbox.setBounds(65, 108, 171, 20);
		charDetailsSelect.add(armCbox);

		JCheckBox fadeChcbx = new JCheckBox("Fade On");
		fadeChcbx.setBounds(261, 90, 97, 23);
		charDetailsSelect.add(fadeChcbx);
		
		JCheckBox hideChcnx;
		hideChcnx = new JCheckBox("Hide Pos");
		hideChcnx.setBounds(261, 53, 97, 23);
		charDetailsSelect.add(hideChcnx);
		
		
		JLabel lblpos;
		JLabel labelPos;
		JComboBox posCbox;
		
		labelPos = new JLabel("Pos:");
		labelPos.setBounds(6, 140, 97, 20);
		charDetailsSelect.add(labelPos);
		
		posCbox = new JComboBox();
		posCbox.setModel(new DefaultComboBoxModel(position.values()));
		posCbox.setSelectedIndex(0);
		posCbox.setBounds(65, 139, 171, 23);
		charDetailsSelect.add(posCbox);
		



		
		JLabel lblCharacter = new JLabel("Character:");
		lblCharacter.setBounds(29, 246, 63, 14);
		frame.getContentPane().add(lblCharacter);
		

		JComboBox charaCbox = new JComboBox();
		charaCbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String charaSelected = charaCbox.getSelectedItem().toString();
				outlabl.setText(charaSelected);
				
				//prepare the cboxes
				armCbox.setModel(new DefaultComboBoxModel(util.findImages(assetDir+charaSelected,"arms")));
				faceCbox.setModel(new DefaultComboBoxModel(util.findImages(assetDir+charaSelected+"//head//","")));
				clothesCbox.setModel(new DefaultComboBoxModel(util.findImages(assetDir+charaSelected,"noarms")));
			}
		});

		lblCharacter.setLabelFor(charaCbox);

		charaCbox.setModel(new DefaultComboBoxModel(Character.values()));
		charaCbox.setSelectedIndex(0);
		charaCbox.setBounds(94, 246, 105, 20);
		frame.getContentPane().add(charaCbox);

		
		JLabel clickFace;
		JLabel clickArm;
		JLabel clickOutfit;
		JLabel clickFade;
		JLabel clickCharacter;
		JLabel clickpos;
		JPanel clickPanel;
		
		clickPanel = new JPanel();
		clickPanel.setBorder(new TitledBorder(null,"Selected Character", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		clickPanel.setBounds(417, 277, 165, 174);
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

		JButton showChara = new JButton("Add");
		showChara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		showChara.setBounds(261, 137, 89, 23);
		//showChara.setBounds(x, y, width, height);
		charDetailsSelect.add(showChara);

		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(634, 277, 96, 35);
		frame.getContentPane().add(btnClear);

		JButton btnGenerate = new JButton("Generate");
		btnGenerate.setBounds(625, 323, 105, 59);
		frame.getContentPane().add(btnGenerate);
		


	}
}
