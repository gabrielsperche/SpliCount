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

    opens splitec.splicountviewapp.splicount to javafx.fxml;
    exports splitec.splicountviewapp.splicount;
}