package modelo;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

public class Pedido {
	private int id;
	private LocalDate fecha;
	private Festival festival;
	private List<ItemPedido> items;
	
	
	public Pedido(int id, LocalDate fecha,  Festival festival, List<ItemPedido> items) {
		this.setId(id);
		this.setFecha(fecha);
	    this.festival = festival;
		this.setItems(items);
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public List<ItemPedido> getItems() {
		return items;
	}
	public void setItems(List<ItemPedido> items) {
		this.items = items;
	}
	
	public Festival getFestival() {
	    return festival;
	}
	
	public double calcularTotal()
	{
	    double total = 0;

	    for(ItemPedido item : items)
	    {
	        total += item.getPlato().getPrecioVenta()
	                * item.getCantidad();
	    }

	    return total;
	}

	
	
	
}
