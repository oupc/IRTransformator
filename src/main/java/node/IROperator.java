package node;

import org.eclipse.jdt.core.dom.Assignment;
import org.eclipse.jdt.core.dom.InfixExpression;

import java.util.HashMap;
import java.util.Map;

public class IROperator {
    private String token;

    /**
     * Creates a new infix operator with the given token.
     * <p>
     * Note: this constructor is private. The only instances
     * ever created are the ones for the standard operators.
     * </p>
     *
     * @param token the character sequence for the operator
     */
    private IROperator(String token) {
        this.token = token;
    }

    /**
     * Returns the character sequence for the operator.
     *
     * @return the character sequence for the operator
     */
    @Override
    public String toString() {
        return this.token;
    }

    public IROperator(InfixExpression.Operator operator){
        this.token = operator.toString();
    }

    /** Multiplication "*" operator. */
    public static final IROperator TIMES = new IROperator("*");//$NON-NLS-1$
    /** Division "/" operator. */
    public static final IROperator DIVIDE = new IROperator("/");//$NON-NLS-1$
    /** Remainder "%" operator. */
    public static final IROperator REMAINDER = new IROperator("%");//$NON-NLS-1$
    /** Addition (or string concatenation) "+" operator. */
    public static final IROperator PLUS = new IROperator("+");//$NON-NLS-1$
    /** Subtraction "-" operator. */
    public static final IROperator MINUS = new IROperator("-");//$NON-NLS-1$
    /** Left shift "&lt;&lt;" operator. */
    public static final IROperator LEFT_SHIFT = new IROperator("<<");//$NON-NLS-1$
    /** Signed right shift "&gt;&gt;" operator. */
    public static final IROperator RIGHT_SHIFT_SIGNED = new IROperator(">>");//$NON-NLS-1$
    /** Unsigned right shift "&gt;&gt;&gt;" operator. */
    public static final IROperator RIGHT_SHIFT_UNSIGNED =
            new IROperator(">>>");//$NON-NLS-1$
    /** Less than "&lt;" operator. */
    public static final IROperator LESS = new IROperator("<");//$NON-NLS-1$
    /** Greater than "&gt;" operator. */
    public static final IROperator GREATER = new IROperator(">");//$NON-NLS-1$
    /** Less than or equals "&lt;=" operator. */
    public static final IROperator LESS_EQUALS = new IROperator("<=");//$NON-NLS-1$
    /** Greater than or equals "&gt=;" operator. */
    public static final IROperator GREATER_EQUALS = new IROperator(">=");//$NON-NLS-1$
    /** Equals "==" operator. */
    public static final IROperator EQUALS = new IROperator("==");//$NON-NLS-1$
    /** Not equals "!=" operator. */
    public static final IROperator NOT_EQUALS = new IROperator("!=");//$NON-NLS-1$
    /** Exclusive OR "^" operator. */
    public static final IROperator XOR = new IROperator("^");//$NON-NLS-1$
    /** Inclusive OR "|" operator. */
    public static final IROperator OR = new IROperator("|");//$NON-NLS-1$
    /** AND "&amp;" operator. */
    public static final IROperator AND = new IROperator("&");//$NON-NLS-1$
    /** Conditional OR "||" operator. */
    public static final IROperator CONDITIONAL_OR = new IROperator("||");//$NON-NLS-1$
    /** Conditional AND "&amp;&amp;" operator. */
    public static final IROperator CONDITIONAL_AND = new IROperator("&&");//$NON-NLS-1$

    /**
     * Map from token to operator (key type: <code>String</code>;
     * value type: <code>Operator</code>).
     */
    private static final Map CODES;
    static {
        CODES = new HashMap(20);
        IROperator[] ops = {
                TIMES,
                DIVIDE,
                REMAINDER,
                PLUS,
                MINUS,
                LEFT_SHIFT,
                RIGHT_SHIFT_SIGNED,
                RIGHT_SHIFT_UNSIGNED,
                LESS,
                GREATER,
                LESS_EQUALS,
                GREATER_EQUALS,
                EQUALS,
                NOT_EQUALS,
                XOR,
                OR,
                AND,
                CONDITIONAL_OR,
                CONDITIONAL_AND,
        };
        for (int i = 0; i < ops.length; i++) {
            CODES.put(ops[i].toString(), ops[i]);
        }
    }

    /**
     * Returns the infix operator corresponding to the given string,
     * or <code>null</code> if none.
     * <p>
     * <code>toOperator</code> is the converse of <code>toString</code>:
     * that is, <code>Operator.toOperator(op.toString()) == op</code> for
     * all operators <code>op</code>.
     * </p>
     *
     * @param token the character sequence for the operator
     * @return the infix operator, or <code>null</code> if none
     */

}
