package pt.ipp.isep.dei.esoft.project.ui.console;

import org.apache.commons.lang3.StringUtils;

/**
 * The type Show text ui.
 *
 * @author Paulo Maio pam@isep.ipp.pt
 */
public class ShowTextUI implements Runnable{

    private String text;

    /**
     * Instantiates a new Show text ui.
     */
    public ShowTextUI()
    {
        if (StringUtils.isBlank(text))
            throw new IllegalArgumentException("ShowTextUI does not support null or empty text");

        this.text = text;
    }
    public void run()
    {
        System.out.println("\n");
        System.out.println(this.text);
        System.out.println("\n");
    }
}
