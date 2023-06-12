module pt.ipp.isep.dei.esoft.project {
    requires javafx.controls;
    requires javafx.fxml;
    requires AuthLib;
    requires org.apache.commons.lang3;
    requires java.desktop;
    requires java.sql;

    exports pt.ipp.isep.dei.esoft.project.ui;
    exports pt.ipp.isep.dei.esoft.project.application.controller.authorization;
    requires org.apache.commons.math4.core;
    requires org.apache.commons.math4.neuralnet;
    requires org.apache.commons.math4.transform;
    requires org.apache.commons.math4.legacy;
    requires org.apache.commons.math4.legacy.core;
    requires org.apache.commons.math4.legacy.exception;
    requires mail;

    opens pt.ipp.isep.dei.esoft.project.application.controller.authorization;

    opens fxml to javafx.fxml;
    exports pt.ipp.isep.dei.esoft.project.ui.gui;
    opens pt.ipp.isep.dei.esoft.project.ui.gui to javafx.fxml;
    opens pt.ipp.isep.dei.esoft.project.ui.console to javafx.graphics;
    opens pt.ipp.isep.dei.esoft.project.application.controller;


}