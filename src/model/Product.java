package model;

/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems
 *          Research Laboratory, http://dsrl.coned.utcluj.ro/
 * @Since: Apr 03, 2017
 */
public class Product {
	private int id;
	private String name;
	private int pret;
	private int cantitate;

	public Product(int id, String name, int pret,int cantitate ) {
		super();
		this.id = id;
		this.name = name;
		this.pret = pret;
		this.cantitate = cantitate;
	}

	public Product(String name, int pret,int cantitate) {
		super();
		this.name = name;

		this.pret = pret;
		this.cantitate = cantitate;
	}

	public int getId() {
		return id;
	}
	public String[] transform()
	{
		  String col[] =new String[4] ;
		  col[0]=""+id;
		  col[1]=name;
		  col[2]=""+pret;
		  col[3]=""+cantitate;
		  return col;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPret() {
		return pret;
	}

	public void setPret(int address) {
		this.pret = address;
	}

	public int getCantitate() {
		return cantitate;
	}

	public void setCantitate(int cantitate) {
		this.cantitate = cantitate;
	}



	@Override
	public String toString() {
		return "Produs [id=" + id + ", name=" + name + ", pret=" + pret + ", cantitate=" + cantitate + ""+ "]";
	}

}