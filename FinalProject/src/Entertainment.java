import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Entertainment extends Foods{
	private ArrayList<Purchase>entertainments;
	
	public Entertainment(int limit) {
		super(limit);
		this.entertainments = new ArrayList<Purchase>();
	}
	
	public int getLimit() {
		return limit;
	}
	
	public void addEntertainments(String name, int price) {
		Purchase pur = new Purchase(name, price);
		entertainments.add(pur);
		try {
			FileWriter writer = new FileWriter("entertainments.txt");
			writer.write(name + " " + price);
			writer.close();
			System.out.println("記錄成功！");
		}catch(IOException e) {
			System.out.println(e);
		}
	}
	
	public int getTotal() {
		int total = 0;
		for(Purchase p: entertainments) {
			total = total + p.getPrice();
		}
		return total;
	}
	
	public String detail() {
		String detail = "";
		for(Purchase p: entertainments) {
			detail = detail + p.getName() + " " + p.getPrice() + "\n";
		}
		detail = "娛樂: \n" + detail + "\nTotal: " + this.getTotal() + "\n";
		return detail;
	}
	
	public void alert() {
		super.alert();
	}
}