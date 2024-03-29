package es.unileon.ulebank.handler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.exceptions.MalformedHandlerException;

public class BankHandler implements Handler {
	
	/** * The number of digits */
	private static final int BANK_NUMBER_DIGITS = 4;
	/** * Bank's number */
	private final String number;

	/**
	 * * Creates a new Bank handler * * @param number * ( The number ) * @throws
	 * MalformedHandlerException * (If the bank isn't correct )
	 */
	public BankHandler(String number) throws MalformedHandlerException {
		Pattern numberPattern = Pattern.compile("^[0-9]*$");
		Matcher matcher = numberPattern.matcher(number);
		if (matcher.find() && number.length() == BANK_NUMBER_DIGITS) {
			this.number = number;
		} else {
			String error = "Error, the number hasn't " + BANK_NUMBER_DIGITS
					+ " digits or has letters \n";
			throw new MalformedHandlerException(error);
		}
	}

	public int compareTo(Handler another) {
		return this.toString().compareTo(another.toString());
	}

	/** * toString method * * @return ( Return the number) */
	@Override
	public String toString() {
		return this.number;
	}
	
}