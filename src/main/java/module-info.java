module pt.ipp.isep.dei.esoft.project.application.controller {
    requires AuthLib;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.controls;
    requires org.apache.commons.lang3;
    requires java.logging;
    requires java.desktop;
    requires mail;
    requires org.apache.commons.math4.legacy;
    exports pt.ipp.isep.dei.esoft.project.application.controller;
    opens pt.ipp.isep.dei.esoft.project.application.controller to javafx.fxml;
    exports pt.ipp.isep.dei.esoft.project.ui.console;
    opens pt.ipp.isep.dei.esoft.project.ui.console to javafx.fxml;


}