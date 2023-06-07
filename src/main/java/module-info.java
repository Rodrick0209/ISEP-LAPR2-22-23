module pt.ipp.isep.dei.esoft.project.application.controller {
    requires javafx.fxml;
    requires javafx.controls;
    requires org.apache.commons.math4.legacy;
    requires AuthLib;
    requires mail;
    requires org.apache.commons.lang3;
    requires java.logging;

    opens pt.ipp.isep.dei.esoft.project.application.controller to javafx.fxml;
    exports pt.ipp.isep.dei.esoft.project.application.controller;


}