package sd.cin.ufpe.br.controller.dao;

import sd.cin.ufpe.br.controller.Filesd;

public class FilesSdDAO extends GenericDAO<Filesd>{

	
	private static FilesSdDAO fileDAO = null;
	
	protected FilesSdDAO() {
		super(Filesd.class);
		// TODO Auto-generated constructor stub
	}
	
	
	public static FilesSdDAO getInstance()
	{
		if (fileDAO == null)
		{
			fileDAO = new FilesSdDAO();
		}
		return fileDAO;
	}
	
}
