import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Util {

	public Util() {

	}

	public Vector<String> findImages(String path, String filter){
		Vector<String> imageFiles = new Vector<>();
		File fileDir = new File(path);

		for (File fileEntry : fileDir.listFiles()) {
			String fileName = fileEntry.getName();

			if(filter.isEmpty()&& fileName.contains("png")){
				imageFiles.add(fileName);
			}else if(filter.startsWith("no")){
				filter = filter.replace("no", "");
				if(!(fileName.contains("arms")&& fileName.contains("png"))){
					imageFiles.add(fileName);
				}
			}
			else if(fileName.contains(filter) && fileName.contains("png")){
				fileName = fileName.replace(path, "");
				imageFiles.add(fileName);
			}
		}

		return imageFiles;

	}
	
	public Vector<String> findImages(String path){
		Vector<String> imageFiles = new Vector<>();
		File fileDir = new File(path);

		for (File fileEntry : fileDir.listFiles()) {
			String fileName = fileEntry.getName();
			if(fileName.endsWith("png") && !(fileName.contains("List")||fileName.contains("list"))){
				imageFiles.add(fileName);
			}
		}

		return imageFiles;

	}

	public ImageIcon scaleImage(ImageIcon icon, int w, int h)
	{
		int nw = icon.getIconWidth();
		int nh = icon.getIconHeight();

		if(icon.getIconWidth() > w)
		{
			nw = w;
			nh = (nw * icon.getIconHeight()) / icon.getIconWidth();
		}

		if(nh > h)
		{
			nh = h;
			nw = (icon.getIconWidth() * nh) / icon.getIconHeight();
		}

		return new ImageIcon(icon.getImage().getScaledInstance(nw, nh, Image.SCALE_DEFAULT));
	}
	
	public Image scale(ImageIcon icon, int w, int h)
	{
		int nw = icon.getIconWidth();
		int nh = icon.getIconHeight();

		if(icon.getIconWidth() > w)
		{
			nw = w;
			nh = (nw * icon.getIconHeight()) / icon.getIconWidth();
		}

		if(nh > h)
		{
			nh = h;
			nw = (icon.getIconWidth() * nh) / icon.getIconHeight();
		}

		return icon.getImage().getScaledInstance(nw, nh, Image.SCALE_DEFAULT);
	}
}
