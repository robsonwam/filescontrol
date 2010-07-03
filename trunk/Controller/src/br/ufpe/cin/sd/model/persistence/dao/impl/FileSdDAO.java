package br.ufpe.cin.sd.model.persistence.dao.impl;

import br.ufpe.cin.sd.model.business.entities.FileSd;
import br.ufpe.cin.sd.model.persistence.dao.GenericDAO;

@SuppressWarnings("unchecked")
public class FileSdDAO extends GenericDAO<FileSd> {

	private static FileSdDAO filesdDAO = null;
	
	public static FileSdDAO getInstance()
	{
		if (filesdDAO == null)
		{
			filesdDAO = new FileSdDAO();
		}
		return filesdDAO;
	}
	
	
	protected FileSdDAO() {
		super(FileSd.class);
	}

}
