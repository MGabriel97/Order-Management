package model;

/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems
 *          Research Laboratory, http://dsrl.coned.utcluj.ro/
 * @Since: Apr 03, 2017
 */
public class Order {
	private int id;
	private String client;
	private int produs;
	private int cantitate;

	public Order(int id, String name, int pret,int cantitate ) {
		super();
		this.id = id;
		this.client = name;
		this.produs = pret;
		this.cantitate = cantitate;
	}

	public Order(String name, int pret,int cantitate) {
		super();
		this.client = name;

		this.produs = pret;
		this.cantitate = cantitate;
	}

	public int getId() {
		return id;
	}
	public String[] transform()
	{
		  String col[] =new String[4] ;
		  col[0]=""+id;
		  col[1]=client;
		  col[2]=""+produs;
		  col[3]=""+cantitate;
		  return col;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return client;
	}

	public void setName(String name) {
		this.client = name;
	}

	public int getPret() {
		return produs;
	}

	public void setPret(int address) {
		this.produs = address;
	}

	public int getCantitate() {
		return cantitate;
	}

	public void setCantitate(int cantitate) {
		this.cantitate = cantitate;
	}



	@Override
	public String toString() {
		return "Produs [id=" + id + ", name=" + client + ", pret=" + produs + ", cantitate=" + cantitate + ""+ "]";
	}

}