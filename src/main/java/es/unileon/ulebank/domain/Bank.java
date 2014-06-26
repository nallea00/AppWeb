package es.unileon.ulebank.domain;

import java.util.ArrayList;
import java.util.List;

import es.unileon.ulebank.exceptions.MalformedHandlerException;
import es.unileon.ulebank.handler.BankHandler;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.handler.OfficeHandler;

public class Bank {

    private final String bankId;
	
    private final List<Office> offices;

    public Bank(String bankId) throws MalformedHandlerException {
        Handler idBank = new BankHandler(bankId);
        this.bankId = idBank.toString();
        this.offices = new ArrayList<Office>();
    }

    public boolean addOffice(Office office) {
        if ((office != null)
                && (this.searchOffice(new OfficeHandler(office.getOfficeId())) == null)) {
            return this.offices.add(office);
        }
        return false;
    }

    public boolean removeOffice(Handler officeId) {
        boolean removed = false;
        if (officeId != null) {
            int i = -1;
            while ((++i < this.offices.size()) && !removed) {
                if (this.offices.get(i).getOfficeId().compareTo(officeId.toString()) == 0) {
                    this.offices.remove(i);
                    removed = true;
                }
            }
        }
        return removed;
    }

    public Office searchOffice(Handler officeId) {
        Office result = null;
        int i = -1;
        while ((++i < this.offices.size()) && (result == null)) {
            if (this.offices.get(i).getOfficeId().compareTo(officeId.toString()) == 0) {
                result = this.offices.get(i);
            }
        }
        return result;
    }

}