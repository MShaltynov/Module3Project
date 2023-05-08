package com.shaltynov;

public class GameTextCreator {
    private static final String STEPZEROHEADER = "Welcome to the  quest!";
    private static final String STEPONEHEADER = " You've lost your memory. Receive a UFO call?";
    private static final String STEPONEANSWERYES = "Take a call";
    private static final String STEPONEANSWERNO = "Reject the call";
    private static final String STEPONEDEFEAT = "You rejected the call. Defeat";
    private static final String STEPTWOHEADER = "You accepted the challenge. Rising to the bridge to the captain.";
    private static final String STEPTWOANSWERYES = "Climb to the bridge";
    private static final String STEPTWOANSWERNO = "Refuse to climb the bridge";
    private static final String STEPTWODEFEAT = "You didn't negotiate. Defeat!";
    private static final String STEPTHREEHEADER = "You have climbed the bridge. Who are you";
    private static final String STEPTHREEANSWERYES = "Tell the truth";
    private static final String STEPTHREEANSWERNO = "Lie about yourself";
    private static final String STEPTHREEDEFEAT = "Your lies have been exposed. Defeat";
    private static final String STEPTHREEVICTORY = "You have been returned home. Victory";
    private static final String STARTAGAIN = "Start again";
    private String textInput;
    private String button1state;
    private String button2state;
    private String button1Visibility;
    private String button2Visibility;
    private String labelTextVisibility;
    private String textInputVisibility;
    public String getButton1text(int gameStep) {
        return switch (gameStep) {
            case 0 -> "Start quest";
            case 1 -> STEPONEANSWERYES;
            case 11 -> STARTAGAIN;
            case 2 -> STEPTWOANSWERYES;
            case 12 -> STARTAGAIN;
            case 3 -> STEPTHREEANSWERYES;
            case 13 -> STARTAGAIN;
            case 4 -> STARTAGAIN;
            default -> "error in step " + gameStep;
        };
    }

    public String getButton2text(int gameStep) {
        return switch (gameStep) {
            case 1 -> STEPONEANSWERNO;
            case 2 -> STEPTWOANSWERNO;
            case 3 -> STEPTHREEANSWERNO;
            default -> "error in step " + gameStep;
        };
    }

    public String getHeaderText(int gameStep) {
        return switch (gameStep) {
            case 0 -> STEPZEROHEADER;
            case 1 -> STEPONEHEADER;
            case 11 -> STEPONEDEFEAT;
            case 2 -> STEPTWOHEADER;
            case 12 -> STEPTWODEFEAT;
            case 3 -> STEPTHREEHEADER;
            case 13 -> STEPTHREEDEFEAT;
            case 4 -> STEPTHREEVICTORY;
            default -> "error in step " + gameStep;
        };
    }

    public String getButton1state() {
        return button1state;
    }

    public void setButton1state(String button1state) {
        this.button1state = button1state;
    }

    public String getButton2state() {
        return button2state;
    }

    public void setButton2State(String button2State) {
        this.button2state = button2State;
    }

    public String getLabelTextVisibility() {
        return labelTextVisibility;
    }

    public void setLabelTextVisibility(String labelTextVisibility) {
        this.labelTextVisibility = labelTextVisibility;
    }

    public String getTextInputVisibility() {
        return textInputVisibility;
    }

    public void setTextInputVisibility(String textInputVisibility) {
        this.textInputVisibility = textInputVisibility;
    }

    public String getButton1Visibility() {
        return "1";
    }

    public void setButton1Visibility(String button1Visibility) {
        this.button1Visibility = button2Visibility;
    }

    public String getButton2Visibility() {
        return button2Visibility;
    }

    public void setButton2Visibility(String button2Visibility) {
        this.button2Visibility = button2Visibility;
    }

}
