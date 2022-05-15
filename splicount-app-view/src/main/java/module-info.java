module splicount.viewapp.splicountappview {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens splicount.viewapp.splicountappview to javafx.fxml;
    exports splicount.viewapp.splicountappview;
}