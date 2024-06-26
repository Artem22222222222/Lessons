

import javax.swing.*;
import java.awt.*;

public class MyCellRenderer extends JLabel implements ListCellRenderer<Contact> {

    private Model model;
    private static final Font FONT = new Font("Basic", Font.BOLD, 13);

    public MyCellRenderer(Model model) {
        setOpaque(true);
        setFont(FONT);
        this.model = model;
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Contact> list, Contact contact, int index,
                                                  boolean isSelected, boolean cellHasFocus) {
        setText(model.toString());

        // Робимо квадратну обводку
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        setBackground(isSelected ? list.getSelectionBackground() : list.getBackground());
        setForeground(isSelected ? list.getSelectionForeground() : list.getForeground());
        return this;
    }
}
