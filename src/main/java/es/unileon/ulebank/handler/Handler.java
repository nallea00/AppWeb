package es.unileon.ulebank.handler;

public interface Handler {

    /**
     * Compare the actual handler with another
     *
     * @param another ( Handler to compare )
     * @return (0 if are equals, != 0 otherwise )
     */
    public int compareTo(Handler another);

    /**
     *
     * @return
     */
    @Override
    public String toString();
}
