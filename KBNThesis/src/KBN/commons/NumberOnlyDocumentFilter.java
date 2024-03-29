package KBN.commons;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class NumberOnlyDocumentFilter extends DocumentFilter {
    private int maxCharacters;

    public NumberOnlyDocumentFilter(int maxCharacters) {
        this.maxCharacters = maxCharacters;
    }

    public void setMaxCharacters(int maxCharacters) {
        this.maxCharacters = maxCharacters;
    }

    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
            throws BadLocationException {
        if (isValidInput(fb, offset, 0, string)) {
            super.insertString(fb, offset, string, attr);
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
            throws BadLocationException {
        if (isValidInput(fb, offset, length, text)) {
            super.replace(fb, offset, length, text, attrs);
        }
    }

    private boolean isValidInput(FilterBypass fb, int offset, int oldLength, String newText)
            throws BadLocationException {
        String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
        String updatedText = currentText.substring(0, offset) + newText + currentText.substring(offset + oldLength);

        return updatedText.length() <= maxCharacters && isNumeric(updatedText);
    }

    private boolean isNumeric(String text) {
        for (char c : text.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
