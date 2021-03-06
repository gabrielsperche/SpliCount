module splitec.splicountviewapp.splicount {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.net.http;
    requires com.fasterxml.jackson.databind;
    requires org.mongodb.bson;

    opens splitec.splicountviewapp.splicount to javafx.fxml;
    opens entities to javafx.base, com.fasterxml.jackson.databind;
    exports splitec.splicountviewapp.splicount;
}