import java.awt.Color;
import java.awt.Graphics;
import javax.swing.plaf.basic.BasicTextFieldUI;
import javax.swing.text.JTextComponent;
public class JTextFieldPlaceholder extends BasicTextFieldUI {
    private String hint;
    private Color hintColor;

    public JTextFieldPlaceholder(String hint, Color hintColor) {
        this.hint = hint;
        this.hintColor = hintColor;
    }

    @Override
    protected void paintSafely(Graphics g) {
        super.paintSafely(g);
        JTextComponent comp = getComponent();
        if (comp.getText().length() == 0 && !comp.hasFocus()) {
            g.setColor(hintColor);
            int padding = (comp.getHeight() - comp.getFont().getSize()) / 2;
            int inset = 3;
            g.drawString(hint, inset, comp.getHeight() - padding - inset);
        }
    }
}