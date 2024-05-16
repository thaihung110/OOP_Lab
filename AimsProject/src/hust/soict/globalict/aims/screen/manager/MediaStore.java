package hust.soict.globalict.aims.screen.manager;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hust.soict.globalict.aims.disc.Playable;
import hust.soict.globalict.aims.disc.Track;
import hust.soict.globalict.aims.disc.CompactDisc.CompactDisc;
import hust.soict.globalict.aims.disc.DigitalVideoDisc.DigitalVideoDisc;
import hust.soict.globalict.aims.store.Media;

	public class MediaStore extends JPanel {
		private Media media;
		
		public MediaStore(Media media) {
			this.media = media;
			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			
			JLabel title = new JLabel(media.getTitle());
			title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
			title.setAlignmentX(CENTER_ALIGNMENT);
			
			JLabel cost = new JLabel("" + media.getCost() + "$");
			cost.setAlignmentX(CENTER_ALIGNMENT);
			
			JPanel container = new JPanel();
			container.setLayout(new FlowLayout(FlowLayout.CENTER));
			
			if (media instanceof Playable) {
				JButton playButton = new JButton("Play");
				playButton.addActionListener(e -> {
	               
	                // Create a JDialog
	                JDialog dialog = new JDialog();
	                dialog.setTitle("Playing Media");

	                // Add a label to the JDialog
	                
	                String playString = "<html>";
	              //dvd case
	              if (media instanceof DigitalVideoDisc) {
	                  DigitalVideoDisc dvd = (DigitalVideoDisc) media;
	                  playString += "Playing DVD: " + dvd.getTitle() + "<br>" + "DVD length: " + dvd.getLength() + "<br>";
	              }

	              // cd case
	              else {
	                  CompactDisc cd = (CompactDisc) media;
	                  playString += "Playing CD: " + cd.getTitle() + "<br><br>";
	                  for (int i = 0; i < cd.tracks.size(); i++) {
	                      Track track = cd.tracks.get(i);
	                      playString += "Playing track: " + track.getTitle() + "<br>" + "Track length: " + track.getLength() + "<br><br>";
	                  } 
	              }
	              playString += "</html>";

	              JLabel label = new JLabel(playString);
	              dialog.getContentPane().add(label);


	                // Set the size of the JDialog
	                dialog.setSize(300, 200);

	                // Make the JDialog modal
	                dialog.setModal(true);

	                // Show the JDialog
	                dialog.setVisible(true);
	            });
				container.add(playButton);
			}
			
			this.add(Box.createVerticalGlue());
			this.add(title);
			this.add(cost);
			this.add(Box.createVerticalGlue());
			this.add(container);
			
			this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		}
	}
