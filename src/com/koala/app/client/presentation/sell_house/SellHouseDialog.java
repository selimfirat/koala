package com.koala.app.client.presentation.sell_house;

import com.koala.app.client.presentation.StageUtils;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import org.controlsfx.dialog.Wizard;
import org.controlsfx.dialog.WizardPane;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

/**
 * Created by mrsfy on 19-Dec-16.
 */
public class SellHouseDialog extends Wizard {

    private ObservableList<String> numberOfRoomsOptions = FXCollections.observableArrayList(
            "Studio (1+0)",
            "1+1",
            "2+1",
            "3+1",
            "4+1",
            "4+2",
            "5+1",
            "5+2",
            "6+1",
            "6+2"
    );

    private ObservableList<String> buildingAgeOptions = FXCollections.observableArrayList(
            "0",
            "1",
            "2",
            "3",
            "4",
            "5",
            "6-10",
            "11-15",
            "16-20",
            "21-25",
            "26-30",
            "31+"
    );

    private ObservableList<String> numberOfBathroomsOptions = FXCollections.observableArrayList(
            "None",
            "1",
            "2",
            "3",
            "4+"
    );

    private ObservableList<String> currentFloorOptions = FXCollections.observableArrayList(
            "0",
            "1",
            "2",
            "3",
            "4",
            "5",
            "6+"
    );

    private ObservableList<String> totalFloorOptions = FXCollections.observableArrayList(
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8"
    );

    public SellHouseDialog(Object owner) {
        super(owner);
        setTitle("Sell House");

        setFlow(new LinearFlow(
                page1(),
                page2()
        ));

    }

    private WizardPane page1() {
        return new WizardPane() {

            ValidationSupport vs = new ValidationSupport();

            {

                int row = 0;
                GridPane grid = new GridPane();
                grid.setVgap(10);
                grid.setHgap(10);

                grid.add(new Label("Title:"), 0, row);
                TextField title = createTextField("title");
                grid.add(title, 1, row++);

                grid.add(new Label("Size (m²):"), 0, row);
                TextField size = createTextField("size");
                grid.add(size, 1, row++);

                grid.add(new Label("Number of Rooms:"), 0, row);
                ComboBox<String> numberOfRooms = createComboBox("numberOfRooms", numberOfRoomsOptions);
                grid.add(numberOfRooms, 1, row++);

                grid.add(new Label("Number of Bathrooms"), 0, row);
                ComboBox<String> numberOfBathrooms = createComboBox("numberOfBathrooms", numberOfBathroomsOptions);
                grid.add(numberOfBathrooms, 1, row++);

                grid.add(new Label("Building Age"), 0, row);
                ComboBox<String> buildingAge = createComboBox("buildingAge", buildingAgeOptions);
                grid.add(buildingAge, 1, row++);

                grid.add(new Label("Current Floor"), 0, row);
                ComboBox<String> currentFloor = createComboBox("currentFloor", currentFloorOptions);
                grid.add(currentFloor, 1, row++);

                grid.add(new Label("Total Floor"), 0, row);
                ComboBox<String> totalFloor = createComboBox("totalFloor", totalFloorOptions);
                grid.add(totalFloor, 1, row++);

                grid.add(new Label("Is Furnished"), 0, row);
                CheckBox isFurnished = createCheckBox("isFurnished");
                grid.add(isFurnished, 1, row++);

                Platform.runLater(() -> {
                    vs.registerValidator(title, Validator.createEmptyValidator("Please enter the title!"));
                    vs.registerValidator(size, Validator.createRegexValidator("Size must be an integer", "[0-9]+", null));
                });

                setContent(grid);
            }

            @Override
            public void onEnteringPage(Wizard wizard) {
                wizard.invalidProperty().unbind();
                wizard.invalidProperty().bind(vs.invalidProperty());
            }

        };
    }

    private WizardPane page2() {
        return new WizardPane() {
            ValidationSupport vs = new ValidationSupport();
            {
                int row = 0;
                GridPane grid = new GridPane();
                grid.setVgap(10);
                grid.setHgap(10);

                grid.add(new Label("Price (TL):"), 0, row);
                TextField price = createTextField("price");
                price.setPrefWidth(100);

                grid.add(price, 1, row++);

                Platform.runLater(() -> {
                    vs.registerValidator(price, Validator.createRegexValidator("Please enter the price as an integer!", "[0-9]+", null));
                });
                setContent(grid);
            }

            @Override
            public void onEnteringPage(Wizard wizard) {
                wizard.invalidProperty().unbind();
                wizard.invalidProperty().bind(vs.invalidProperty());
            }

        };
    }

    private WizardPane page3() {
        return new WizardPane() {

            {
                TextArea textArea = new TextArea();
            }

        };
    }

    private CheckBox createCheckBox(String id) {
        CheckBox checkBox = new CheckBox();
        checkBox.setId("isFurnished");
        getProperties().put(checkBox.getId(), checkBox.isSelected());
        checkBox.selectedProperty().addListener((observable, oldValue, newValue) -> getProperties().put(checkBox.getId(), newValue));
        return checkBox;
    }

    private TextField createTextField(String id) {
        TextField textField = new TextField();
        textField.setId(id);
        getProperties().put(textField.getId(), textField.getText());
        textField.textProperty().addListener((observable, oldValue, newValue) -> getProperties().put(id, newValue));
        GridPane.setHgrow(textField, Priority.ALWAYS);
        return textField;
    }

    private ComboBox<String> createComboBox(String id, ObservableList<String> items) {
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.setId(id);
        comboBox.setItems(items);
        comboBox.getSelectionModel().select(0);
        getProperties().put(comboBox.getId(), comboBox.getSelectionModel().getSelectedIndex());
        comboBox.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> getProperties().put(id, newValue));
        GridPane.setHgrow(comboBox, Priority.ALWAYS);
        return comboBox;
    }


}
