package edu.wpi.teamname;

import static org.testfx.api.FxAssert.verifyThat;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationExtension;

@ExtendWith(ApplicationExtension.class)
public class AppTest extends FxRobot {

  /** Setup test suite. */
  @BeforeAll
  public static void setup() throws Exception {
    if (Boolean.getBoolean("headless")) {
      System.setProperty("testfx.robot", "glass");
      System.setProperty("testfx.headless", "true");
      System.setProperty("prism.order", "sw");
      System.setProperty("prism.text", "t2k");
    }
    FxToolkit.registerPrimaryStage();
    FxToolkit.setupApplication(App.class);
  }

  @AfterAll
  public static void cleanup() {}

  @Test
  public void testButtonDisabled() {
    // Arrange
    // Act
    // Assert
    verifyThat("#computeButton", Node::isDisabled);
  }

  @Test
  public void testButton() {
    // Arrange
    TextField amountField = lookup("#amountField").query();

    TextField rateField = lookup("#rateField").query();

    TextField yearField = lookup("#yearField").query();

    Button b = lookup("#computeButton").queryButton();
    Label totalLabel = lookup("#totalLabel").query();

    // Act
    clickOn(amountField).write("100000");
    clickOn(rateField).write(".005");
    clickOn(yearField).write("1");
    // Assert
    verifyThat(b, (b_) -> !b_.isDisabled());

    // Act
    clickOn(b);

    // Assert
    verifyThat(totalLabel, (l) -> "8355.92".equals(l.getText()));
  }

  @Test
  public void testClose(FxRobot robot) {
    robot.press(KeyCode.ALT, KeyCode.F4);
  }
}
