import org.junit.Before;
import org.junit.Test;
import org.netbeans.jemmy.QueueTool;
import org.netbeans.jemmy.operators.JButtonOperator;
import org.netbeans.jemmy.operators.JCheckBoxOperator;
import org.netbeans.jemmy.operators.JFrameOperator;
import org.netbeans.jemmy.operators.JTextFieldOperator;

import javax.swing.*;
import java.awt.*;

import static org.junit.Assert.*;
public class ViewTest {


    private JFrameOperator mainFrame;
    private QueueTool mainQueue;

    @Before
    public void getFrame() {
        String[] fd = new String[0];
        Main.main(fd);

        mainFrame = new JFrameOperator();
        mainQueue = new QueueTool();
        mainQueue.waitEmpty(1000);
    }

    @Test
    public void testTitleFrame() {
        String titleFrame = mainFrame.getTitle();
        assertEquals("Woordle", titleFrame);
        mainQueue.waitEmpty(1000);
    }

    @Test
    public void testKeyboardButtons() {
        JButtonOperator butn1 = new JButtonOperator(mainFrame, "Q");
        butn1.push();
        JTextFieldOperator Field = new JTextFieldOperator(mainFrame, 0);
        assertEquals("Q", Field.getText());
        mainQueue.waitEmpty(1000);
    }

    @Test
    public void testClearButton() {
        JButtonOperator butn1 = new JButtonOperator(mainFrame, "Q");
        JButtonOperator butn2 = new JButtonOperator(mainFrame, "W");
        JButtonOperator butn3 = new JButtonOperator(mainFrame, "E");
        JButtonOperator clear = new JButtonOperator(mainFrame, "Clear");
        JTextFieldOperator Field = new JTextFieldOperator(mainFrame, 0);

        butn1.push();
        butn2.push();
        butn3.push();

        assertEquals("QWE", Field.getText());
        clear.push();

        assertTrue(Field.getText().isEmpty());
        mainQueue.waitEmpty(1000);
    }

    @Test
    public void testBackspaceButton() {
        JButtonOperator butn1 = new JButtonOperator(mainFrame, "Q");
        JButtonOperator butn2 = new JButtonOperator(mainFrame, "W");
        JButtonOperator butn3 = new JButtonOperator(mainFrame, "E");
        JButtonOperator backSpace = new JButtonOperator(mainFrame, "BackSpace");
        JButtonOperator clear = new JButtonOperator(mainFrame, "Clear");
        JTextFieldOperator Field = new JTextFieldOperator(mainFrame, 0);

        butn1.push();
        butn2.push();
        butn3.push();

        assertEquals("QWE", Field.getText());

        backSpace.push();

        assertEquals("QW", Field.getText());

        clear.push();

        assertTrue(Field.getText().isEmpty());
        mainQueue.waitEmpty(1000);

    }

}
