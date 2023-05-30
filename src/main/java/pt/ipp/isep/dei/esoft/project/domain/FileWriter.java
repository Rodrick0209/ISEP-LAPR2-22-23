package pt.ipp.isep.dei.esoft.project.domain;

/**
 * The interface File writer.
 */
public interface FileWriter {

    /**
     * Write file.
     *
     * @param email the email
     * @param pwd   the pwd
     */
    void writeFile(String email, String pwd);
}
