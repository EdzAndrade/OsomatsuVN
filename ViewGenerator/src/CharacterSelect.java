import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class CharacterSelect extends Canvas {

	  private BufferedImage img;
	  private Util util = new Util();
	  Image resizedCharacter;
	  
	  String assetDir;
	  
      public CharacterSelect() {
          try {
        	    assetDir = new File(".").getCanonicalPath()+"\\assets\\";
        		String sampleImageLocation = assetDir+"oso_naked_full.png"; //change to path of the image
        	  
              img = ImageIO.read(new File(sampleImageLocation));
              
          	ImageIcon charaAsset = new ImageIcon(sampleImageLocation);
    		 resizedCharacter  = util.scale(charaAsset, 200, 200);
              
          } catch (IOException ex) {
              ex.printStackTrace();
          }
      }
      
      public void updateCharacter(String location){
    	  
    	 ImageIcon charaAsset = new ImageIcon(assetDir+location);
 		 resizedCharacter  = util.scale(charaAsset, 200, 200);
 		 
      }
      

   /*   @Override
      public Dimension getPreferredSize() {
          return img == null ? new Dimension(200, 200) : new Dimension(img.getWidth(), img.getHeight());
      }*/

      
      @Override
      public void paint(Graphics g) {
          super.paint(g);
          
          System.out.println("repainting");
          
          if (img != null) {
              g.drawImage(resizedCharacter, 0, 0, this);
          }
      }

  
}
