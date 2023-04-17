package wisniowa.tc.soundEngine;
import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import wisniowa.tc.Constants;

public class soundEngine {
    public static void playMusic() {

        File musicFile = new File(Constants.MUSIC_FOLDER+"Bamboleo.wav");
        try {
            AudioInputStream musicStream = AudioSystem.getAudioInputStream(musicFile);
            try {
                Clip clip = AudioSystem.getClip();
                clip.open(musicStream);
                clip.start();
            } catch (LineUnavailableException e) {
                popupException(e);
            }
        } catch (UnsupportedAudioFileException e) {
            popupException(e);
        } catch (IOException e) {
            popupException(e);
        }

    }

    public static void popupException(Exception e) {
        JOptionPane.showMessageDialog(null,
                "Sound engine exception: "+e.getMessage() );
    }

}
