package es.unileon.ulebank.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Searcher {
	
	/** Logger for this class and subclasses **/
	protected final Log logger = LogFactory.getLog(getClass());

	private String id;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
		logger.info("Id set to " + id);
	}
	
}