package wisniowa.tc;

public abstract class Constants {
    //Dimensions
    public static final int CHARACTER_IMG_WIDTH = 40;
    public static final int CHARACTER_IMG_HEIGHT = 80;
    public static final int WINDOW_HEIGHT = 400;
    public static final int WINDOW_WIDTH = 400;

    //Paths
    public static final String STATIC_FOLDER = "static/";
    public static final String IMAGE_FOLDER =
            STATIC_FOLDER + "images/";
    public static final String AUDIO_FOLDER =
            STATIC_FOLDER + "audio/";
    public static final String MUSIC_FOLDER = AUDIO_FOLDER + "music/";
    public static final String SOUNDS_FOLDER = AUDIO_FOLDER + "sounds/";

    //Math
    //You probably don't need to remove or modify these declarations
    public static final int MAX_RIGHT_POSITION =
            WINDOW_WIDTH - CHARACTER_IMG_WIDTH;
    public static final int MAX_DOWN_POSITION =
            WINDOW_HEIGHT - CHARACTER_IMG_HEIGHT;
    public static final int MAX_RIGHT_PLACE =
            MAX_RIGHT_POSITION/CHARACTER_IMG_WIDTH;
    public static final int MAX_DOWN_PLACE =
            MAX_DOWN_POSITION/CHARACTER_IMG_HEIGHT;
}
