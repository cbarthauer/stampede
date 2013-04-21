/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

/**
 *
 * @author cbarthauer
 */
public interface MumpsSyntaxError {
    /**
     * Get the character position of the error.
     * 
     * @return Numeric value of character position
     */
    public int getCharPositionInLine();
    
    /**
     * Get the unique identifier for the MUMPS routine
     * containing this error.
     * 
     * @return Unique identifier
     */
    public String getIdentifier();
    
    /**
     * Get the line number where the error occurs.
     * 
     * @return Numeric value of line number
     */
    public int getLine();
    
    /**
     * Get the text of the error message.
     * 
     * @return Error message
     */
    public String getMessage();
}
